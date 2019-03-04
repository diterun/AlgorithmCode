package com.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_2983 {
	static int T, test_case;
	static int result, len;
	static char[] input;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/2983.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine().trim());

		for (test_case = 1; test_case <= T; test_case++) {
			result = 0;
			
			len = Integer.parseInt(br.readLine().trim());
			input = br.readLine().toCharArray();
			
			System.out.println("#" + test_case + " " + result);
		}

		br.close();
	}
}
