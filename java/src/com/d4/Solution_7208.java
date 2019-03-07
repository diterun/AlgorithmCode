package com.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_7208 {
	static int T, test_case;
	static int n, result, now;
	static int[] nation;
	static int[][] naver;
	static boolean[] check;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder(2000);

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/7194.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine().trim());

		for (test_case = 1; test_case <= T; test_case++) {
			result = 0;
			
			n = Integer.parseInt(br.readLine().trim());
			nation = new int[n];
			naver = new int[n][n];
			check = new boolean[n];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				nation[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					naver[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			now = 0;
			check[0] = true;
			
			drowMap(0);
			
			sb.append("#").append(test_case).append(" ").append(result).append("\n");
		}
		System.out.println(sb);

		br.close();
	}

	private static void drowMap(int code) {
		int color = nation[code];
		boolean[] ok = new boolean[4];
		boolean allTrue = true;
		
		for (int i = 0; i < n; i++) {
			if(i != code) {
				if(naver[code][i] == 1) {
					ok[nation[i]] = true;
				}
			}
		}
		
		for (int i = 0; i < 4; i++) {
			if(!ok[i]) {
				allTrue = false;
			}
		}
		
		if(allTrue) {
			
		} else {
			
		}
	}
}
