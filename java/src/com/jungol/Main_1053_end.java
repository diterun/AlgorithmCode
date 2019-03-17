package com.jungol;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1053_end {
	static int[][] result;
	static int n;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("jungol/1053.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			n = Integer.parseInt(br.readLine().trim());
			if(n == -1) {
				break;
			}
			if(n <= 1) {
				System.out.println(n);
				continue;
			}
			
			result = new int[2][2];
			
			result = dfs(n - 1);

			System.out.println(result[0][0]);
		}
		br.close();
	}

	private static int[][] dfs(int number) {
		if(number <= 1) {
			int[][] a = {{number, number}, {number, 0}};
			return a;
		}
		
		if(number % 2 == 0) {
			int[][] temp1 = dfs(number / 2);
			int[][] temp2 = new int[2][2];

			temp2[0][0] = (temp1[0][0] * temp1[0][0] + temp1[0][1] * temp1[1][0]) % 10000;
			temp2[0][1] = (temp1[0][0] * temp1[0][1] + temp1[0][1] * temp1[1][1]) % 10000;
			temp2[1][0] = (temp1[1][0] * temp1[0][0] + temp1[1][1] * temp1[1][0]) % 10000;
			temp2[1][1] = (temp1[1][0] * temp1[0][1] + temp1[1][1] * temp1[1][1]) % 10000;

//			System.out.println("a " + number);
//			for (int i = 0; i < 2; i++) {
//				for (int j = 0; j < 2; j++) {
//					System.out.print(temp2[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
			return temp2;
		} else {
			int[][] temp1 = dfs(number / 2);
			int[][] temp2 = new int[2][2];
			int[][] temp3 = new int[2][2];

			temp2[0][0] = (temp1[0][0] * temp1[0][0] + temp1[0][1] * temp1[1][0]) % 10000;
			temp2[0][1] = (temp1[0][0] * temp1[0][1] + temp1[0][1] * temp1[1][1]) % 10000;
			temp2[1][0] = (temp1[1][0] * temp1[0][0] + temp1[1][1] * temp1[1][0]) % 10000;
			temp2[1][1] = (temp1[1][0] * temp1[0][1] + temp1[1][1] * temp1[1][1]) % 10000;

			temp3[0][0] = (temp2[0][0] + temp2[0][1]) % 10000;
			temp3[0][1] = (temp2[0][0]) % 10000;
			temp3[1][0] = (temp2[1][0] + temp2[1][1]) % 10000;
			temp3[1][1] = (temp2[1][0]) % 10000;

//			System.out.println("b " + number);
//			for (int i = 0; i < 2; i++) {
//				for (int j = 0; j < 2; j++) {
//					System.out.print(temp2[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
			return temp3;
		}
	}
}
