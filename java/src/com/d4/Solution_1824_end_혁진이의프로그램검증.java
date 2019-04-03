package com.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_1824_end_혁진이의프로그램검증 {
	static int T, t, r, c;
	static char[][] map;
	static boolean[][][][] check;
//								하		상			우		좌
	static int[][] move = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static boolean isYes;
	static LinkedList<Integer> q;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/1824.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		for (t = 1; t <= T; t++) {
			isYes = false;
			st = new StringTokenizer(br.readLine());

			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			map = new char[r][c];
			check = new boolean[r][c][16][4];
			q = new LinkedList<>();

			for (int i = 0; i < r; i++) {
				map[i] = br.readLine().toCharArray();
			}
			
			check[0][0][0][2] = true;
			q.offer(20000);
//			System.out.println(map[0][0]);

			while (!q.isEmpty()) {
				int num = q.poll();
				int now = num / 100000;
				int dir = (num % 100000) / 10000;
				int y = (num % 10000) / 100;
				int x = num % 100;
				
//				System.out.println(x + ", " + y);

				int dy = y + move[dir][0];
				int dx = x + move[dir][1];

				if (dy < 0) {
					dy = r - 1;
				} else if(dy >= r) {
					dy = 0;
				} else if(dx < 0) {
					dx = c - 1;
				} else if(dx >= c) {
					dx = 0;
				}
				
				switch (map[y][x]) {
				case '0':
				case '1':
				case '2':
				case '3':
				case '4':
				case '5':
				case '6':
				case '7':
				case '8':
				case '9':
					now = map[y][x] - '0';
					break;
				case '-':
					now = now == 0 ? 15 : now - 1;
					break;
				case '+':
					now = now == 15 ? 0 : now + 1;
					break;
				case '|':
					if(now == 0) {
						dir = 0;
					} else {
						dir = 1;
					}
					break;
				case '_':
					if(now == 0) {
						dir = 2;
					} else {
						dir = 3;
					}
					break;
				case '?':
					if (!check[dy][dx][now][(dir + 1) % 4]) {
						check[dy][dx][now][(dir + 1) % 4] = true;
						q.offer(now * 100000 + ((dir + 1) % 4) * 10000 + y * 100 + x);
					}
					if (!check[dy][dx][now][(dir + 2) % 4]) {
						check[dy][dx][now][(dir + 2) % 4] = true;
						q.offer(now * 100000 + ((dir + 2) % 4) * 10000 + y * 100 + x);
					}
					if (!check[dy][dx][now][(dir + 3) % 4]) {
						check[dy][dx][now][(dir + 3) % 4] = true;
						q.offer(now * 100000 + ((dir + 3) % 4) * 10000 + y * 100 + x);
					}
					break;
				case '>':
					dir = 2;
					break;
				case '^':
					dir = 1;
					break;
				case 'v':
					dir = 0;
					break;
				case '<':
					dir = 3;
					break;
				case '@':
//					System.out.println("#" + t + " YES");
					sb.append("#").append(t).append(" YES\n");
					isYes = true;
					q.clear();
					break;
				}
				
				dy = y + move[dir][0];
				dx = x + move[dir][1];

				if (dy < 0) {
					dy = r - 1;
				} else if(dy >= r) {
					dy = 0;
				} else if(dx < 0) {
					dx = c - 1;
				} else if(dx >= c) {
					dx = 0;
				}
				
				if (!check[dy][dx][now][dir] && !isYes) {
					check[dy][dx][now][dir] = true;
					q.offer(now * 100000 + dir * 10000 + dy * 100 + dx);
				}
			}
			
			if(!isYes) {
//				System.out.println("#" + t + " NO");
				sb.append("#").append(t).append(" NO\n");
			}
		}
		System.out.print(sb);

		br.close();
	}
}