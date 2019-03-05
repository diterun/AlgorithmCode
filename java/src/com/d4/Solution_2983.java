package com.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_2983 {
	static int T, test_case;
	static int result, len, now, subResult, nowDiff, diff;
	static char[] input;
	static int[] alpha = new int[26];

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/2983.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine().trim());

		for (test_case = 1; test_case <= T; test_case++) {
			result = diff = nowDiff = 0;
			subResult = 1;
			for (int i = 0; i < 26; i++) {
				alpha[i] = -1;
			}
			
			len = Integer.parseInt(br.readLine().trim());
			input = br.readLine().toCharArray();
			
			for (int i = 0; i < len; i++) {
				now = input[i] - 'a';
				
				if(alpha[now] == -1) {
					alpha[now] = i;
					diff = 0;
					result = result > subResult ? result : subResult;
					subResult = 1;
				} else {
					nowDiff = i - alpha[now];
//					System.out.println(input[i] +", " + nowDiff);
					
					if(nowDiff == diff) {
						subResult++;
//						System.out.println(subResult);
					} else {
						diff = nowDiff;
						result = result > subResult ? result : subResult;
						subResult = 1;
					}
					alpha[now] = i;
				}
			}
			result = result > subResult ? result : subResult;
			
//			System.out.println(input);
			if(result == 1) {
				System.out.println("#" + test_case + " 0");
			} else {
				System.out.println("#" + test_case + " " + result);
			}
		}

		br.close();
	}
}
