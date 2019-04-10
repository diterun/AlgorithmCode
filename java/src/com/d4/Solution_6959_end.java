package com.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_6959_end {
	static int T, test_case;
	static int size, sum, dNine;
	static char[] line;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/d4/6959.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine().trim());

		for (test_case = 1; test_case <= T; test_case++) {
			sum = 0;

			line = br.readLine().toCharArray();
			size = line.length;

			for (int i = 0; i < size; i++) {
				sum += line[i] - '0';
			}

			dNine = sum / 9;
			if (sum % 9 == 0) {
				if(size % 2 == 0 && dNine % 2 != 0) {
					System.out.println("#" + test_case + " A");
				} else if(size % 2 != 0 && dNine % 2 == 0) {
					System.out.println("#" + test_case + " A");
				} else {
					System.out.println("#" + test_case + " B");
				}
			} else {
				if(size % 2 == 0 && dNine % 2 == 0) {
					System.out.println("#" + test_case + " A");
				} else if(size % 2 != 0 && dNine % 2 != 0) {
					System.out.println("#" + test_case + " A");
				} else {
					System.out.println("#" + test_case + " B");
				}
			}
		}

		br.close();
	}
}