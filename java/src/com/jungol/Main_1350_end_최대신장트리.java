package com.jungol;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1350_end_최대신장트리 {
	static int n, m, result, a, b, c, cnt;
	static int[][] edges;
	static int[] nodes;
	static boolean[] check;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/jungol/1350.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine().trim());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		edges = new int[n][n];
		nodes = new int[n];
		check = new boolean[n];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine().trim());
			a = Integer.parseInt(st.nextToken()) - 1;
			b = Integer.parseInt(st.nextToken()) - 1;
			c = Integer.parseInt(st.nextToken());
			
			if(edges[a][b] < c) {
				edges[a][b] = c;
				edges[b][a] = c;
			}
		}
		
		cnt = 1;
		nodes[0] = 0;
		check[0] = true;
		while(cnt < n) {
			int tempa = 0;
			int tempb = 0;
			int max = 0;
			
			for (int i = 0; i < cnt; i++) {
				for (int j = 0; j < n; j++) {
					int m1 = edges[nodes[i]][j];
					
					if(m1 != 0 && !check[j] && m1 > max) {
						max = m1;
						tempa = nodes[i];
						tempb = j;
					}
				}
			}
			
//			System.out.println(cnt + " : (" + tempa +" -> " + tempb +")" + edges[tempa][tempb]);
			result += edges[tempa][tempb];
			nodes[cnt] = tempb;
			check[tempb] = true;
			cnt++;
		}

		System.out.println(result);

		br.close();
	}
}
