package com.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Solution_1251_end {
	public static class Edge implements Comparable<Edge> {
		int a;
		int b;
		double LL;

		public Edge(int a, int b, double LL) {
			super();
			this.a = a;
			this.b = b;
			this.LL = LL;
		}

		@Override
		public String toString() {
			return new StringBuilder().append(a).append("-").append(b).append(" = ").append(LL).toString();
		}

		@Override
		public int compareTo(Edge o) {
			return (LL - o.LL) > 0 ? 1 : -1;
		}
	}

	static int MAX = 1001;
	static int T, test_case;
	static int n;
	static double result;
	static double e;
	static TreeSet<Edge> edges = new TreeSet<>();
	static int[] p;
	static int[][] sum = new int[2][MAX];
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

	public static void union(Edge ed) {
		int r1 = findSet(ed.a);
		int r2 = findSet(ed.b);

		if (r1 == r2) {
			return;
		}
		p[r1] = r2;
		result += ed.LL * e;
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/d4/1251.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine().trim());

		for (test_case = 1; test_case <= T; test_case++) {
			result = 0;
			edges.clear();

			n = Integer.parseInt(br.readLine().trim());

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				sum[0][i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				sum[1][i] = Integer.parseInt(st.nextToken());
			}

			e = Double.parseDouble(br.readLine().trim());

			for (int i = 0; i < n; i++) {
				for (int j = i - 1; j >= 0; j--) {
					double x = sum[0][i] - sum[0][j];
					double y = sum[1][i] - sum[1][j];
					double di = x * x + y * y;

					edges.add(new Edge(i, j, di));
				}
			}

			p = new int[n];

			for (int i = 0; i < n; i++) {
				makeSet(i);
			}
			
			//System.out.println(edges.size());
			for (Edge ed : edges) {
				union(ed);
			}

			System.out.println("#" + test_case + " " + Math.round(result));
		}

		br.close();
	}
}
