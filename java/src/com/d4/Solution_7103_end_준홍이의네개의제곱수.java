package com.d4;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_7103_end_준홍이의네개의제곱수 {
	static int T, test_case, jeCnt;
	static int[] jegobsu = new int[200];
	static int[] results = new int[2000000];
	static StringBuilder sb = new StringBuilder(400);

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/d4/7103.txt"));
		Scanner sc = new Scanner(System.in);
		
		for (jeCnt = 1; jeCnt * jeCnt <= 32767; jeCnt++) {
			jegobsu[jeCnt] = jeCnt * jeCnt;
		}
		
		for (int i = 1; i < jeCnt; i++) {
			for (int j = i; j < jeCnt; j++) {
				for (int k = j; k < jeCnt; k++) {
					for (int l = k; l < jeCnt; l++) {
						results[jegobsu[i] + jegobsu[j] + jegobsu[k] + jegobsu[l]]++;
					}
					results[jegobsu[i] + jegobsu[j] + jegobsu[k]]++;
				}
				results[jegobsu[i] + jegobsu[j]]++;
			}
			results[jegobsu[i]]++;
		}

		T = sc.nextInt();

		for (test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ").append(results[sc.nextInt()]).append("\n");
		}
		System.out.print(sb);

		sc.close();
	}
}
