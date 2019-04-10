package com.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5213_end {
	static int MAX = 1000002;
	static int T, test_case, l, r;
	static long[] sum = new long[MAX];
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/d4/5213.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine().trim());
		
		for (int i = 1; i < MAX; i++) {
			sum[i] += sum[i - 1];
			if(i % 2== 0) {
				continue;
			}
			for (int j = i; j < MAX; j += i) {
				sum[j] += i;
			}
		}

		for (test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			l = Integer.parseInt(st.nextToken()) - 1;
			r = Integer.parseInt(st.nextToken());
			
			sb.append("#").append(test_case).append(" ").append(sum[r] - sum[l]).append("\n");
		}
		System.out.print(sb);

		br.close();
	}
}
