package com.d8;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_2455_Stains {
	static int T, t, n, m, c, result;
	static int[][] matt;

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/d8/2455.txt"));
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		for (t = 1; t <= T; ++t) {
			m = sc.nextInt();
			n = sc.nextInt();
			c = sc.nextInt();
			
			matt = new int[m][n];
			for (int i = 0; i < c; i++) {
				matt[sc.nextInt() - 1][sc.nextInt() - 1] = 1;
			}
			
		}
		
		sc.close();
	}
}
