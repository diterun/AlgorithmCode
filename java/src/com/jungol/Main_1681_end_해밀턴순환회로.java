package com.jungol;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1681_end_해밀턴순환회로 {
	static int n, result;
	static int[][] map;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		result = Integer.MAX_VALUE;
		
		System.setIn(new FileInputStream("res/jungol/1681.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine().trim());
		map = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 1; i < n; i++) {
			if(map[0][i] != 0) {
				dfs(i, 1 << i, map[0][i]);
			}
		}
		
		System.out.println(result);

		br.close();
	}

	private static void dfs(int now, int flag, int price) {
		if(flag == ((1 << n) - 2)) {
			if(map[now][0] != 0) {
				int sub = price + map[now][0];
				
				result = result < sub ? result : sub;
			}
			return;
		}
		if(price > result) {
			return;
		}
		
		for (int i = 1; i < n; i++) {
			if((flag & (1 << i)) == 0 && map[now][i] != 0) {
				dfs(i, (flag | (1 << i)), price + map[now][i]);
			}
		}
	}
}
