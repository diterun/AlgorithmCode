package com.jungol;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1828_2_fail {
	static int MAX = 10272;
	static int n, result;
	static int[][] ref;
	static boolean[] checkAll;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/jung1828.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		ref = new int[n][2];
		checkAll = new boolean[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			ref[i][0] = Integer.parseInt(st.nextToken());
			ref[i][1] = Integer.parseInt(st.nextToken());
		}

		while (true) {
			int cnt = 0, cnti = 0;
			boolean check = true;
			
			for (int i = -270; i < 10001; i++) {
				int subCnt = 0;
				for (int j = 0; j < n; j++) {
					if (!checkAll[j] && (ref[j][0] <= i && i <= ref[j][1])) {
						subCnt++;
					}
				}
				if(cnt < subCnt) {
					cnt = subCnt;
					cnti = i;
				}
			}
			
			for (int i = 0; i < n; i++) {
				if(!checkAll[i] && (ref[i][0] <= cnti && cnti <= ref[i][1])) {
					checkAll[i] = true;
					check = false;
				}
			}
			System.out.println(cnti + "�� " + cnt + " " + check);
			
			if(check) {
				break;
			} else {
				result++;
			}
		}

		System.out.println(result);

		br.close();
	}
}
