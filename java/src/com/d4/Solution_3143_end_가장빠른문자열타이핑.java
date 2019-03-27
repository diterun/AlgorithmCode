package com.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3143_end_가장빠른문자열타이핑 {
	static int T, test_case, alen, blen, result;
	static char[] a, b;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/3143.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine().trim());

		for (test_case = 1; test_case <= T; test_case++) {
			result = 0;
			st = new StringTokenizer(br.readLine());

			a = st.nextToken().toCharArray();
			b = st.nextToken().toCharArray();

			alen = a.length;
			blen = b.length;

			if (alen < blen) {
				sb.append("#").append(test_case).append(" ").append(alen).append("\n");
				continue;
			}

			for (int i = 0; i < alen; i++) {
				boolean go = true;

				if (i + blen <= alen) {
					for (int j = 0; j < blen; j++) {
						if (a[i + j] != b[j]) {
							go = false;
							break;
						}
					}
					if (go) {
						i += (blen - 1);
					}
				}
				result++;
			}

			sb.append("#").append(test_case).append(" ").append(result).append("\n");
		}
		System.out.print(sb);

		br.close();
	}
}
