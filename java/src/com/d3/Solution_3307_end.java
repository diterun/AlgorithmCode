package com.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_3307_end {
	static int MAX = 1002;
	static int T, test_case;
	static int N, result;
	static int[] numList = new int[MAX];
	static int[] numCnt = new int[MAX];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine().trim());
		
		String[] str;
		for(test_case = 1; test_case <= T; test_case++) {
			for (int i = 0; i < MAX; i++) {
				numList[i] = 0;
				numCnt[i] = 0;
			}
			result = 0;
			N = Integer.parseInt(br.readLine().trim());
			
			str = br.readLine().split(" ");
			for (int i = 0; i < N; i++) {
				numList[i] = Integer.parseInt(str[i].trim());	// 수열 입력
			}
			
			for (int i = 0; i < N; i++) {
				int cnt = 0;
				
				for (int j = 0; j < i; j++) {
					if(numList[i] >= numList[j]) {
						cnt = cnt > numCnt[j] ? cnt : numCnt[j];
					}
				}
				
				numCnt[i] = cnt + 1;
			}
			
			for (int i = 0; i < N; i++) {
				result = result > numCnt[i] ? result : numCnt[i];
			}

			System.out.println("#" + test_case + " " + result);
		}
		
		br.close();
	}
}
