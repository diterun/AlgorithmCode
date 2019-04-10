package com.d2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_2007_end {
	static int T, test_case, result;
	static char[] line;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/d2/2007.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine().trim());
		
		for(test_case = 1; test_case <= T; test_case++) {
			result = 10;
			line = br.readLine().toCharArray();
			
			for (int i = 10; i > 0; i--) {
				boolean check = true;
				
				for (int j = 0; j < i; j++) {
					if(line[j] != line[j + i]) {
						check = false;
					}
				}
				if(check) {
					result = i;
				}
			}
			
			System.out.println("#" + test_case + " " + result);
		}
		
		br.close();
	}
}
