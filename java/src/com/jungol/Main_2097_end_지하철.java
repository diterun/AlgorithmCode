package com.jungol;

import java.io.FileInputStream;
import java.util.Scanner;

public class Main_2097_end_지하철 {
	static int n, destiny, result, results_cnt;
	static int[] results;
	static int[][] gogo;
	static String[] ins;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("jungol/2097.txt"));
		Scanner sc = new Scanner(System.in);
		
		ins = sc.nextLine().split(" ");
		n = Integer.parseInt(ins[0]);
		destiny = Integer.parseInt(ins[1]) - 1;
		
		gogo = new int[n][n];
		results = new int[n];
		result = Integer.MAX_VALUE;
		
		for (int i = 0; i < n; i++) {
			ins = sc.nextLine().split(" ");
			for (int j = 0; j < n; j++) {
				gogo[i][j] = Integer.parseInt(ins[j]);
			}
		}
		
		int[] line = new int[n];
		boolean[] visit = new boolean[n];
		visit[0] = true;
		line[0] = 1;
		for (int i = 1; i < n; i++) {
			if(gogo[0][i] != 0) {
				visit[i] = true;
				line[1] = (i + 1);
				dfs(visit, line, 2, i, gogo[0][i]);
				visit[i] = false;
			}
		}

		System.out.println(result);
		for (int i = 0; i < results_cnt; i++) {
			System.out.print(results[i] + " ");
		}
		System.out.println();

		sc.close();
	}

	private static void dfs(boolean[] visit, int[] line, int cnt, int dest, int sum) {
		if(sum > result) {
			return;
		}
		if(dest == destiny) {
//			System.out.println(sum);
			if(result > sum) {
//				System.out.print(sum + " : ");
//				for (int i = 0; i < cnt; i++) {
//					System.out.print(line[i] + "->");
//				}
//				System.out.println();
				result = sum;
				results = line.clone();
				results_cnt = cnt;
			}
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if(!visit[i] && gogo[dest][i] != 0) {
				visit[i] = true;
				line[cnt] = (i + 1);
				dfs(visit, line, cnt + 1, i, sum + gogo[dest][i]);
				visit[i] = false;
			}
		}
	}
}
