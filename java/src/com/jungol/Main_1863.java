package com.jungol;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1863 {
	static int n, m, result, a, b;
	static int[] p;
	static boolean[] check;
	static StringTokenizer st;
	
	public static void makeSet() {
		for (int i = 1; i <= n; i++) {
			p[i] = i;
		}
	}

	private static int find(int b) {
		if(p[b] == b) {
			return b;
		}
		p[b] = find(p[b]);
		return p[b];
	}

	private static void union(int a, int b) {
		int a1 = find(a);
		int b1 = find(b);
		
		if(a1 == b1) {
			return;
		}
		
		p[b1] = a1;
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/jungol/1863.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		result = 0;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		p = new int[n + 1];
		check = new boolean[n + 1];
		makeSet();
		
		for (int i = 1; i <= n; i++) {
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			if(a > b) {
				union(b, a);
			} else {
				union(a, b);
			}
		}
		
		for (int i = 1; i <= n; i++) {
			a = find(p[i]);
			System.out.print(p[i] + " ");
			check[a] = true;
		}
		System.out.println();
		for (int i = 1; i <= n; i++) {
			if(check[i]) {
				result++;
			}
		}

		System.out.println(result);

		br.close();
	}
}
