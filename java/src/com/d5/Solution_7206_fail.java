package com.d5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_7206_fail {
	static int T, test_case;
	static int result, now;
	static String number;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder(2000);

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/7206.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine().trim());

		for (test_case = 1; test_case <= T; test_case++) {
			result = 0;
			
			number = br.readLine();
			
//			System.out.println("===========" + number + " start============");
			
			getResult(number, 0);
			
			sb.append("#").append(test_case).append(" ").append(result).append("\n");
		}
		System.out.print(sb);

		br.close();
	}
	
	private static void getResult(String nums, int cnt) {
		int now = Integer.parseInt(nums);
		int len, max;
		
//		if(cnt < result) {
//			return;
//		}
		
		if(now < 10) {
			result = result > cnt ? result : cnt;
			return;
		}
		
		len = nums.length();
		
		boolean[] check = new boolean[len - 1];
		
		for (int i = 1; i < len; i++) {
			max = i;
			johab(0, 0, check, cnt, len, max, nums);
		}
	}

	private static void johab(int start, int cnt, boolean[] check, int count, int len, int max, String numbers) {
		if(cnt == max) {
			boolean allFalse = true;
			
			for (int i = 0; i < len - 1; i++) {
				if(check[i] == true) {
					allFalse = false;
				}
			}
			
			if(!allFalse) {
				int[] nums = new int[7];
				int num = 0, numi = 0;
				int sum = 1;
				
				for (int i = 0; i < len; i++) {
					num = num * 10 + (numbers.charAt(i) - '0');
					
					if(i == len - 1) {
						nums[numi++] = num;
					} else {
						if(check[i]) {
							nums[numi++] = num;
							num = 0;
						}
					}
				}
				
				for (int i = 0; i < numi; i++) {
					sum *= nums[i];
				}
				
				getResult(Integer.toString(sum), count + 1);
			}
			
			return;
		}
		
		for (int i = start; i < len - 1; i++) {
			check[i] = true;
			johab(i + 1, cnt + 1, check, count, len, max, numbers);
			check[i] = false;
		}
	}
}
