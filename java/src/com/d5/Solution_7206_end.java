package com.d5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_7206_end {
	static int T, test_case;
	static int[] arr = new int[15];
	static int[] results = new int[100000];
	static StringBuilder sb = new StringBuilder(2000);

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/d5/7206.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 10; i++) {
			results[i] = 0;
		}
		for (int i = 10; i < 100; i++) {
			results[i] = results[(i / 10) * (i % 10)] + 1;
		}
		for (int i = 100; i < 1000; i++) {
			arr[0] = results[(i / 10) * (i % 10)];
			arr[1] = results[(i / 100) * (i % 100)];
			arr[2] = results[(i / 100) * ((i % 100) / 10) * (i % 10)];

			for (int j = 1; j < 3; j++) {
				arr[0] = Math.max(arr[0], arr[j]);
			}
			
			results[i] = arr[0] + 1;
		}
		for (int i = 1000; i < 10000; i++) {
			arr[0] = results[(i / 10) * (i % 10)];
			arr[1] = results[(i / 100) * ((i % 100) / 10) * (i % 10)];
			arr[2] = results[(i / 100) * (i % 100)];
			arr[3] = results[(i / 1000) * (i % 1000)];
			arr[4] = results[(i / 1000) * ((i % 1000) / 100) * (i % 100)];
			arr[5] = results[(i / 1000) * ((i % 1000) / 10) * (i % 10)];
			arr[6] = results[(i / 1000) * ((i % 1000) / 100) * ((i % 100) / 10) * (i % 10)];

			for (int j = 1; j < 7; j++) {
				arr[0] = Math.max(arr[0], arr[j]);
			}
			
			results[i] = arr[0] + 1;
		}
		for (int i = 10000; i < 100000; i++) {
			arr[0] = results[(i / 10) * (i % 10)];
			arr[1] = results[(i / 100) * (i % 100)];
			arr[2] = results[(i / 1000) * (i % 1000)];
			arr[3] = results[(i / 10000) * (i % 10000)];
			
			arr[4] = results[(i / 100) * ((i % 100) / 10) * (i % 10)];
			arr[5] = results[(i / 1000) * ((i % 1000) / 10) * (i % 10)];
			arr[6] = results[(i / 10000) * ((i % 10000) / 10) * (i % 10)];
			arr[7] = results[(i / 1000) * ((i % 1000) / 100) * (i % 100)];
			arr[8] = results[(i / 10000) * ((i % 1000) / 100) * (i % 100)];
			arr[9] = results[(i / 10000) * ((i % 10000) / 1000) * (i % 1000)];

			arr[10] = results[(i / 1000) * ((i % 1000) / 100) * ((i % 100) / 10) * (i % 10)];
			arr[11] = results[(i / 10000) * ((i % 10000) / 100) * ((i % 100) / 10) * (i % 10)];
			arr[12] = results[(i / 10000) * ((i % 10000) / 1000) * ((i % 1000) / 10) * (i % 10)];
			arr[13] = results[(i / 10000) * ((i % 10000) / 1000) * ((i % 1000) / 100) * (i % 100)];
			
			arr[14] = results[(i / 10000) * ((i % 10000) / 1000) * ((i % 1000) / 100) * ((i % 100) / 10) * (i % 10)];

			for (int j = 1; j < 15; j++) {
				arr[0] = Math.max(arr[0], arr[j]);
			}
			
			results[i] = arr[0] + 1;
		}

		T = Integer.parseInt(br.readLine().trim());

		for (test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ").append(results[Integer.parseInt(br.readLine().trim())]).append("\n");
		}
		System.out.print(sb);

		br.close();
	}
}
