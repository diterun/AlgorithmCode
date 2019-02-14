package com.d6;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_1266 {
	static int T, test_case;
	static double a, b;
	static int[] combi = new int[19];
	static double result;
	static String[] inS;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/1266.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		combi[2] = 9 * 17;
		combi[3] = 6 * 17 * 8;
		combi[5] = 18 * 17 * 2 * 14;
		combi[7] = 18 * 17 * 8 * 13;
		combi[11] = 18 * 17 * 8 * 13;
		combi[13] = 18 * 17 * 2 * 14;
		combi[17] = 18;

		T = Integer.parseInt(br.readLine().trim());

		for (test_case = 1; test_case <= T; test_case++) {
			result = 0;

			inS = br.readLine().split(" ");
			a = Double.parseDouble(inS[0]);
			b = Double.parseDouble(inS[1]);
			double realA = 0;
			double realB = 0;

			for (int i = 0; i <= 18; i++) {
				double sosuA = 1;
				double sosuB = 1;
				switch (i) {
				case 2:
				case 3:
				case 5:
				case 7:
				case 11:
				case 13:
				case 17:
					sosuA *= combi[i];
					for (int j = 0; j < i; j++) {
						sosuA *= a / 100;
					}
					for (int j = 0; j < 18 - i; j++) {
						sosuA *= (100 - a) / 100;
					}
					realA += sosuA;

					sosuB *= combi[i];
					for (int j = 0; j < i; j++) {
						sosuB *= b / 100;
					}
					for (int j = 0; j < 18 - i; j++) {
						sosuB *= (100 - b) / 100;
					}
					realB += sosuB;

//					System.out.println(i +": (" + a +", "+ b +")" +sosuA + " " + sosuB);
					break;
				}
			}

//			System.out.println(realA + " " + realB);
			result += realA * realB;
			result += realA * (1 - realB);
			result += (1 - realA) * realB;

			System.out.printf("#%d %.6f\n",test_case, result);
		}

		br.close();
	}

}
