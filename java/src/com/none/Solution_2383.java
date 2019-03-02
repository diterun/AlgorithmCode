package com.none;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2383 {
	static int MAX = 10;
	static int T, test_case, n, result, input, huIndex, stIndex, huMax;
	/**
	 * human[i][0] - i번째 사람의 y축 human[i][1] - i번째 사람의 x축
	 */
	static int[][] human = new int[MAX][2];
	/**
	 * i번째 계단의 stair[i][0] - y축 stair[i][1] - x축 stair[i][2] - 길이(분)
	 */
	static int[][] stair = new int[2][3];
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/2383.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine().trim());

		for (test_case = 1; test_case <= T; test_case++) {
			/** 초기화 */
			huIndex = stIndex = 0;
			result = 10000000;

			/** 입력 */
			n = Integer.parseInt(br.readLine().trim());
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					input = st.nextToken().charAt(0) - '0';

					if (input == 1) {
						human[huIndex][0] = i;
						human[huIndex++][1] = j;
					} else if (input > 1) {
						stair[stIndex][0] = i;
						stair[stIndex][1] = j;
						stair[stIndex++][2] = input;
					}
				}
			}
			
			boolean[] humans1 = new boolean[huIndex];

			int sub = 0, y, x;
			for (int i = 0; i < huIndex; i++) {
				y = stair[0][0] - human[i][0];
				x = stair[0][1] - human[i][1];
					
				y = y < 0 ? -y : y;
				x = x < 0 ? -x : x;
				
				sub += (x + y);
			}

			result = result < sub ? result : sub;
			
			sub = 0;
			for (int i = 0; i < huIndex; i++) {
				y = stair[1][0] - human[i][0];
				x = stair[1][1] - human[i][1];
					
				y = y < 0 ? -y : y;
				x = x < 0 ? -x : x;
				
				sub += (x + y);
			}

			result = result < sub ? result : sub;

			for (huMax = 1; huMax < huIndex; huMax++) {
				getResult(0, humans1, 0);
			}
//			for (int i = 0; i < huIndex; i++) {
//				System.out.println(i + "번째 사람 위치 : " + human[i][1] + ", " + human[i][0]);
//			}
//			
//			System.out.println("1번째 계단 위치 : " + stair[0][1] + ", " + stair[0][0] + " : " + stair[0][2]);
//			System.out.println("2번째 계단 위치 : " + stair[1][1] + ", " + stair[1][0] + " : " + stair[1][2]);

			System.out.println("#" + test_case + " " + result);
		}

		br.close();
	}

	private static void getResult(int start, boolean[] hu, int cnt) {
		if(cnt == huMax) {
			int subResult = 0;
			int x, y;
			
			for (int i = 0; i < huIndex; i++) {
				if(hu[i]) { //1번 계단을 이용하는 사람들
					y = stair[0][0] - human[i][0];
					x = stair[0][1] - human[i][1];
				} else {	//2번 계단을 이용하는 사람들
					y = stair[1][0] - human[i][0];
					x = stair[1][1] - human[i][1];
				}
				y = y < 0 ? -y : y;
				x = x < 0 ? -x : x;
				
				subResult += (x + y);
			}
			
			result = result < subResult ? result : subResult;
		}
		
		for (int i = start; i < huIndex; i++) {
			hu[i] = true;
			getResult(i + 1, hu, cnt + 1);
			hu[i] = false;
		}
	}

}
