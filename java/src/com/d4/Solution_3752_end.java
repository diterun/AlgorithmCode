package com.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3752_end {
	static int T, test_case, n, num, max, len, result, sum;
	static boolean[] canGrade;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/d4/3752.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine().trim());

		for (test_case = 1; test_case <= T; test_case++) {
			result = max = 0;
			
			n = Integer.parseInt(br.readLine().trim());
			st = new StringTokenizer(br.readLine());
			
			len = (n * 100) + 1;
			canGrade = new boolean[len];
			canGrade[0] = true;
			
			for (int i = 0; i < n; i++) {
				num = Integer.parseInt(st.nextToken());
				
				for (int j = max; j >= 0; j--) {
					if(canGrade[j]) {
						canGrade[j + num] = true;
						
						max = max > j + num ? max : j + num;
					}
				}
//				for (int j = 0; j < len; j++) {
//					if(arr[j]) {
//						System.out.print("T ");
//					}else {
//						System.out.print("F ");
//					}
//				}
//				System.out.println();
			}
			
			for (int i = 0; i < len; i++) {
				if(canGrade[i]) {
					result++;
				}
			}

			sb.append("#").append(test_case).append(" ").append(result).append("\n");
		}
		
		System.out.println(sb);

		br.close();
	}
}
