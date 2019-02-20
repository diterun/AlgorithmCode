package com.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_2819_end {
	static int MAX = 10000000;
	static int T, test_case;
	static int result;
	static int[][] map = new int[4][4];
	static int[][] move = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static boolean[] check = new boolean[MAX];
	static String[] inS;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/2819.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine().trim());

		for (test_case = 1; test_case <= T; test_case++) {
			result = 0;

			for (int i = 0; i < 4; i++) {
				inS = br.readLine().split(" ");

				for (int j = 0; j < 4; j++) {
					map[i][j] = Integer.parseInt(inS[j]);
				}
			}

			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					getCount(0, i, j, 0);
				}
			}

			for (int i = 0; i < MAX; i++) {
				if (check[i]) {
					result++;
					check[i] = false;
				}
			}

			System.out.println("#" + test_case + " " + result);
		}

		br.close();
	}

	private static void getCount(int num, int y, int x, int cnt) {
		if (cnt == 7) {
			check[num] = true;
			return;
		}

		for (int i = 0; i < 4; i++) {
			int dy = y + move[i][0];
			int dx = x + move[i][1];

			if (0 <= dy && dy < 4 && 0 <= dx && dx < 4) {
				getCount(num * 10 + map[dy][dx], dy, dx, cnt + 1);
			}
		}
	}

}
