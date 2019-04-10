package com.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1808 {
	static int T, test_case;
	static int result, x, dCnt;
	static int[] d = new int[10];
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/d4/1808.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine().trim());

		for (test_case = 1; test_case <= T; test_case++) {
			result = Integer.MAX_VALUE;
			dCnt = 0;
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 10; i++) {
				if(st.nextToken().charAt(0) == '1') {
					d[dCnt++] = i;
				}
			}
			
			x = Integer.parseInt(br.readLine().trim());
			
			result = find(x, 0);
			
			if(result == Integer.MAX_VALUE) {
				sb.append("#").append(test_case).append(" -1\n");
			} else {
				sb.append("#").append(test_case).append(" ").append(result).append("\n");
			}
		}
		System.out.print(sb);

		br.close();
	}

	private static int find(int number, int cnt) {
		if(check(Integer.toString(number).toCharArray())) {
			return 0;
		}
		
		for (int i = number / 2; i < d.length; i++) {
			
		}
		
		return 0;
	}

	private static boolean check(char[] number) {
		int l = 0;
		
		for (int i = 0; i < number.length; i++) {
			for (int j = 0; j < dCnt; j++) {
				if((number[i] - '0') == d[j]) {
					l++;
				}
			}
		}
		return number.length == l;
	}
}
