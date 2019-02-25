package com.jungol;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1828_2 {
	static int MAX = 10272;
	static int n, s, e, result;
	static int[] tems = new int[MAX];
	static boolean up = false;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/jung1828.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken()) + 270;
			e = Integer.parseInt(st.nextToken()) + 270;

			for (int j = s; j <= e; j++) {
				tems[j]++;
			}
		}
//		for (int i = 0; i < MAX; i++) {
//			System.out.print(tems[i] + " ");
//		}
//		System.out.println();

		for (int i = 0; i < MAX - 1; i++) {
			if (tems[i] < tems[i + 1]) {
				System.out.println(i);
				up = true;
			} else if(tems[i] > tems[i + 1]) {
				if(up) {
					result++;
					up = false;
				}
			}
		}

		System.out.println(result);

		br.close();
	}
}
