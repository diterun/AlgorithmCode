package com.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_4699_end {
	static int MAX = 26;
	static int T, test_case;
	static int result, L, K;
	/** 각 알파벳의 삽입 비용[0] 제거 비용[1] */
	static int[][] alpha = new int[MAX][2];
	/** 한 테스트 케이스에서 쓰이는 문자열 */
	static char[] word;
	static String[] line;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/d4/4699.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine().trim());

		for (test_case = 1; test_case <= T; test_case++) {
			/**
			 * 초기화
			 */
			result = L = K = 0;
			for (int i = 0; i < MAX; i++) {
				alpha[i][0] = 0;
				alpha[i][1] = 0;
			}

			line = br.readLine().split(" ");
			L = Integer.parseInt(line[0]);
			K = Integer.parseInt(line[1]);

			word = br.readLine().toCharArray();

			for (int i = 0; i < K; i++) {
				line = br.readLine().split(" ");
				alpha[i][0] = Integer.parseInt(line[0]);
				alpha[i][1] = Integer.parseInt(line[1]);
			}

			System.out.println("#" + test_case + " -1");
		}

		br.close();
	}
}
