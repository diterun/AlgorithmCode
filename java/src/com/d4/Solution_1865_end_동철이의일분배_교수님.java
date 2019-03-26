package com.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Solution_1865_end_동철이의일분배_교수님 {
	public static int N, map[][];
	public static double memo[] = new double[1 << 16];

	public static double dfs(int cnt, int flag) {
		if (cnt == N)
			return 1;
		double res = memo[flag];
		if (res > 0)
			return res;
		res = 0;
		double max = 0;
		for (int i = 0; i < N; i++) {
			int now = 1 << i;
			if ((flag & now) == 0) {
				double next = dfs(cnt + 1, flag | now) * map[cnt][i];
				if (max < next)
					max = next;
			}
		}
		memo[flag] = max;
		return max;
	}

	public static void main(String[] ar) throws Exception {
		System.setIn(new FileInputStream("res/1865.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringTokenizer tokens;
		for (int testcase = 1; testcase <= T; testcase++) {
			N = Integer.parseInt(in.readLine());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				tokens = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(tokens.nextToken());
				}
			}
			Arrays.fill(memo, -1);
			double res = dfs(0, 0);
			System.out.printf("#%d %.6f\n", testcase, res / Math.pow(100, N - 1));
		}
	}
}