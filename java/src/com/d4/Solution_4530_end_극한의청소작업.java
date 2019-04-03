package com.d4;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_4530_end_극한의청소작업 {
	static int T, test_case;
	static long s, e, result;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/4408.txt"));
		Scanner sc = new Scanner(System.in);
		

		T = sc.nextInt();

		for (test_case = 1; test_case <= T; test_case++) {
			result = 0;

			s = sc.nextLong();
			e = sc.nextLong();
			
			if(s > 0 && e < 0) {
				result = s - e - 1;
			} else {
				result = s - e;
			}

			System.out.println("#" + test_case + " " + result);
		}

		sc.close();
	}
}
