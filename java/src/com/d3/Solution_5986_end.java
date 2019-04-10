package com.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_5986_end {
	static int[] sosu = new int[200];
	static int T, test_case, n, result, sosui;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/d3/5986.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		getSosu();

		T = Integer.parseInt(br.readLine().trim());

		for (test_case = 1; test_case <= T; test_case++) {
			result = 0;
			
			n = Integer.parseInt(br.readLine().trim());
			
			for (int i = 0; i < sosui; i++) {
				for (int j = i; j < sosui; j++) {
					for (int k = j; k < sosui; k++) {
						int sum = sosu[i];
						
						if(sum >= n) {
							i = sosui;
							j = sosui;
							break;
						} else {
							sum += sosu[j];
							if(sum >= n) {
								j = sosui;
								break;
							} else {
								sum += sosu[k];
								
								if(n == sum) {
									result++;
								} else if(sum > n) {
									break;
								}
							}
						}
					}
				}
			}

			sb.append("#").append(test_case).append(" ").append(result).append("\n");
		}

		System.out.print(sb);

		br.close();
	}

	private static void getSosu() {
		boolean[] prim = new boolean[1000];
		
		for (int i = 2; i < 1000; i++) {
			if (prim[i]) {
				continue;
			}
			for (int j = i * i; j < 1000; j += i) {
				prim[j] = true;
			}
		}
		
		for (int i = 2; i < 1000; i++) {
			if(!prim[i]) {
				sosu[sosui++] = i;
			}
		}
	}

}
