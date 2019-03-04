package com.d6;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1263 {
	static int INF = Integer.MAX_VALUE >> 1;
	static int T, test_case, result;
	static int n;
	static int[][] map;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/1263.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine().trim());

		for (test_case = 1; test_case <= T; test_case++) {
			result = INF;
			st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken());
			map = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 0) {
						map[i][j] = INF;
					}
				}
			}
			
			for (int k = 0; k < n; k++) {
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						if(map[i][j] > map[i][k] + map[k][j]) {
							map[i][j] = map[i][k] + map[k][j];
						}
					}
				}
			}
			
			for (int i = 0; i < n; i++) {
				int subSum = 0;
				for (int j = 0; j < n; j++) {
					if(i != j) {
						subSum += map[i][j];
					}
				}
				
				result = result < subSum ? result : subSum;
			}
			
			System.out.println("#" + test_case + " " + result);
		}

		br.close();
	}

}
