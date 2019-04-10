package com.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_7338_end_현규의연봉계산법 {
	static int T, test_case;
	static long y, m, ry, rm, temp;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/d4/7338.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine().trim());

		for (test_case = 1; test_case <= T; test_case++) {
			ry = rm = 0;
			
			st = new StringTokenizer(br.readLine());
			y = Long.parseLong(st.nextToken());
			m = Long.parseLong(st.nextToken());
			
			temp = 2016 * 13 + (y - 2016) * 12 + m;
			ry = temp / 13;
			rm = temp % 13;
			if(rm == 0) {
				sb.append("#").append(test_case).append(" ").append(ry - 1).append(" ").append(13).append("\n");
			} else {
				sb.append("#").append(test_case).append(" ").append(ry).append(" ").append(rm).append("\n");
			}
			
		}
		System.out.print(sb);

		br.close();
	}
}
