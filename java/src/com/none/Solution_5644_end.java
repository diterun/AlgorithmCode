package com.none;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5644_end {
	static int MAX = 11;
	static int T, test_case, result, m, a, dis;
	static int y1, x1, y2, x2, use1, use2, size1, size2, temp;
	static int[][][] map = new int[MAX][MAX][MAX];
	static int[][] command;
	static int[] bc;
	/**
	 * 1 : 상, 2 : 우, 3 : 하, 4 : 좌
	 */
	static int[][] move = { { 0, 0 }, { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static StringTokenizer st, st2;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/5644.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine().trim());

		for (test_case = 1; test_case <= T; test_case++) {
			/** 초기화 */
			for (int i = 0; i < MAX; i++) {
				for (int j = 0; j < MAX; j++) {
					for (int k = 0; k < MAX; k++) {
						map[i][j][k] = 0;
					}
				}
			}
			result = 0;

			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());

			/** 가장 처음에 움직이지 않았을 0초때를 넣기 위해 m + 1개 공간 사용 */
			command = new int[2][m + 1];
			/** index를 bc의 번호로 쓰기 위해 a + 1개 공간 사용 */
			bc = new int[a + 1];

			st = new StringTokenizer(br.readLine());
			st2 = new StringTokenizer(br.readLine());

			for (int i = 1; i <= m; i++) {
				command[0][i] = Integer.parseInt(st.nextToken());
				command[1][i] = Integer.parseInt(st2.nextToken());
			}

			for (int k = 1; k <= a; k++) {
				st = new StringTokenizer(br.readLine());
				x1 = Integer.parseInt(st.nextToken());
				y1 = Integer.parseInt(st.nextToken());
				dis = Integer.parseInt(st.nextToken());

				bc[k] = Integer.parseInt(st.nextToken());

				for (int i = 1; i < MAX; i++) {
					for (int j = 1; j < MAX; j++) {
						x2 = x1 - j;
						y2 = y1 - i;

						x2 = x2 < 0 ? -x2 : x2;
						y2 = y2 < 0 ? -y2 : y2;

						if (dis >= x2 + y2) {
							map[i][j][map[i][j][10]++] = k;
						}
					}
				}
			}

			/** 초기 위치 설정 */
			y1 = x1 = 1;
			y2 = x2 = 10;
			
//			for (int i = 1; i < MAX; i++) {
//				for (int j = 1; j < MAX; j++) {
//					System.out.print(map[i][j][10] + " ");
//				}
//				System.out.println();
//			}

			for (int c = 0; c <= m; c++) {
				y1 += move[command[0][c]][0];
				x1 += move[command[0][c]][1];
				y2 += move[command[1][c]][0];
				x2 += move[command[1][c]][1];

				use1 = use2 = 0;

				size1 = map[y1][x1][10];
				size2 = map[y2][x2][10];

				if (size1 >= 2 && size2 < 2) {
					use2 = map[y2][x2][0];
					
					for (int i = 0; i < size1; i++) {
						temp = map[y1][x1][i];
						if(bc[use1] < bc[temp] && temp != use2) {
							use1 = temp;
						}
					}
					result += bc[use1] + bc[use2];
				} else if (size1 < 2 && size2 >= 2) {
					use1 = map[y1][x1][0];
					
					for (int i = 0; i < size2; i++) {
						temp = map[y2][x2][i];
						if(bc[use2] < bc[temp] && temp != use1) {
							use2 = temp;
						}
					}
					result += bc[use1] + bc[use2];
				} else if (size1 >= 2 && size2 >= 2) {
					for (int i = 0; i < size1; i++) {
						temp = map[y1][x1][i];
						if(bc[use1] < bc[temp]) {
							use1 = temp;
						}
					}
					for (int i = 0; i < size2; i++) {
						temp = map[y2][x2][i];
						if(bc[use2] < bc[temp] && temp != use1) {
							use2 = temp;
						}
					}
					int sub1 = bc[use1] + bc[use2];
					use1 = use2 = 0;
					for (int i = 0; i < size2; i++) {
						temp = map[y2][x2][i];
						if(bc[use2] < bc[temp]) {
							use2 = temp;
						}
					}
					for (int i = 0; i < size1; i++) {
						temp = map[y1][x1][i];
						if(bc[use1] < bc[temp] && temp != use2) {
							use1 = temp;
						}
					}
					int sub2 = bc[use1] + bc[use2];
					
					result += Math.max(sub1, sub2);
				} else {
					use1 = map[y1][x1][0];
					use2 = map[y2][x2][0];
					
					if(use1 == use2) {
						use2 = 0;
					}
					
					result += bc[use1] + bc[use2];
				}
			}

			System.out.println("#" + test_case + " " + result);
		}

		br.close();
	}

}
