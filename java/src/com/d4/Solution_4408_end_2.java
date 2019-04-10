package com.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4408_end_2 {
	static int T, test_case;
	static int n, s, e, temp, max;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/d4/4408.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine().trim());

		for (test_case = 1; test_case <= T; test_case++) {
			n = Integer.parseInt(br.readLine().trim());
			int[] rooms = new int[201];
			max = 0;

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine().trim());
				s = Integer.parseInt(st.nextToken());
				e = Integer.parseInt(st.nextToken());

				s = (s + 1) / 2;
				e = (e + 1) / 2;
				
				if(s > e) {
					temp = s;
					s = e;
					e = temp;
				}
				for (int j = s; j <= e; j++) {
					rooms[j]++;
					max = max > rooms[j] ? max : rooms[j];
				}
			}
			
			System.out.println("#" + test_case + " " + max);
		}

		br.close();
	}
}
