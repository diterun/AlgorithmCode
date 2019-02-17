package com.baek;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main_16234_end {
	static int MAX = 52;
	static int n, l, r, result;
	/** 각 나라의 인구수 정보 */
	static int[][] map = new int[MAX][MAX];
	/** 이동 */
	static int[][] move = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
	/** 해당 지역을 검사했는지 여부 */
	static boolean[][] check = new boolean[MAX][MAX];
	/** 국경이 하나라도 열렸는지 */
	static boolean moveToOther;
	/** 연합과 연합 큐 */
	static LinkedList<Integer> united = new LinkedList<>();
	static LinkedList<Integer> unitedQ = new LinkedList<>();
	static String[] line;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/baek16234.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		/** 초기화 */
		result = 0;
		moveToOther = false;
		for (int i = 0; i < MAX; i++) {
			for (int j = 0; j < MAX; j++) {
				map[i][j] = 1000; // 절대로 나올 수 없는 인구수.(주변은 모두 닫힌다.)
				check[i][j] = false;
			}
		}

		line = br.readLine().split(" ");
		n = Integer.parseInt(line[0]);
		l = Integer.parseInt(line[1]);
		r = Integer.parseInt(line[2]);

		for (int i = 1; i <= n; i++) {
			line = br.readLine().split(" ");
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(line[j - 1]);
			}
		}

		while (true) {
			/** 국경 열기 조사 */
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					unitedQ.clear();
					united.clear();

					if(!check[i][j]) {
						check[i][j] = true;
						int sum = map[i][j];
						int cnt = 1;
						unitedQ.push(i * 100 + j);
						united.push(i * 100 + j);
	
						while (!unitedQ.isEmpty()) {
							int num = unitedQ.pop();
							int ny = num / 100;
							int nx = num % 100;
	
							for (int k = 0; k < 4; k++) {
								int dy = ny + move[k][0];
								int dx = nx + move[k][1];
	
								int diff = map[ny][nx] - map[dy][dx];
								diff = diff > 0 ? diff : -diff;
	
								if (!check[dy][dx] && l <= diff && diff <= r) {
									moveToOther = true;
									check[dy][dx] = true;
	
									sum += map[dy][dx];
									cnt++;
									unitedQ.push(dy * 100 + dx);
									united.push(dy * 100 + dx);
								}
							}
						}
						
						/** 연합에 인구 나누기 */
						for (Integer num : united) {
							int ny = num / 100;
							int nx = num % 100;

							map[ny][nx] = sum / cnt;
						}
					}
				}
			}
			/** 연합이 없다면 끝! */
			if (moveToOther) {
				for (int i = 1; i <= n; i++) {
					for (int j = 1; j <= n; j++) {
						check[i][j] = false;
					}
				}
				result++;
				moveToOther = false;
			} else {
				break;
			}
		}

		System.out.println(result);

		br.close();
	}

}
