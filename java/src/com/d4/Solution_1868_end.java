package com.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Solution_1868_end {
	static int GEEROE = -1;
	static int T, test_case;
	static int result, n;
	static int[][] map;
	static boolean[][] check;
	static int[][] move = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };
	static char[] input;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/d4/1868.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine().trim());

		for (test_case = 1; test_case <= T; test_case++) {
			result = 0;

			n = Integer.parseInt(br.readLine().trim());

			map = new int[n + 2][n + 2];
			check = new boolean[n + 2][n + 2];

			for (int i = 0; i < n + 2; i++) {
				for (int j = 0; j < n + 2; j++) {
					map[i][j] = 10;
				}
			}

			for (int i = 1; i <= n; i++) {
				input = br.readLine().toCharArray();

				for (int j = 1; j <= n; j++) {
					if (input[j - 1] == '.') {
						map[i][j] = 0;
					} else {
						map[i][j] = GEEROE;
					}
				}
			}

			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (map[i][j] != GEEROE) {
						for (int k = 0; k < 8; k++) {
							if (map[i + move[k][0]][j + move[k][1]] == GEEROE) {
								map[i][j]++;
							}
						}
					}
				}
			}

			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (!check[i][j] && map[i][j] > 0) {
						boolean alone = true;

						for (int k = 0; k < 8; k++) {
							if (map[i + move[k][0]][j + move[k][1]] == 0) {
								alone = false;
								break;
							}
						}

						if (alone) {
							check[i][j] = true;
							result++;
						}
					} else if(!check[i][j] && map[i][j] == 0) {
						bfs(i, j);
						result++;
					}
				}
			}

			System.out.println("#" + test_case + " " + result);
		}

		br.close();
	}

	private static void bfs(int i, int j) {
		LinkedList<Integer> q = new LinkedList<>();
		int n, y, x, ny, nx;
		
		q.offer(i * 1000 + j);
		check[i][j] = true;
		
		while(!q.isEmpty()) {
			n = q.poll();
			y = n / 1000;
			x = n % 1000;
			
			for (int k = 0; k < 8; k++) {
				ny = y + move[k][0];
				nx = x + move[k][1];
				
				if (!check[ny][nx] && map[ny][nx] == 0) {
					check[ny][nx] = true;
					q.offer(ny * 1000 + nx);

					for (int k2 = 0; k2 < 8; k2++) {
						int dy = ny + move[k2][0];
						int dx = nx + move[k2][1];
						
						if(map[dy][dx] != 0) {
							check[dy][dx] = true;
						}
					}
				} else {
					check[ny][nx] = true;
				}
			}
		}
	}
}
