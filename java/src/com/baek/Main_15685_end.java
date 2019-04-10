package com.baek;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15685_end {
	static int n, x, y, d, g, result;
	static int[][] dragon, map;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/baek/15685.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		result = 0;

		map = new int[101][101];

		n = Integer.parseInt(br.readLine());

		dragon = new int[n][];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			g = Integer.parseInt(st.nextToken());
			
			int size = 1 << g;

			dragon[i] = new int[size];

			dragon[i][0] = d;

			for (int j = 0; j < g; j++) {
				int gijun = 1 << j;

				for (int k = 0; k < gijun; k++) {
					dragon[i][gijun + k] = (dragon[i][gijun - k - 1] + 1) % 4;
				}
			}

			map[y][x] = 1;
			
			for (int j = 0; j < size; j++) {
				switch(dragon[i][j]) {
				case 0:
					x++;
					break;
				case 1:
					y--;
					break;
				case 2:
					x--;
					break;
				case 3:
					y++;
					break;
				}
				map[y][x] = 1;
			}
		}
		
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if(map[i][j] == 1 && map[i][j + 1] == 1 && map[i + 1][j] == 1 && map[i + 1][j + 1] == 1) {
					result++;
				}
			}
		}

		System.out.println(result);

		br.close();
	}
}
