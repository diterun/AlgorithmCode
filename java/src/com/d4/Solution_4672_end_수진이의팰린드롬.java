package com.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_4672_end_수진이의팰린드롬 {
	static int T, test_case, result;
	static char[] word;
	static int[] wCnt = new int[27];

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/4672.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());

		for (test_case = 1; test_case <= T; test_case++) {
			result = 0;
			
			word = br.readLine().toCharArray();
			result += word.length;
			
			for (int i = 0, size = word.length; i < size; i++) {
				wCnt[word[i] - 'a']++;
			}
			
			for (int i = 0; i < 27; i++) {
				switch(wCnt[i]) {
				case 2: result += 1; break;
				case 3: result += 3; break;
				case 4: result += 6; break;
				case 5: result += 10; break;
				case 6: result += 15; break;
				case 7: result += 21; break;
				case 8: result += 28; break;
				case 9: result += 36; break;
				case 10: result += 45; break;
				}
				wCnt[i] = 0;
			}

			System.out.println("#" + test_case + " " + result);
		}

		br.close();
	}
}
