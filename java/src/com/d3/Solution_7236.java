package com.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_7236 {
	static int T, test_case, n, result;
	static char[][] map;
	static int[][] move = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/7236.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine().trim());

		for (test_case = 1; test_case <= T; test_case++) {
			result = 0;

			n = Integer.parseInt(br.readLine().trim());

			map = new char[n + 2][n + 2];

			for (int i = 0; i < n + 2; i++) {
				for (int j = 0; j < n + 2; j++) {
					map[i][j] = 'G';
				}
			}
			
			for (int i = 1; i <= n; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 1; j <= n; j++) {
					map[i][j] = st.nextToken().charAt(0);
				}
			}
			
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					int sub = 0;
					for (int k = 0; k < 8; k++) {
						if(map[i + move[k][0]][j + move[k][1]] == 'W'){
							sub++;
						}
					}
					sub = sub == 0 ? 1 : sub;
					result = result > sub ? result : sub;
				}
			}

			sb.append("#").append(test_case).append(" ").append(result).append("\n");
		}

		System.out.print(sb);

		br.close();
	}
}
