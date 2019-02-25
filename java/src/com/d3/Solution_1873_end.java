package com.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1873_end {
	static int MAX = 22;
	static int T, test_case, result, h, w, n;
	/**움직임*/
	static int[][] move = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	/**map의 크기는 최대보다 +2크게 padding을 둔다. 모든 맵은 처음엔 강철로 초기화*/
	static char[][] map = new char[MAX][MAX];
	/**
	 * (x, y) - 탱크의 좌표
	 * d 	- 탱크가 바라보는 방향
	 * 		- 0 = 동
	 * 		- 1 = 서
	 * 		- 2 = 남
	 * 		- 3 = 북
	 */
	static int y, x, d;
	static StringTokenizer st;
	static char[] input;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/1873.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine().trim());

		for (test_case = 1; test_case <= T; test_case++) {
			for (int i = 0; i < MAX; i++) {
				for (int j = 0; j < MAX; j++) {
					map[i][j] = '#';
				}
			}
			st = new StringTokenizer(br.readLine());

			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			
			for (int i = 1; i <= h; i++) {
				input = br.readLine().toCharArray();
				for (int j = 1; j <= w; j++) {
					map[i][j] = input[j - 1];
					switch(map[i][j]) {
					case '>':
						d = 0; y = i; x = j; break;
					case '<':
						d = 1; y = i; x = j; break;
					case '^':
						d = 3; y = i; x = j; break;
					case 'v':
						d = 2; y = i; x = j; break;
					}
				}
			}
			
			n = Integer.parseInt(br.readLine().trim());
			input = br.readLine().toCharArray();
			for (int i = 0; i < n; i++) {
				int dx = 0, dy = 0;
				switch(input[i]) {
				case 'U':
					d = 3;
					dy = y + move[d][0];
					dx = x + move[d][1];
					if(map[dy][dx] == '.') {
						map[y][x] = '.';
						map[dy][dx] = '^';
						y = dy;
						x = dx;
					} else {
						map[y][x] = '^';
					}
					break;
				case 'D':
					d = 2;
					dy = y + move[d][0];
					dx = x + move[d][1];
					if(map[dy][dx] == '.') {
						map[y][x] = '.';
						map[dy][dx] = 'v';
						y = dy;
						x = dx;
					} else {
						map[y][x] = 'v';
					}
					break;
				case 'L':
					d = 1;
					dy = y + move[d][0];
					dx = x + move[d][1];
					if(map[dy][dx] == '.') {
						map[y][x] = '.';
						map[dy][dx] = '<';
						y = dy;
						x = dx;
					} else {
						map[y][x] = '<';
					}
					break;
				case 'R':
					d = 0;
					dy = y + move[d][0];
					dx = x + move[d][1];
					if(map[dy][dx] == '.') {
						map[y][x] = '.';
						map[dy][dx] = '>';
						y = dy;
						x = dx;
					} else {
						map[y][x] = '>';
					}
					break;
				case 'S':
					switch(d) {
					case 0:
						for (int j = x + 1; j <= w; j++) {
							if(map[y][j] == '*') {
								map[y][j] = '.';
								break;
							} else if(map[y][j] == '#') {
								break;
							}
						}
						break;
					case 1:
						for (int j = x - 1; j > 0; j--) {
							if(map[y][j] == '*') {
								map[y][j] = '.';
								break;
							} else if(map[y][j] == '#') {
								break;
							}
						}
						break;
					case 2:
						for (int j = y + 1; j <= h; j++) {
							if(map[j][x] == '*') {
								map[j][x] = '.';
								break;
							} else if(map[j][x] == '#') {
								break;
							}
						}
						break;
					case 3:
						for (int j = y - 1; j > 0; j--) {
							if(map[j][x] == '*') {
								map[j][x] = '.';
								break;
							} else if(map[j][x] == '#') {
								break;
							}
						}
						break;
					}
					break;
				}
//				System.out.println(i +"번째에는?");
//				for (int ii = 1; ii <= h; ii++) {
//					for (int j = 1; j <= w; j++) {
//						System.out.print(map[ii][j]);
//					}
//					System.out.println();
//				}
			}
			
			sb.append("#").append(test_case).append(" ");
			for (int i = 1; i <= h; i++) {
				for (int j = 1; j <= w; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);

		br.close();
	}
}
