package com.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4301_end_콩많이심기2 {
	static int T, t, n, m, result;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/d4/4301.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine().trim());

		for (t = 1; t <= T; t++) {
			result = 0;

			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			result = (4 * (n / 4) / 2) * m + (4 * (m / 4) / 2) * (n % 4) + ((n % 4) * (m % 4) / 2) + (((((n % 4) * (m % 4) / 2) >> 1) & 1) ^ (((n % 4) * (m % 4) / 2) & (((n % 4) * (m % 4) / 2) >> 1))) + (((((n % 4) >> 1) | ((n % 4) & 1)) & (((m % 4) >> 1) | ((m % 4) & 1))) & 1);

			System.out.println("#" + t + " " + result);
		}

		br.close();
	}
}