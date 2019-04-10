package com.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4261_end_빠른휴대전화키패드 {
	static int T, t;
	static int n, result, temp, numLen;
	static char[] num, word;
	static int[] mat = new int[10];
	static StringTokenizer st;
	static long start, end;

	public static void main(String[] args) throws Exception {
		start = System.nanoTime();
		System.setIn(new FileInputStream("res/d4/4261.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		mat[2] = 7;
		mat[3] = 56;
		mat[4] = 448;
		mat[5] = 3584;
		mat[6] = 28672;
		mat[7] = 491520;
		mat[8] = 3670016;
		mat[9] = 62914560;

		T = Integer.parseInt(br.readLine().trim());

		for (t = 1; t <= T; t++) {
			result = 0;

			st = new StringTokenizer(br.readLine());
			num = st.nextToken().toCharArray();
			numLen = num.length;
			n = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			A:
			for (int i = 0; i < n; i++) {
				word = st.nextToken().toCharArray();
				if(numLen != word.length) continue;

				for (int j = 0; j < numLen; j++) {
					if ((mat[num[j] - '0'] & (1 << (word[j] - 'a'))) == 0) {
						continue A;
					}
				}
				
				result++;
			}

			System.out.println("#" + t + " " + result);
		}

		br.close();
		end = System.nanoTime();
		System.out.println(end - start);
	}
}