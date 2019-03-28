package com.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_5672_end_올해의조련사 {
	static int T, test_case, n, s, e, index;
	static char[] input, result;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/5672.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine().trim());

		for (test_case = 1; test_case <= T; test_case++) {
			n = Integer.parseInt(br.readLine().trim());
			input = new char[n];
			result = new char[n];
			
			for (int i = 0; i < n; i++) {
				input[i] = br.readLine().charAt(0);
			}
			
			s = index = 0;
			e = n - 1;
			
			while(s != e) {
				if(input[s] > input[e]) {
					result[index++] = input[e--];
				} else if(input[s] < input[e]) {
					result[index++] = input[s++];
				} else {
					boolean isTop = true;
					
					int temps = s;
					int tempe = e;
					
					while(temps < tempe) {
						temps++;
						tempe--;
						
						if(input[temps] < input[tempe]) {
							isTop = true;
							break;
						} else if(input[temps] > input[tempe]) {
							isTop = false;
							break;
						}
					}
					
					if(isTop) {
						result[index++] = input[s++];
					} else {
						result[index++] = input[e--];
					}
				}
			}
			result[index++] = input[s];
			
			System.out.print("#" + test_case + " ");
			for (int i = 0; i < n; i++) {
				System.out.print(result[i]);
			}
			System.out.println();
		}

		br.close();
	}
}
