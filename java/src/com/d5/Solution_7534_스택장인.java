package com.d5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_7534_스택장인 {
	static int[] list;
	static int T, t, n, now, num, max;
	static StringTokenizer st;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/d5/7534.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine().trim());

		for (t = 1; t <= T; t++) {
			sb = new StringBuilder();
			max = now = 0;

			n = Integer.parseInt(br.readLine().trim());
			list = new int[n];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				num = Integer.parseInt(st.nextToken());
				
				if(num > max) {
					for (int j = max + 1; j <= num; j++) {
						list[now++] = j;
						sb.append('+');
					}
					max = num;
					now--;
					sb.append('-');
				} else {
					if(list[now - 1] == num) {
						now--;
						sb.append('-');
					} else {
						sb = new StringBuilder("NO");
						break;
					}
				}
			}
			
			System.out.println("#" + t + " " + sb);
		}

		br.close();
	}
}
