package com.d4;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_1865_end_동철이의일분배 {
	static int T, test_case;
	static int n;
	static int[][] p;
	static double result;
	static long start, end;

	public static void main(String[] args) throws Exception {
		start = System.nanoTime();
		System.setIn(new FileInputStream("res/d4/1865.txt"));
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();

		for (test_case = 1; test_case <= T; test_case++) {
			result = 0;
			n = sc.nextInt();
			p = new int[n][n];
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					p[i][j] = sc.nextInt();
				}
			}
			
			int[] giug = new int[n];
			
			for (int i = 0; i < n; i++) {
				giug[0] = i;
				dfs(giug, p[0][i], 1);
			}

			System.out.printf("#%d %f\n", test_case, result);
		}

		sc.close();
		end = System.nanoTime();
		System.out.println(end - start);
	}

	private static void dfs(int[] giug, double sub, int cnt) {
		if(cnt == n) {
			result = result > sub ? result : sub;
			return;
		}
		
		for (int i2 = 0; i2 < n; i2++) {
			if(p[cnt][i2] == 0) {
				continue;
			}
			
			boolean can = true;
//			System.out.print(i2 +" = ");
//			for (int j = 0; j < cnt; j++) {
//				System.out.print(giug[j] + " ");
//			}
//			System.out.println(": " + sub);
			
			for (int j = 0; j < cnt; j++) {
				if(i2 == giug[j]) {
					can = false;
					break;
				}
			}
			
			if(can) {
				double subsub = sub / 100 * p[cnt][i2];
				if(subsub < result) {
					continue;
				}
				giug[cnt] = i2;
				dfs(giug, subsub, cnt + 1);
			}
		}
	}
}
