package com.none;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1949_end_등산로조성 {
	static int T, t, n, k, result;
	static int[][] map;
	static MQ goJum = new MQ();
	static int[][] move = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/none/1949.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine().trim());

		for (t = 1; t <= T; t++) {
			result = 0;
			goJum.clear();

			st = new StringTokenizer(br.readLine().trim());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			map = new int[n][n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					/**Seek to more than higher spot*/
					if(goJum.peek() < map[i][j]) {
						goJum.clear();
						goJum.offer(i * 100 + j, map[i][j]);
					} else if(goJum.peek() == map[i][j]) {
						goJum.offer(i * 100 + j, map[i][j]);
					}
				}
			}
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					/**If that is early lowst spot, didn't cut*/
					if(lowst(i, j)) {
						continue;
					}
					for (int j2 = 1; j2 <= k; j2++) {
						if(map[i][j] >= j2) {
							/**Cut*/
							map[i][j] -= j2;
							int size = goJum.size;
							for (int jj = 0; jj < size; jj++) {
								int xy = goJum.get(jj);
								
								getResult(xy / 100, xy % 100, 1);
							}
							/**Stack*/
							map[i][j] += j2;
						}
					}
				}
			}

			System.out.println("#" + t + " " + result);
		}
		goJum.poll();

		br.close();
	}

	private static void getResult(int y, int x, int cnt) {
		if(lowst(y, x)) {
			/**If now is lowst spot, calculate result*/
			result = result > cnt ? result : cnt;
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int dy = y + move[i][0];
			int dx = x + move[i][1];
			
			if(dy < 0 || dy >= n || dx < 0 || dx >= n) {
				continue;
			}
			
			/**Reculsive function. If more than lower*/
			if(map[dy][dx] < map[y][x]) {
				getResult(dy, dx, cnt + 1);
			}
		}
	}

	private static boolean lowst(int y, int x) {
		if(y > 0 && map[y][x] > map[y - 1][x]) {
			return false;
		}
		if(x > 0 && map[y][x] > map[y][x - 1]) {
			return false;
		}
		if(y < n - 1 && map[y][x] > map[y + 1][x]) {
			return false;
		}
		if(x < n - 1 && map[y][x] > map[y][x + 1]) {
			return false;
		}
		return true;
	}

	private static class MQ {
		private int s, e, MAX = 100;
		private int[][] list = new int[MAX][2];
		int size;

		public boolean isEmpty() {
			return s == e;
		}

		public boolean isFull() {
			return s - MAX == e;
		}

		public void offer(int xy, int num) {
			if (isFull()) {
				return;
			}
			list[s % MAX][0] = xy;
			list[s % MAX][1] = num;
			s++;
			size++;
		}

		public int poll() {
			if (isEmpty()) {
				return -1;
			}
			int xy = list[e % MAX][0];
			e++;
			size--;
			return xy;
		}

		public int peek() {
			if (isEmpty()) {
				return -1;
			}
			return list[e % MAX][1];
		}
		
		public int get(int i) {
			if (isEmpty()) {
				return -1;
			}
			
			return list[(e + i) % MAX][0];
		}

		public void clear() {
			s = e = size = 0;
		}
	}
}
