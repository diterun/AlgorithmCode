package com.d5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_5949_end {
	static int T, test_case, lineLen;
	static long result;
	static char[] line, line2;
	/**각각 a,b 혹은 b,a로 다를 때의 index를 저장할 stack*/
	static Stack<Integer> s = new Stack<Integer>();
	static Stack<Integer> s2 = new Stack<Integer>();

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/5949.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine().trim());

		for (test_case = 1; test_case <= T; test_case++) {
			/**
			 * 초기화
			 */
			result = 0;
			s.clear();
			s2.clear();

			/**윗 문자열*/
			line = br.readLine().toCharArray();
			/**아래 문자열*/
			line2 = br.readLine().toCharArray();
			lineLen = line.length;

			for (int i = 0; i < lineLen; i++) {
				if (line[i] != line2[i] && line[i] == 'a') {
					/**위, 아래가 다르고 위가 a일 때,*/
					if(s2.empty()) {
						/**s2가 비어 있다면 s에 지금의 index를 넣어둔다.*/
						s.push(i);
					} else {
						/**s2에 있는 것을 꺼내 계산 후 더해준다.*/
						result += (i - s2.pop());
					}
				} else if (line[i] != line2[i] && line[i] == 'b') {
					if(s.empty()) {
						s2.push(i);
					} else {
						result += (i - s.pop());
					}
				}
			}

			System.out.println("#" + test_case + " " + result);
		}

		br.close();
	}
}
