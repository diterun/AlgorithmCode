package com.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1494_end {
	static int T, test_case, n, jCnt;
	static int[][] jirungi;
	static long result;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/d4/1494.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine().trim());

		for (test_case = 1; test_case <= T; test_case++) {
			result = Long.MAX_VALUE;
			
			n = Integer.parseInt(br.readLine().trim());
			jCnt = n / 2;
			jirungi = new int[n][2];
			boolean[] check = new boolean[n];
			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());

				jirungi[i][0] = Integer.parseInt(st.nextToken());
				jirungi[i][1] = Integer.parseInt(st.nextToken());
			}
			
			johab(0, 0, check);
			
			sb.append("#").append(test_case).append(" ").append(result).append("\n");
		}
		System.out.println(sb);

		br.close();
	}

	private static void johab(int start, int cnt, boolean[] check) {
		if(cnt == jCnt) {
			long x1 = 0, y1 = 0, x2 = 0, y2 = 0;
			
			for (int i = 0; i < n; i++) {
				if(check[i]) {
					y1 += jirungi[i][0];
					x1 += jirungi[i][1];
				} else {
					y2 += jirungi[i][0];
					x2 += jirungi[i][1];
				}
			}
			
			long x = x1 - x2;
			long y = y1 - y2;
			long subResult = x * x + y * y;
			
			result = result < subResult ? result : subResult;
			
			return;
		}
		
		for (int i = start; i < n; i++) {
			check[i] = true;
			johab(i + 1, cnt + 1, check);
			check[i] = false;
		}
	}
}
