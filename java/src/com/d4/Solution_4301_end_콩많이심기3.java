package com.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4301_end_콩많이심기3 {
	static int T, t, n, m;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/d4/4301.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine().trim());

		for (t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			System.out.println("#" + t + " " + ((4 * ((n = Integer.parseInt(st.nextToken())) / 4) / 2) * (m = Integer.parseInt(st.nextToken())) + (4 * (m / 4) / 2) * (n = n % 4) + (n * (m = m % 4) / 2) + ((((n * m / 2) >> 1) & 1) ^ ((n * m / 2) & ((n * m / 2) >> 1))) + ((((n >> 1) | (n & 1)) & ((m >> 1) | (m & 1))) & 1)));
		}

		br.close();
	}
}