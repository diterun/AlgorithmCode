package com.none;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2105_디저트카페 {
	static int T, test_case, result, n, m, c;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/2105.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine().trim());

		for (test_case = 1; test_case <= T; test_case++) {
			
			sb.append("#").append(test_case).append(" ").append(result).append("\n");
		}
		
		System.out.print(sb);

		br.close();
	}
}
