package com.none;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4012_end {
	static int T, test_case;
	static int n, result;
	static boolean[] sel;
	static int[][] jmt;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/4012.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine().trim());

		for (test_case = 1; test_case <= T; test_case++) {
			result = Integer.MAX_VALUE;
			
			n = Integer.parseInt(br.readLine().trim());
			jmt = new int[n][n];
			sel = new boolean[n];
			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < n; j++) {
					jmt[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			johab(0, 0);
			
			System.out.println("#" + test_case + " " + result);
		}

		br.close();
	}

	private static void johab(int start, int cnt) {
		if(cnt == n / 2) {
			int a = 0, b = 0, sub = 0;
			
			for (int i = 0; i < n; i++) {
				if(sel[i]) {
					for (int j = 0; j < n; j++) {
						if(sel[j] && i != j) {
							a += jmt[i][j];
						}
					}
				} else {
					for (int j = 0; j < n; j++) {
						if(!sel[j] && i != j) {
							b += jmt[i][j];
						}
					}
				}
			}
			
			if(a > b) {
				sub = a - b;
			} else {
				sub = b - a;
			}
			
			result = result < sub ? result : sub;
			
			return;
		}
		
		for (int i = start; i < n - 1; i++) {
			sel[i] = true;
			johab(i + 1, cnt + 1);
			sel[i] = false;
		}
	}
}
