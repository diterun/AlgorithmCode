package com.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_5550_end {
	static int MAX = 501;
	static int T, test_case;
	/**
	 * c, r, o, a는 각각 그 단어까지 운 개구리
	 * sum은 모든 개구리의 총 수
	 * 
	 */
	static int result, lineLen, c, r, o, a, sum;
	static char[] line;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/d4/5550.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine().trim());

		for (test_case = 1; test_case <= T; test_case++) {
			/**
			 * 초기화
			 */
			result = 0;
			c = r = o = a = 0;

			line = br.readLine().toCharArray();
			lineLen = line.length;

			for (int i = 0; i < lineLen; i++) {
				/** c 까지 운 개구리*/
				if(line[i] == 'c') {
					c++;
				}
				/** r 까지 운 개구리*/
				else if(line[i] == 'r') {
					/** 만약 c 까지 운 개구리가 없다면 에러*/
					if (c == 0) { 
						result = -1;
						break;
					}
					/** c 까지 운 개구리를 줄이고, r 까지 운 개구리를 늘린다.*/
					c--;
					r++;
				} else if(line[i] == 'o') {
					if (r == 0) {
						result = -1;
						break;
					}
					r--;
					o++;
				} else if(line[i] == 'a') {
					if (o == 0) {
						result = -1;
						break;
					}
					o--;
					a++;
				} else{
					if (a == 0) {
						result = -1;
						break;
					}
					a--;
				}

				/** 모든 단계에 있는 개구리의 총 합이 가장 클 때가 개구리의 총 수 이다.*/
				sum = c + r + o + a;
				result = result > sum ? result : sum;
			}

			/** 만약 모든 과정이 끝나고 sum이 0이 되지 않았다면 에러*/
			if(sum == 0) {
				System.out.println("#" + test_case + " " + result);
			} else {
				System.out.println("#" + test_case + " -1");
			}
		}

		br.close();
	}
}
