package com.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_7465_창용마을무리의개수 {
	static int T, t, n, m, result;
	static boolean[][] rel;
	static boolean[] check;
	static boolean[] troops;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/d4/7465.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine().trim());

		for (t = 1; t <= T; t++) {
			result = 0;
			
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			rel = new boolean[n + 1][n + 1];
			check = new boolean[n + 1];
			troops = new boolean[n + 1];
			
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				rel[a][b] = true;
				rel[b][a] = true;
			}
			
			for (int i = 1; i <= n; i++) {
				if(!check[i]) {
					troops[i] = true;
					check[i] = true;
					getTroops(i, i);
				}
			}
			
			for (int i = 1; i <= n; i++) {
				if(troops[i]) {
					result++;
				}
			}
			
			System.out.println("#" + t + " " + result);
		}

		br.close();
	}

	private static void getTroops(int i, int team) {
		for (int j = 1; j <= n; j++) {
			if(!check[j] && rel[i][j]) {
				check[j] = true;
				getTroops(j, team);
			}
		}
	}
}
