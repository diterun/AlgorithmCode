package com.jungol;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_1462 {
	static int n, m, result;
	static char[][] map;
	static char[] in;
	static boolean[][] check;
	static int[][] move = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static LinkedList<Integer> q = new LinkedList<>();
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/jung1462.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n + 2][m + 2];
		check = new boolean[n + 2][m + 2];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = 'W';
			}
		}

		for (int i = 1; i <= n; i++) {
			in = br.readLine().toCharArray();

			for (int j = 1; j <= m; j++) {
				map[i][j] = in[j - 1];
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (map[i][j] == 'L') {
					q.offer(i * 100 + j);
					check[i][j] = true;
					int cnt = 0;

					while (!q.isEmpty()) {
						int size = q.size();
						boolean cc = false;
						
						for (int k = 0; k < size; k++) {
							int num = q.poll();
							int y = num / 100;
							int x = num % 100;

							for (int l = 0; l < 4; l++) {
								int dy = y + move[l][0];
								int dx = x + move[l][1];

								if (!check[dy][dx] && map[dy][dx] == 'L') {
									cc = true;
									check[dy][dx] = true;
									q.offer(dy * 100 + dx);
								}
							}
						}
						if(cc) {
							cnt++;
						}
					}
					
					result = result > cnt ? result : cnt;
					
					for (int k = 1; k <= n; k++) {
						for (int l = 1; l <= m; l++) {
							check[k][l] = false;
						}
					}
				}
			}
		}

		System.out.println(result);

		br.close();
	}
}
