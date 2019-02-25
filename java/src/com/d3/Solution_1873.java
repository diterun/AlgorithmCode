package com.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1873 {
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
					}
					break;
				case 'S':
					dy = y;
					dx = x;
					while(true) {
						dy = dy + move[d][0];
						dx = dx + move[d][1];
						if(map[dy][dx] == '#') {
							break;
						} else if(map[dy][dx] == '*') {
							map[dy][dx] = '.';
							break;
						}
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
			
			System.out.print("#" + test_case + " ");
			for (int i = 1; i <= h; i++) {
				for (int j = 1; j <= w; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}

		br.close();
	}
}
