package com.d4;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_5643_end_키순서2 {
	static int T, test_case, n, m, a, b;
	static int result;
	/**
	 * [a][b][c]
	 * a - 내 번호
	 * b - 0 : 큰 애들, 1 : 작은 애들
	 * c - 상대방 번호 저장
	 */
	static boolean[][][] key;
	static String[] ins;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/5643.txt"));
		Scanner sc = new Scanner(System.in);

		T = Integer.parseInt(sc.nextLine().trim());

		for (test_case = 1; test_case <= T; test_case++) {
			result = 0;

			n = Integer.parseInt(sc.nextLine().trim());
			m = Integer.parseInt(sc.nextLine().trim());
			key = new boolean[n + 1][2][n + 1];
			
			for (int i = 0; i < m; i++) {
				ins = sc.nextLine().trim().split(" ");
				a = Integer.parseInt(ins[0]);
				b = Integer.parseInt(ins[1]);
				key[b][1][a] = true;
				key[a][0][b] = true;
			}
//			for (int i = 1; i <= n; i++) {
//				for (int j = 1; j <= n; j++) {
//					if(key[i][0][j]) {
//						System.out.print(j + ", ");
//					}
//				}
//				System.out.print(" > " + i + " > ");
//				for (int j = 1; j <= n; j++) {
//					if(key[i][1][j]) {
//						System.out.print(j + ", ");
//					}
//				}
//				System.out.println();
//			}
//			System.out.println();
			
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if(key[i][0][j]) {
						for (int k = 1; k <= n; k++) {
							if(key[i][1][k]) {
								key[j][1][k] = true;
							}
						}
					}
				}
				for (int j = 1; j <= n; j++) {
					if(key[i][1][j]) {
						for (int k = 1; k <= n; k++) {
							if(key[i][0][k]) {
								key[j][0][k] = true;
							}
						}
					}
				}
			}
			
			for (int i = 1; i <= n; i++) {
//				for (int j = 1; j <= n; j++) {
//					if(key[i][0][j]) {
//						System.out.print(j + ", ");
//					}
//				}
//				System.out.print(" > " + i + " > ");
//				for (int j = 1; j <= n; j++) {
//					if(key[i][1][j]) {
//						System.out.print(j + ", ");
//					}
//				}
//				System.out.println();
				int num = 0;
				for (int j = 1; j <= n; j++) {
					if(key[i][0][j]) {
						num++;
					}
				}
				for (int j = 1; j <= n; j++) {
					if(key[i][1][j]) {
						num++;
					}
				}
				if(num == n - 1) {
					result++;
				}
			}
			
			
			System.out.println("#" + test_case + " " + result);
		}

		sc.close();
	}
}
