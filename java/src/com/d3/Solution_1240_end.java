package com.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_1240_end {
	static int T, test_case, result;
	static int n, m, index, numIndex;
	static int[] num = new int[8];
	static int[] amhos = new int[10];
	static int[] amho = new int[5];
	static String[] in;
	static char[] line;
	static char now;
	static boolean ok;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/d3/1240.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine().trim());

		amhos[0] = 211;
		amhos[1] = 221;
		amhos[2] = 122;
		amhos[3] = 411;
		amhos[4] = 132;
		amhos[5] = 231;
		amhos[6] = 114;
		amhos[7] = 312;
		amhos[8] = 213;
		amhos[9] = 112;

		for (test_case = 1; test_case <= T; test_case++) {
			numIndex = 7;
			index = 4;
			result = 0;
			for (int i = 0; i < 4; i++) {
				amho[i] = 0;
			}
			for (int i = 0; i < 8; i++) {
				num[i] = 0;
			}
			now = '0';
			ok = false;

			in = br.readLine().split(" ");

			n = Integer.parseInt(in[0]);
			m = Integer.parseInt(in[1]);

			for (int i = 0; i < n; i++) {
				line = br.readLine().toCharArray();
				if (!ok) {
					for (int j = m - 1; j >= 0; j--) {
						if (now != line[j]) {
							now = line[j];
							index--;
							amho[index]++;
							if (index == 0) {
								int temp = amho[1] * 100 + amho[2] * 10 + amho[3];
								
								for (int k = 0; k < 10; k++) {
									if (temp == amhos[k]) {
										num[numIndex--] = k;
										if (numIndex == -1) {
											int subResult = (num[0] + num[2] + num[4] + num[6]) * 3 + num[1] + num[3]
													+ num[5] + num[7];

											if (subResult % 10 == 0) {
												result = num[0] + num[2] + num[4] + num[6] + num[1] + num[3] + num[5]
														+ num[7];
											} else {
												result = 0;
											}
											ok = true;
											j = 0;
											break;
										}
									}
								}
								for (int k = 0; k < 5; k++) {
									amho[k] = 0;
								}
								index = 4;
							}
						} else {
							amho[index]++;
						}
					}
				}
			}

			System.out.println("#" + test_case + " " + result);
		}

		br.close();
	}
}
