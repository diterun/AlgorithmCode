package com.battle;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_7272_안경이없어_end {
	static int T, t, size;
	static String word1, word2;
	static int[] alpha = new int['Z' + 1];
	static boolean isSame;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("battle/7272.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		alpha['A'] = 1;
		alpha['D'] = 1;
		alpha['O'] = 1;
		alpha['P'] = 1;
		alpha['Q'] = 1;
		alpha['R'] = 1;
		alpha['B'] = 2;
		
		T = Integer.parseInt(br.readLine());
		
		for (t = 1; t <= T; t++) {
			isSame = true;
			
			st = new StringTokenizer(br.readLine());

			word1 = st.nextToken();
			word2 = st.nextToken();
			
			size = word1.length();
			
			if(size != word2.length()) {
				sb.append("#").append(t).append(" DIFF\n");
				continue;
			}
			
			for (int i = 0; i < size; i++) {
				if(alpha[word1.charAt(i)] != alpha[word2.charAt(i)]) {
					isSame = false;
					break;
				}
			}
			
			if(isSame) {
				sb.append("#").append(t).append(" SAME\n");
			} else {
				sb.append("#").append(t).append(" DIFF\n");
			}
			
		}
		System.out.print(sb);
		
		br.close();
	}

}
