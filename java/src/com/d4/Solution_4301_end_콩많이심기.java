package com.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4301_end_콩많이심기 {
	static int T, t, n, m, result;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/4301.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine().trim());

		for (t = 1; t <= T; t++) {
			result = 0;

			st = new StringTokenizer(br.readLine());
//			result = (4 * (n / 4) / 2) * m + (4 * (m / 4) / 2) * (n % 4);
//			switch((n % 4) * (m % 4)) {
//			case 1:
//				result += 1;
//				break;
//			case 2: case 3:
//				result += 2;
//				break;
//			case 4: case 6:
//				result += 4;
//				break;
//			case 9:
//				result += 5;
//				break;
//			}
			
			result = (4 * ((n = Integer.parseInt(st.nextToken())) / 4) / 2) * (m = Integer.parseInt(st.nextToken())) + (4 * (m / 4) / 2) * (n % 4) + ((n % 4) * (m % 4) / 2) + (((((n % 4) * (m % 4) / 2) >> 1) & 1) ^ (((n % 4) * (m % 4) / 2) & (((n % 4) * (m % 4) / 2) >> 1))) + (((((n % 4) >> 1) | ((n % 4) & 1)) & (((m % 4) >> 1) | ((m % 4) & 1))) & 1);

			System.out.println("#" + t + " " + result);
		}

		br.close();
	}
}