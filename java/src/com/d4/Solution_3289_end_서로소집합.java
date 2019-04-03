package com.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3289_end_서로소집합 {
	static int T, t, n, m, a, b;
	static int[] p;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/3289.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine().trim());

		for (t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			p = new int[n + 1];
			for (int i = 1; i <= n; i++) {
				p[i] = i;
			}
			
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				
				if(Integer.parseInt(st.nextToken()) == 0) {
					a = Integer.parseInt(st.nextToken());
					b = Integer.parseInt(st.nextToken());
					if(a > b) {
						union(a, b);
					} else {
						union(b, a);
					}
				} else {
					a = Integer.parseInt(st.nextToken());
					b = Integer.parseInt(st.nextToken());
					if(find(a) == find(b)) {
						sb.append("1");
					} else {
						sb.append("0");
					}
				}
			}
			sb.append("\n");
		}
		System.out.print(sb);

		br.close();
	}

	private static int find(int num) {
		if(num == p[num]) {
			return num;
		}
		p[num] = find(p[num]);
		return p[num];
	}

	private static void union(int big, int small) {
		p[find(big)] = find(small);
	}
}
