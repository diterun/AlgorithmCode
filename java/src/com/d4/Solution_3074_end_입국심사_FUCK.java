package com.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3074_end_입국심사_FUCK {
	static int T, test_case;
	static int n, m, simsa[];
	static long sum, min, max, mid, result;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/3074.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine().trim());

		for (test_case = 1; test_case <= T; test_case++) {
			result = Long.MAX_VALUE;
			
			st = new StringTokenizer(br.readLine());

			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			simsa = new int[n];
			
			int temp = 0;
			for (int i = 0; i < n; i++) {
				simsa[i] = Integer.parseInt(br.readLine().trim());
				temp = Math.max(temp, simsa[i]);
			}
			min = 0;
			max = (long)temp * m;
			
			while(min <= max) {
				mid = (max + min) / 2;
				sum = 0;
				
				for (int i = 0; i < n; i++) {
					sum += (mid / simsa[i]);
				}
				
				if(sum >= m) {
					result = Math.min(result, mid);
					max = mid - 1;
				} else if(sum < m) {
					min = mid + 1;
				}
			}
			System.out.println("#" + test_case + " " + result);
		}

		br.close();
	}
}
