package com.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4050_end_재관이의대량할인{
	static int MAX = 100001;
	static int T, t, n, price, cnt;
	static long result, halin;
	static int[] ot = new int[MAX];
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/d4/4050.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine().trim());

		for (t = 1; t <= T; t++) {
			result = 0;
			halin = 0;
			cnt = 0;
			
			n = Integer.parseInt(br.readLine().trim());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				price = Integer.parseInt(st.nextToken());
				ot[price]++;
				result += price;
			}
			
			for (int i = MAX - 1; i >= 0; i--) {
				if(ot[i] != 0) {
					cnt += ot[i];
					if(cnt >= 3) {
						halin += i * (cnt / 3);
						cnt %= 3;
					}
				}
				ot[i] = 0;
			}
			
			result -= halin;
			System.out.println("#" + t + " " + result);
		}
		br.close();
	}
}