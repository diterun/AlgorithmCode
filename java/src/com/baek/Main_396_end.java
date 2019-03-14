package com.baek;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_396_end {
	static int n, m, result, subR;
	static int y1, x1, y2, x2;
	static int[][] map;
	static int[][] move = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static boolean[][] check;
	static StringTokenizer st;

	public static void clearCheck() {
		for (int i = 0; i < n + 2; i++) {
			for (int j = 0; j < m + 2; j++) {
				check[i][j] = false;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/baek396_2.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		result = 0;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n + 2][m + 2];
		check = new boolean[n + 2][m + 2];

		for (int i = 0; i < n + 2; i++) {
			for (int j = 0; j < m + 2; j++) {
				map[i][j] = 3;
			}
		}

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				y1 = i;
				x1 = j;

				if (map[y1][x1] == 0) {
					for (int j2 = j + 1; j2 <= m; j2++) {
						y2 = i;
						x2 = j2;

						if (map[y2][x2] == 0) {
							map[y1][x1] = 1;
							map[y2][x2] = 1;
//							printMap();

							for (int i3 = 1; i3 <= n; i3++) {
								for (int j3 = 1; j3 <= m; j3++) {
									if (map[i3][j3] == 2 && !check[i3][j3]) {
										checkDe(i3, j3);
									}
								}
							}
							result = result > subR ? result : subR;
							subR = 0;
							map[y1][x1] = 0;
							map[y2][x2] = 0;
							clearCheck();
						}
					}

					for (int i2 = i + 1; i2 <= n; i2++) {
						for (int j2 = 1; j2 <= m; j2++) {
							y2 = i2;
							x2 = j2;

							if (map[y2][x2] == 0) {
								map[y1][x1] = 1;
								map[y2][x2] = 1;
//									printMap();
								for (int i3 = 1; i3 <= n; i3++) {
									for (int j3 = 1; j3 <= m; j3++) {
										if (map[i3][j3] == 2 && !check[i3][j3]) {
											checkDe(i3, j3);
										}
									}
								}

								result = result > subR ? result : subR;
								subR = 0;
								map[y1][x1] = 0;
								map[y2][x2] = 0;
								clearCheck();
							}
						}
					}
				}
			}
		}

		System.out.println(result);

		br.close();
	}

	private static boolean checkDe(int y, int x) {
		int subResult = 1;
		LinkedList<Integer> q = new LinkedList<>();
		boolean de = false;

		q.offer(y * 10000 + x);
		check[y][x] = true;

		while (!q.isEmpty()) {
			int size = q.size();

			for (int k = 0; k < size; k++) {
				int now = q.poll();
				int ny = now / 10000;
				int nx = now % 10000;

				for (int i = 0; i < 4; i++) {
					int dy = ny + move[i][0];
					int dx = nx + move[i][1];

					if (map[dy][dx] == 0) {
						de = true;
					} else if (!check[dy][dx] && map[dy][dx] == 2) {
						check[dy][dx] = true;
						subResult++;
						q.offer(dy * 10000 + dx);
					}
				}
			}
		}

		if (!de) {
//			System.out.println(x + ", " + y + " : " + subResult);
			subR += subResult;
		}

		return de;
	}
}
