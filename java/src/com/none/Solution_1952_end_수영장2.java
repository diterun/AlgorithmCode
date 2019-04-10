package com.none;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1952_end_수영장2 {
	static int T, test_case, day, mon, mon3, result;
	static int[] month = new int[14];
	static int[][] johap = {
			{0},{1},{2},{3},{4},{5},{6},{7},{8},{9},{10},{11},
			{0, 3},{0, 4},{0, 5},{0, 6},{0, 7},{0, 8},{0, 9},{0, 10},{0, 11},
			{1, 4},{1, 5},{1, 6},{1, 7},{1, 8},{1, 9},{1, 10},{1, 11},
			{2, 5},{2, 6},{2, 7},{2, 8},{2, 9},{2, 10},{2, 11},
			{3, 6},{3, 7},{3, 8},{3, 9},{3, 10},{3, 11},
			{4, 7},{4, 8},{4, 9},{4, 10},{4, 11},
			{5, 8},{5, 9},{5, 10},{5, 11},
			{6, 9},{6, 10},{6, 11},
			{7, 10},{7, 11},
			{8, 11},
			{0, 3, 6},{0, 3, 7},{0, 3, 8},{0, 3, 9},{0, 3, 10},{0, 3, 11},
			{0, 4, 7},{0, 4, 8},{0, 4, 9},{0, 4, 10},{0, 4, 11},
			{0, 5, 8},{0, 5, 9},{0, 5, 10},{0, 5, 11},
			{0, 6, 9},{0, 6, 10},{0, 6, 11},
			{0, 7, 10},{0, 7, 11},
			{0, 8, 11},
			{1, 4, 7},{1, 4, 8},{1, 4, 9},{1, 4, 10},{1, 4, 11},
			{1, 5, 8},{1, 5, 9},{1, 5, 10},{1, 5, 11},
			{1, 6, 9},{1, 6, 10},{1, 6, 11},
			{1, 7, 10},{1, 7, 11},
			{1, 8, 11},
			{2, 5, 8},{2, 5, 9},{2, 5, 10},{2, 5, 11},
			{2, 6, 9},{2, 6, 10},{2, 6, 11},
			{2, 7, 10},{2, 7, 11},
			{2, 8, 11},
			{3, 6, 9},{3, 6, 10},{3, 6, 11},
			{3, 7, 10},{3, 7, 11},
			{3, 8, 11},
			{4, 7, 10},{4, 7, 11},
			{4, 8, 11},
			{5, 8, 11}
	};
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/none/1952.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine().trim());

		for (test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine().trim());
			day = Integer.parseInt(st.nextToken());
			mon = Integer.parseInt(st.nextToken());
			mon3 = Integer.parseInt(st.nextToken());
			result = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine().trim());
			for (int i = 0; i < 12; i++) {
				month[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 0; i < 12; i++) {
				month[i] = Math.min(month[i] * day, mon);
			}

			int subR = 0;
			for (int i = 0; i < 12; i++) {
				subR += month[i];
			}
			result = result < subR ? result : subR;
			result = result < mon3 * 4 ? result : mon3 * 4;
			
			int size = johap.length;
			
			for (int i = 0; i < size; i++) {
				int[] temp = month.clone();
				int size2 = johap[i].length;
				
				for (int j = 0; j < size2; j++) {
					temp[johap[i][j]] = mon3;
					temp[johap[i][j] + 1] = 0;
					temp[johap[i][j] + 2] = 0;
				}
				
				subR = 0;
				for (int j = 0; j < 12; j++) {
					subR += temp[j];
				}
				result = result < subR ? result : subR;
			}
			
			sb.append("#").append(test_case).append(" ").append(result).append("\n");
		}
		System.out.print(sb);

		br.close();
	}
}
