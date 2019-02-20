package com.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_7088_end {
	static int MAX = 100001;
	static int T, test_case;
	static int n, q, l, r, a;
	static int[][] left = new int[MAX][4];
	static String[] inS;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/7088.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine().trim());

		for (test_case = 1; test_case <= T; test_case++) {
			for (int i = 0; i < MAX; i++) {
				left[i][0] = 0;
				left[i][1] = 0;
				left[i][2] = 0;
				left[i][3] = 0;
			}
			
			inS = br.readLine().split(" ");
			n = Integer.parseInt(inS[0]);
			q = Integer.parseInt(inS[1]);

			
			for (int i = 1; i <= n; i++) {
				a = Integer.parseInt(br.readLine());
				left[i][1] = left[i - 1][1];
				left[i][2] = left[i - 1][2];
				left[i][3] = left[i - 1][3];
				
				left[i][a]++;
			}
			
			System.out.println("#" + test_case);
			for (int i = 0; i < q; i++) {
				inS = br.readLine().split(" ");
				l = Integer.parseInt(inS[0]);
				r = Integer.parseInt(inS[1]);
				
				System.out.println((left[r][1] - left[l - 1][1]) + " " + 
						(left[r][2] - left[l - 1][2]) + " " + 
						(left[r][3] - left[l - 1][3]) + " ");
			}
		}

		br.close();
	}
}
