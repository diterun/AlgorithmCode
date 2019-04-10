package com.baek;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1520_end {
	static int n, m, result;
	static int[][] map, dp;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/baek/1520.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine().trim());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n + 2][m + 2];
		dp = new int[n + 2][m + 2];
		
		for (int i = 0; i < n + 2; i++) {
			for (int j = 0; j < m + 2; j++) {
				dp[i][j] = -1;
			}
		}
		
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 1; j <= m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[n][m] = dfs(n, m);
		
//		for (int i = 1; i <= n; i++) {
//			for (int j = 1; j <= m; j++) {
//				System.out.print(dp[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		System.out.println(dp[n][m]);
		
		br.close();
	}

	private static int dfs(int n, int m) {
		if(n == 1 && m == 1) {
			return 1;
		}
		int sub = 0;

		if(map[n][m] < map[n - 1][m]) {
			if(dp[n - 1][m] == -1) {
				dp[n - 1][m] = dfs(n - 1, m);
			}
			sub += dp[n - 1][m];
		}
		if(map[n][m] < map[n + 1][m]) {
			if(dp[n + 1][m] == -1) {
				dp[n + 1][m] = dfs(n + 1, m);
			}
			sub += dp[n + 1][m];
		}
		if(map[n][m] < map[n][m - 1]) {
			if(dp[n][m - 1] == -1) {
				dp[n][m - 1] = dfs(n, m - 1);
			}
			sub += dp[n][m - 1];
		}
		if(map[n][m] < map[n][m + 1]) {
			if(dp[n][m + 1] == -1) {
				dp[n][m + 1] = dfs(n, m + 1);
			}
			sub += dp[n][m + 1];
		}
		
		return sub;
	}
}
