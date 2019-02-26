package com.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_5986_2_end {
	static int[] sosu = new int[200];
	static int[] nCase = new int[3000];
	static int T, test_case, sosui, sum;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/5986.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		getSosu();

		for (int i = 0; i < sosui; i++) {
			for (int j = i; j < sosui; j++) {
				for (int k = j; k < sosui; k++) {
					nCase[sosu[i] + sosu[j] + sosu[k]]++;
				}
			}
		}
		
		T = Integer.parseInt(br.readLine().trim());

		for (test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ").append(nCase[Integer.parseInt(br.readLine().trim())]).append("\n");
		}

		System.out.print(sb);

		br.close();
	}

	private static void getSosu() {
		boolean[] prim = new boolean[1000];
		
		for (int i = 2; i < 1000; i++) {
			if (prim[i]) {
				continue;
			} else {
				sosu[sosui++] = i;
			}
			for (int j = i * i; j < 1000; j += i) {
				prim[j] = true;
			}
		}
	}

}
