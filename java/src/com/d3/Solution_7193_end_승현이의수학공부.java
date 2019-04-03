package com.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_7193_end_승현이의수학공부 {
	static int T, test_case, n;
	static int sum, len;
	static char[] number;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/7193.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine().trim());
		
		for (test_case = 1; test_case <= T; test_case++) {
			sum = 0;
			
			st = new StringTokenizer(br.readLine().trim());

			n = Integer.parseInt(st.nextToken()) - 1;
			number = st.nextToken().toCharArray();
			len = number.length;
			
			for (int i = 0; i < len; i++) {
				sum += number[i] - '0';
			}

			System.out.println("#" + test_case + " " + (sum % n));
		}

		br.close();
	}
}
