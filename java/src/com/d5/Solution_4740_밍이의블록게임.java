package com.d5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_4740_밍이의블록게임 {
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

			System.out.println("#" + test_case + " " + result);
		}

		br.close();
	}
}
