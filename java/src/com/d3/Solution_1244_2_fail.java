package com.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_1244_2_fail {
	static int T, test_case, result;
	static char[] number;
	static int count, len;
	static int[][] johab;
	static String[] inS;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/1244.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine().trim());

		for (test_case = 1; test_case <= T; test_case++) {
			inS = br.readLine().split(" ");
			number = inS[0].toCharArray();
			count = Integer.parseInt(inS[1]);

			len = number.length;
			int johabCnt = len * (len - 1) / 2;
			johab = new int[johabCnt][2];
			int k = 0;
			for (int i = 0; i < len - 1; i++) {
				for (int j = i + 1; j < len; j++) {
					johab[k][0] = i;
					johab[k++][1] = j;
				}
			}

			while (count != 0) {
				int max = -1;
				int now = 0;
				for (int i = 0; i < len; i++) {
					now += (number[i] - '0') * Math.pow(10, len - i - 1);
				}

				for (int i = 0; i < johabCnt; i++) {
					char temp = number[johab[i][0]];
					number[johab[i][0]] = number[johab[i][1]];
					number[johab[i][1]] = temp;

					int swap = 0;
					for (int j = 0; j < len; j++) {
						swap += ((number[j] - '0') * Math.pow(10, len - j - 1));
					}

					if (now < swap) {
						System.out.println(now + " " + swap);
						now = swap;
						max = i;
					}

					temp = number[johab[i][0]];
					number[johab[i][0]] = number[johab[i][1]];
					number[johab[i][1]] = temp;
				}

				if (max != -1) {
					char temp = number[johab[max][0]];
					number[johab[max][0]] = number[johab[max][1]];
					number[johab[max][1]] = temp;
				} else {
					if (count % 2 != 0 && !same()) {
						char temp = number[len - 1];
						number[len - 1] = number[len - 2];
						number[len - 2] = temp;
					}
					break;
				}

				for (int i = 0; i < len; i++) {
					System.out.print(number[i]);
				}
				System.out.println();
				count--;
			}

			System.out.print("#" + test_case + " ");
			for (int i = 0; i < len; i++) {
				System.out.print(number[i]);
			}
			System.out.println();
		}

		br.close();
	}

	private static boolean same() {
		for (int i = 0; i < len - 1; i++) {
			if (number[i] == number[i + 1]) {
				return true;
			}
		}
		return false;
	}
}
