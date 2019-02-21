package com.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_4261_end {
	static int MAX = 1001;
	static int T, test_case;
	static int N, K, result, wordCnt, numLen, matchingCnt;
	static String[] line = new String[MAX];
	static String[] words = new String[MAX];
	/**
	 * 자판과 매칭 되는 배열
	 */
	static char[][] matching = {{},{},{'a','b','c'},{'d','e','f'}
							,{'g','h','i'},{'j','k','l'},{'m','n','o'}
							,{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}
							};
	static char[] word;
	static char[] num;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/4261.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		start = System.nanoTime();
		
		T = Integer.parseInt(br.readLine().trim());

		for (test_case = 1; test_case <= T; test_case++) {
			result = 0;
			wordCnt = 0;
			
			line = br.readLine().split(" ");
			num = line[0].toCharArray();
			numLen = num.length;
			wordCnt = Integer.parseInt(line[1]);
			
			words = br.readLine().split(" ");
			
			for (int i = 0; i < wordCnt; i++) {
				if(words[i].length() != numLen) {
					continue;
				}
				matchingCnt = 0;
				
				word = words[i].toCharArray();
				
				/*
				 * 숫자 중 하나와 글자 중 하나를 하나씩 비교한다.
				 */
				for (int j = 0; j < numLen; j++) {
					char a = num[j];
					char b = word[j];
					
					for (int k = 0, size2 = matching[a - 48].length; k < size2; k++) {
						if(matching[a - 48][k] == b) {
							matchingCnt++;
						}
					}
				}
				
				/*
				 * 모든 글자 하나가 다 대응이 된다면 결과를 하나 늘린다.
				 */
				if(matchingCnt == numLen) {
					result++;
				}
			}
			
			
			System.out.println("#" + test_case + " " + result);
		}
		
//		end = System.nanoTime();
//		System.out.println("Time : " + (end-start));
		br.close();
	}
}