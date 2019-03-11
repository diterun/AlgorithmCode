package com.study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1_1 {
	static int T, t, n;
	static int[][] map;
	static int[][][] dp;
	static StringTokenizer st;
	static long start, end;

	public static void main(String[] args) throws Exception{
		start = System.nanoTime();
		System.setIn(new FileInputStream("res1/Solution1_1.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine().trim());
		
		for (t = 1; t <= T; t++) {
			n = Integer.parseInt(br.readLine().trim());
			
			map = new int[n + 2][n + 2];
			dp = new int[3][n + 2][n + 2];
			
			for (int i = 0; i < n + 2; i++) {
				for (int j = 0; j < n + 2; j++) {
					map[i][j] = 1;
					dp[0][i][j] = -1;
					dp[1][i][j] = -1;
					dp[2][i][j] = -1;
				}
			}
			
			for (int i = 2; i < n + 2; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 2; j < n + 2; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			if(map[n][n + 1] == 0 && map[n - 1][n + 1] == 0) {
				dp[1][n + 1][n + 1] = dfs(n + 1, n + 1, 2);
			} else {
				dp[1][n + 1][n + 1] = 0;
			}
			
			if(map[n + 1][n] == 0 && map[n + 1][n - 1] == 0) {
				dp[0][n + 1][n + 1] = dfs(n + 1, n + 1, 1);
			} else {
				dp[0][n + 1][n + 1] = 0;
			}
			
			System.out.println("#" + t + " " + (dp[0][n + 1][n + 1] + dp[1][n + 1][n + 1]));
		}
		br.close();
		end = System.nanoTime();
		System.out.println(end - start);
	}

	private static int dfs(int y, int x, int type) {
		if(y == 2 && x == 3 && type == 1) {
			return 1;
		}
		if(y == 3 && x == 2 && type == 2) {
			return 1;
		}
		int sub = 0;
		
		if(type == 1) {
			if(map[y][x - 1] == 0 && map[y][x - 2] == 0 && map[y - 1][x - 2] == 0 && map[y - 1][x - 1] == 0) {
				if(dp[0][y][x - 1] == -1) {
					dp[0][y][x - 1] = dfs(y, x - 1, 1);
				}
				if(dp[2][y][x - 1] == -1) {
					dp[2][y][x - 1] = dfs(y, x - 1, 3);
				}
				sub = dp[0][y][x - 1] + dp[2][y][x - 1];
			} else if(map[y][x - 1] == 0 && map[y][x - 2] == 0) {
				if(dp[0][y][x - 1] == -1) {
					dp[0][y][x - 1] = dfs(y, x - 1, 1);
				}
				sub = dp[0][y][x - 1];
			}
		} else if(type == 2) {
			if(map[y - 1][x] == 0 && map[y - 2][x] == 0 && map[y - 1][x - 1] == 0 && map[y - 2][x - 1] == 0) {
				if(dp[1][y - 1][x] == -1) {
					dp[1][y - 1][x] = dfs(y - 1, x, 2);
				}
				if(dp[2][y - 1][x] == -1) {
					dp[2][y - 1][x] = dfs(y - 1, x, 3);
				}
				sub = dp[1][y - 1][x] + dp[2][y - 1][x];
			} else if(map[y - 1][x] == 0 && map[y - 2][x] == 0) {
				if(dp[1][y - 1][x] == -1) {
					dp[1][y - 1][x] = dfs(y - 1, x, 2);
				}
				sub = dp[1][y - 1][x];
			}
		} else {
			if(map[y - 1][x - 1] == 0 && map[y - 2][x - 1] == 0 && map[y - 1][x - 2] == 0 && map[y - 2][x - 2] == 0) {
				if(dp[0][y - 1][x - 1] == -1) {
					dp[0][y - 1][x - 1] = dfs(y - 1, x - 1, 1);
				}
				if(dp[1][y - 1][x - 1] == -1) {
					dp[1][y - 1][x - 1] = dfs(y - 1, x - 1, 2);
				}
				if(dp[2][y - 1][x - 1] == -1) {
					dp[2][y - 1][x - 1] = dfs(y - 1, x - 1, 3);
				}
				sub = dp[0][y - 1][x - 1] + dp[1][y - 1][x - 1] + dp[2][y - 1][x - 1];
			} else if(map[y - 1][x - 1] == 0 && map[y - 2][x - 1] == 0 && map[y - 1][x - 2] == 0 && map[y - 2][x - 2] == 1) {
				if(dp[0][y - 1][x - 1] == -1) {
					dp[0][y - 1][x - 1] = dfs(y - 1, x - 1, 1);
				}
				if(dp[1][y - 1][x - 1] == -1) {
					dp[1][y - 1][x - 1] = dfs(y - 1, x - 1, 2);
				}
				sub = dp[0][y - 1][x - 1] + dp[1][y - 1][x - 1];
			} else if(map[y - 1][x - 1] == 0 && map[y - 2][x - 1] == 0) {
				if(dp[1][y - 1][x - 1] == -1) {
					dp[1][y - 1][x - 1] = dfs(y - 1, x - 1, 2);
				}
				sub = dp[1][y - 1][x - 1];
			} else if(map[y - 1][x - 1] == 0 && map[y - 1][x - 2] == 0) {
				if(dp[0][y - 1][x - 1] == -1) {
					dp[0][y - 1][x - 1] = dfs(y - 1, x - 1, 1);
				}
				sub = dp[0][y - 1][x - 1];
			}
		}
		
		return sub;
	}

}
