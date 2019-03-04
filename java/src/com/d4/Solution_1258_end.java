package com.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1258_end {
	static int T, test_case;
	static int n, index;
	static int[][] map;
	/**
	 * result[i][0] : 행
	 * result[i][1] : 열
	 * result[i][2] : 곱
	 */
	static int[][] result = new int[10000][3];
	static boolean[][] check;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/1258.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine().trim());

		for (test_case = 1; test_case <= T; test_case++) {
			for (int i = 0; i < 10000; i++) {
				result[i][0] = 0;
				result[i][1] = 0;
				result[i][2] = 0;
			}
			index = 0;
			
			n = Integer.parseInt(br.readLine().trim());
			map = new int[n][n];
			check = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if(!check[i][j] && map[i][j] != 0) {
						int y = 1, x = 1;
						
						for (int ii = i + 1; ii < n; ii++) {
							if(map[ii][j] != 0) {
								y++;
							} else {
								break;
							}
						}
						
						for (int jj = j + 1; jj < n; jj++) {
							if(map[i][jj] != 0) {
								x++;
							} else {
								break;
							}
						}
						
						for (int ii = i; ii < i + y; ii++) {
							for (int jj = j; jj < j + x; jj++) {
								check[ii][jj] = true;
							}
						}

						result[index][0] = y;
						result[index][1] = x;
						result[index++][2] = y * x;
					}
				}
			}
			
			for (int i = 0; i < index; i++) {
//				System.out.println(result[i][0] + ", " + result[i][1] + " = " + result[i][2]);
				for (int j = i + 1; j < index; j++) {
					int temp;
					if(result[i][2] > result[j][2]) {
						for (int k = 0; k < 3; k++) {
							temp = result[i][k];
							result[i][k] = result[j][k];
							result[j][k] = temp;
						}
					} else if(result[i][2] == result[j][2]) {
						if(result[i][0] > result[j][0]) {
							for (int k = 0; k < 3; k++) {
								temp = result[i][k];
								result[i][k] = result[j][k];
								result[j][k] = temp;
							}
						}
					}
				}
			}
			
			sb.append("#").append(test_case).append(" ").append(index);
			for (int i = 0; i < index; i++) {
				sb.append(" ").append(result[i][0]).append(" ").append(result[i][1]);
			}
			sb.append("\n");
		}
		System.out.println(sb);

		br.close();
	}
}
