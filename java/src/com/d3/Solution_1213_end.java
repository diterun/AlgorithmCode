package com.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_1213_end {
	static int T, test_case, result;
	static String word, line;
	static String[] to;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/d3/1213.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
//		T = 10;
		
		for(test_case = 1; test_case <= 10; test_case++) {
			test_case = Integer.parseInt(br.readLine().trim());
			word = br.readLine();
			line = br.readLine();
			int llen = line.length();
			int len = word.length();
			
			to = line.split(word);
			result = to.length - 1;
			if(line.substring(0, len).contains(word)) {
				result++;
			}
			if(line.substring(llen - len, llen).contains(word)) {
				result++;
			}
			
			System.out.println("#" + test_case + " " + result);
		}
		
		br.close();
	}
}
