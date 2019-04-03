package com.none;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5656_벽돌깨기 {
	static int T, t, n, w, h, result;
	static int[][] map, temp;
	static int[] gogo;
	static int[][] move = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/5656.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine().trim());

		for (t = 1; t <= T; t++) {
			result = Integer.MAX_VALUE;
			
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			map = new int[h][w];
			gogo = new int[n];
			
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			rainDoll(0);
			
			System.out.println("#" + t + " " + result);
		}

		br.close();
	}

	private static void rainDoll(int cnt) {
		if(cnt == n) {
			if(result != 0) {
				temp = new int[h][w];
				for (int i = 0; i < h; i++) {
					for (int j = 0; j < w; j++) {
						temp[i][j] = map[i][j];
					}
				}
				
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < h; j++) {
						if(temp[j][gogo[i]] != 0) {
							kwangKwang(j, gogo[i]);
							break;
						}
					}
					
					down();
				}
				
				int sub = namenDoll();
				result = result < sub ? result : sub;
			}
			
			return;
		}
		
		for (int i = 0; i < w; i++) {
			gogo[cnt] = i;
			rainDoll(cnt + 1);
		}
	}

	private static void down() {
		for (int i = 0; i < w; i++) {
			int zeroCnt = 0;
			
			for (int j = h - 1; j >= 0; j--) {
				if(temp[j][i] == 0) {
					zeroCnt++;
				} else {
					if(zeroCnt != 0) {
						temp[j + zeroCnt][i] = temp[j][i];
						temp[j][i] = 0;
					}
				}
			}
		}
	}

	private static int namenDoll() {
		int sub = 0;
		
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if(temp[i][j] != 0) {
					sub++;
				}
			}
		}
		
		return sub;
	}

	private static void kwangKwang(int y, int x) {
		int sub = temp[y][x] - 1;
		temp[y][x] = 0;
		
		for (int i = 1; i <= sub; i++) {
			if(y - i >= 0) {
				kwangKwang(y - i, x);
			}
			if(x - i >= 0) {
				kwangKwang(y, x - i);
			}
			if(y + i < h) {
				kwangKwang(y + i, x);
			}
			if(x + i < w) {
				kwangKwang(y, x + i);
			}
		}
	}
}
