package com.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_7234_end {
	static int T, test_case, n, b, y, x, result;
	static int[][] map;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/d3/7234.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine().trim());

		for (test_case = 1; test_case <= T; test_case++) {
			result = 0;
			
			st = new StringTokenizer(br.readLine().trim());

			n = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			map = new int[n + 4][n + 4];
			
//			System.out.println(n);
			for (int i = 0; i < b; i++) {
				st = new StringTokenizer(br.readLine().trim());
				y = Integer.parseInt(st.nextToken()) + 1;
				x = Integer.parseInt(st.nextToken()) + 1;
//				System.out.println(y + " , " + x);
				for (int j = y - 2; j <= y + 2; j++) {
					map[j][x]++;
				}
				for (int j = x - 2; j <= x + 2; j++) {
					map[y][j]++;
				}
				map[y][x]--;
			}
			
			for (int i = 2; i < n + 2; i++) {
				for (int j = 2; j < n + 2; j++) {
					System.out.print(map[i][j] + " ");
					result = result > map[i][j] ? result : map[i][j];
				}
				System.out.println();
			}

			sb.append("#").append(test_case).append(" ").append(result).append("\n");
		}

		System.out.print(sb);

		br.close();
	}
}
