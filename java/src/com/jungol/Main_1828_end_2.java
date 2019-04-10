package com.jungol;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1828_end_2 {
	static int MAX = 10272;
	static int n, result;
	static int[][] ref;
	static boolean[] checkAll = new boolean[10271];
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/jungol/1828.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		ref = new int[n][2];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			ref[i][0] = Integer.parseInt(st.nextToken()) + 270;
			ref[i][1] = Integer.parseInt(st.nextToken()) + 270;
		}

		boolean start = false;

		for (int i = 0; i < 10271; i++) {
			for (int j = 0; j < n; j++) {
				if (!checkAll[j] && start && (i == ref[j][1])) {
					for (int k = 0; k < n; k++) {
						if (!checkAll[k] && (ref[k][0] <= i && i <= ref[k][1])) {
							checkAll[k] = true;
						}
					}
					result++;
					start = false;
					break;
				} else if (!checkAll[j] && (i == ref[j][0])) {
					start = true;
					if(i == ref[j][1]) {
						checkAll[j] = true;
						result++;
						start = false;
					}
					break;
				}
			}
		}
		
		System.out.println(result);

		br.close();
	}
}
