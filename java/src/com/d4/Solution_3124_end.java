package com.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Solution_3124_end {
	public static class Edge implements Comparable<Edge> {
		int a; // 정점1
		int b; // 정점2
		int c; // 가중치

		public Edge(int a, int b, int c) {
			super();
			this.a = a;
			this.b = b;
			this.c = c;
		}

		@Override
		public int compareTo(Edge o) {
			// TreeSet의 특징 상 비교 값이 같을 때도 들어가야 하기 때문에, return 0이 되는 경우는 없앤다!
			return (c - o.c) > 0 ? 1 : -1;
		}
	}

	static int T, test_case;
	static int p[], V, E, a, b, c;
	static long result;
	static TreeSet<Edge> ts = new TreeSet<>();
	static StringTokenizer st;

	public static void makeSet(int v) {
		p[v] = v;
	}

	public static int findSet(int v) {
		if (p[v] == v) {
			return v;
		}
		p[v] = findSet(p[v]);
		return p[v];
	}

	public static void union(Edge e) {
		int r1 = findSet(e.a);
		int r2 = findSet(e.b);

		if (r1 == r2) {
			return;
		}
		p[r1] = r2;
		result += e.c;
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/d4/3124.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine().trim());

		for (test_case = 1; test_case <= T; test_case++) {
			result = 0;
			ts.clear();

			st = new StringTokenizer(br.readLine());

			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());

			p = new int[V + 1];
			
			for (int i = 0; i <= V; i++) {
				makeSet(i);
			}

			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());

				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				c = Integer.parseInt(st.nextToken());

				ts.add(new Edge(a, b, c)); // comparable을 이용해서 자동 정렬되서 들어감
			}

			for (Edge e : ts) {
				union(e);
			}
			
			System.out.println("#" + test_case + " " + result);
		}

		br.close();
	}
}
