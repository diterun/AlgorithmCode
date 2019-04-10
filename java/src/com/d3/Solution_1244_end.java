package com.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_1244_end {
	static int T, test_case, result;
	static char[] number;
	static int count, len, max, index, maxCnt;
	static int[] maxIndexs = new int[6];
	static String[] inS;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/d3/1244.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine().trim());

		for (test_case = 1; test_case <= T; test_case++) {
			max = 0;
			index = maxCnt = 0;
			for (int i = 0; i < 6; i++) {
				maxIndexs[i] = 0;
			}

			inS = br.readLine().split(" ");
			number = inS[0].toCharArray();
			count = Integer.parseInt(inS[1]);

			len = number.length;

			while (count != 0) {
				max = 0;
				for (int i = len - 1; i >= index; i--) {
					if (max < number[i]) {
						max = number[i];
						maxIndexs[0] = i;
						maxCnt = 1;
					} else if (max == number[i]) {
						maxIndexs[maxCnt++] = i;
					}
				}

				if (index < maxIndexs[0] && number[index] < number[maxIndexs[0]]) {
					if (maxCnt == 1) {
						char temp = number[index];
						number[index] = number[maxIndexs[0]];
						number[maxIndexs[0]] = temp;
					} else {
						int tempIndex = count - 1;
						if(count - 1 > maxCnt -1) {
							tempIndex = maxCnt -1;
						}
						
						char temp = number[index];
						number[index] = number[maxIndexs[tempIndex]];
						number[maxIndexs[tempIndex]] = temp;
					}

					count--;
				} else {
					if (index == len - 1) {
						if (!same()) {
							char temp = number[len - 1];
							number[len - 1] = number[len - 2];
							number[len - 2] = temp;
						}
						count--;
					}
				}

				if (index < len - 1) {
					index++;
				}
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
