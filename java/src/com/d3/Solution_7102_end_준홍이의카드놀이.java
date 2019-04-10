package com.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_7102_end_준홍이의카드놀이 {
	static int T, test_case, n, m, len, max;
	static int[] numbers;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/d3/7102.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine().trim());
		
		for (test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine().trim());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			len = n + m + 1;
			
			numbers = new int[len];
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= m; j++) {
					numbers[i + j]++;
				}
			}
			max = 0;
			for (int i = 2; i < len; i++) {
				max = max > numbers[i] ? max : numbers[i];
			}
			
			sb.append("#").append(test_case).append(" ");
			for (int i = 2; i < len; i++) {
				if(numbers[i] == max) {
					sb.append(i).append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.print(sb);

		br.close();
	}
}
