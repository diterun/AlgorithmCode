package com.none;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_1952_end_수영장 {
	static int T, test_case, day, mon, mon3, year, result, max;
	static int[] month = new int[18];
	static int[] jojo;
	static LinkedList<Integer> gomon;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/1952.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine().trim());

		for (test_case = 1; test_case <= T; test_case++) {
			gomon = new LinkedList<Integer>();
			
			st = new StringTokenizer(br.readLine().trim());
			day = Integer.parseInt(st.nextToken());
			mon = Integer.parseInt(st.nextToken());
			mon3 = Integer.parseInt(st.nextToken());
			year = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine().trim());
			for (int i = 0; i < 12; i++) {
				month[i] = Integer.parseInt(st.nextToken());
			}
			
			result = year;
			
			for (int i = 0; i < 12; i++) {
				month[i] = Math.min(month[i] * day, mon);
			}

			int subR = 0;
			for (int i = 0; i < 12; i++) {
				subR += month[i];
			}
			result = result < subR ? result : subR;
			
			for (int i = 1; i < 5; i++) {
				max = i;
				jojo = new int[i];
				johab(0, 0);
			}
			
			System.out.println("#" + test_case + " " + result);
		}

		br.close();
	}

	private static void johab(int cnt, int start) {
		if(cnt == max) {
			boolean[] check = new boolean[15];
			for (int i = 0; i < max; i++) {
				check[jojo[i]] = true;
				check[jojo[i] + 1] = true;
				check[jojo[i] + 2] = true;
			}
			
			int subR = max * mon3;
			for (int i = 0; i < 12; i++) {
				if(!check[i]) {
					subR += month[i];
				}
			}
			
			result = result < subR ? result : subR;
			return;
		}
		
		for (int i = start; i < 12; i++) {
			jojo[cnt] = i;
			johab(cnt + 1, start + 1);
		}
	}
}
