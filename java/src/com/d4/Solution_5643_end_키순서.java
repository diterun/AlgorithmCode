package com.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5643_end_키순서 {
	static int T, test_case, n, m, a, b;
	static int result;
	static boolean[][] key;
	static boolean[] check;
	static boolean[][] dap;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/5643.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine().trim());

		for (test_case = 1; test_case <= T; test_case++) {
			result = 0;

			n = Integer.parseInt(br.readLine().trim());
			m = Integer.parseInt(br.readLine().trim());
			key = new boolean[n + 1][n + 1];
			dap = new boolean[n + 1][n + 1];

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				
				key[a][b] = true;
			}

			for (int i = 1; i <= n; i++) {
				check = new boolean[n + 1];

				gogo(i);

				for (int j = 1; j <= n; j++) {
					if (check[j]) {
						dap[i][j] = true;
						dap[j][i] = true;
					}
				}
			}

			for (int i = 1; i <= n; i++) {
				boolean last = true;

				for (int j = 1; j <= n; j++) {
					if (!dap[i][j]) {
						last = false;
					}
				}

				if (last) {
					result++;
				}
			}

			System.out.println("#" + test_case + " " + result);
		}

		br.close();
	}

	private static void gogo(int num) {
		check[num] = true;

		for (int i = 1; i <= n; i++) {
			if (key[num][i] && !check[i]) {
				gogo(i);
			}
		}
	}
}