package com.d5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Solution_6058 {
	static int MAX = 102;
	static int T, test_case;
	static int result, n;

	public static void main(String[] args) throws Exception{
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("res/6058.txt"));
		
		T = Integer.parseInt(br.readLine().trim());

		for (test_case = 1; test_case <= T; test_case++) {
			
			System.out.println("#" + test_case + " " + result);
		}
		
		br.close();
	}

}
