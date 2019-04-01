package com.d4;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_4796_end_의석이의우뚝선산 {
	static int T, test_case, n, result, prev, now, s, e;
	static boolean isUp;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/4796.txt"));
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();

		for (test_case = 1; test_case <= T; test_case++) {
			result = s = e = 0;
			isUp = false;

			n = sc.nextInt();
			prev = sc.nextInt();

			for (int i = 1; i < n; i++) {
				now = sc.nextInt();

				if (prev < now) {
					if (isUp) {
						s++;
					} else {
						isUp = true;

						result += s * e;
						s = 1;
						e = 0;
					}
				} else if (prev > now) {
					if (isUp) {
						isUp = false;
						
						e = 1;
					} else {
						e++;
					}
				}
				prev = now;
			}
			if(!isUp) {
				result += s * e;
			}

			System.out.println("#" + test_case + " " + result);
		}

		sc.close();
	}
}
