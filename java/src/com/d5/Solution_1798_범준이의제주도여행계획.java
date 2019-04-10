package com.d5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_1798_범준이의제주도여행계획 {
	static int T, test_case, n, m, result;
	static int[][] map;
	static int[][] dp;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/d5/1798.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		T = Integer.parseInt(br.readLine().trim());

		for (test_case = 1; test_case <= T; test_case++) {

			System.out.println("#" + test_case + " " + result);
		}
		br.close();
	}
}