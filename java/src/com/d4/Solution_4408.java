package com.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4408 {
	static int T, test_case;
	/** n명의 학생과 단위 시간 result */
	static int n, result, s, e, temp;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/4408.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine().trim());

		for (test_case = 1; test_case <= T; test_case++) {
			result = 0;

			n = Integer.parseInt(br.readLine().trim());
			int[][] students = new int[n][2];
			boolean[] isMyRoom = new boolean[n];
			boolean all = true;

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine().trim());
				s = Integer.parseInt(st.nextToken());
				e = Integer.parseInt(st.nextToken());

				s = s / 2 + s % 2;
				e = e / 2 + e % 2;
				
				if(s > e) {
					temp = s;
					s = e;
					e = temp;
				}

				students[i][0] = s;
				students[i][1] = e;
			}

			for (int i = 0; i < n - 1; i++) {
				for (int j = i + 1; j < n; j++) {
					if (students[i][0] > students[j][0]) {
						temp = students[i][0];
						students[i][0] = students[j][0];
						students[j][0] = temp;
						temp = students[i][1];
						students[i][1] = students[j][1];
						students[j][1] = temp;
					} else if (students[i][0] == students[j][0]) {
						if (students[i][1] > students[j][1]) {
							temp = students[i][0];
							students[i][0] = students[j][0];
							students[j][0] = temp;
							temp = students[i][1];
							students[i][1] = students[j][1];
							students[j][1] = temp;
						}
					}
				}
			}
			
			while(true) {
				int end = 0;
				all = true;
				
				for (int i = 0; i < n; i++) {
					if(!isMyRoom[i]) {
						if(end < students[i][0]) {
							isMyRoom[i] = true;
							end = students[i][1];
							all = false;
						}
					}
				}
				
				if(all) {
					break;
				}
				result++;
			}

			System.out.println("#" + test_case + " " + result);
		}

		br.close();
	}
}
