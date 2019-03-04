package com.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_3459_end {
	static long MAX = 6000000000000000000L;
	static int T, test_case;
	static long[] arr = new long[100];
	static long n, a, b;
	static boolean check = true;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/3459.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		a = 2;
		b = 3;
		
		arr[0] = 0L;
		int i = 1;
		while(a < MAX || b < MAX) {
			if(check) {
				arr[i++] = a;
				check = false;
				
				a = a * 2 + 1;
				b = b * 2;
			} else {
				arr[i++] = b;
				check = true;
				
				a = a * 2;
				b = b * 2 + 1;
			}
		}
		
		T = Integer.parseInt(br.readLine().trim());

		for (test_case = 1; test_case <= T; test_case++) {
			n = Long.parseLong(br.readLine().trim());
			int j = 0;
			
			while(arr[j] <= n) {
				j++;
			}

			if(j % 2 == 0) {
				sb.append("#").append(test_case).append(" Alice\n");
			} else {
				sb.append("#").append(test_case).append(" Bob\n");
			}
		}
		
		System.out.println(sb);

		br.close();
	}
}
