package com.d5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_1256_end {
	static int T, test_case, n, size;
	static String input;
	static String[] result;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/1256.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine().trim());

		for (test_case = 1; test_case <= T; test_case++) {
			n = Integer.parseInt(br.readLine().trim());
			input = br.readLine();

			size = input.length();
			result = new String[size];
			for (int i = 0; i < size; i++) {
				result[i] = input.substring(i);
			}
			
			Arrays.sort(result);

			System.out.println("#" + test_case + " " + result[n - 1]);
		}

		br.close();
	}

}
