package com.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_6485_end {
	static int MAX = 5010;
	static int[] station = new int[MAX];
	static int T, test_case, n, s, e, p, temp;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/6485.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine().trim());

		for (test_case = 1; test_case <= T; test_case++) {
			for (int i = 0; i < MAX; i++) {
				station[i] = 0;
			}

			n = Integer.parseInt(br.readLine().trim());
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine().trim());
				s = Integer.parseInt(st.nextToken());
				e = Integer.parseInt(st.nextToken());

				for (int j = s; j <= e; j++) {
					station[j]++;
				}
			}

			p = Integer.parseInt(br.readLine().trim());
			sb.append("#").append(test_case).append(" ");
			for (int i = 0; i < p; i++) {
				sb.append(station[Integer.parseInt(br.readLine().trim())]).append(" ");
			}
			sb.append("\n");
		}

		System.out.print(sb);

		br.close();
	}
}
