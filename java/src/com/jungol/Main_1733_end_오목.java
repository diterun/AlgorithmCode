package com.jungol;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1733_end_오목 {
	static int MAX = 40;
	static int i, j;
	static int[][] map = new int[MAX][MAX];
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("jungol/1733.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (i = 6; i < 25; i++) {
			st = new StringTokenizer(br.readLine());
			for (j = 6; j < 25; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (j = 6; j < 25; j++) {
			for (i = 6; i < 25; i++) {
				if(map[i - 1][j - 1] != 1 && map[i][j] == 1 && map[i + 1][j + 1] == 1 && map[i + 2][j + 2] == 1
						 && map[i + 3][j + 3] == 1 && map[i + 4][j + 4] == 1 && map[i + 5][j + 5] != 1) {
					System.out.println(1);
					System.out.println((i - 5) + " " + (j - 5));
					
					br.close();
					return;
				}
				if(map[i + 1][j - 1] != 1 &&  map[i][j] == 1 && map[i - 1][j + 1] == 1 && map[i - 2][j + 2] == 1
						 && map[i - 3][j + 3] == 1 && map[i - 4][j + 4] == 1 && map[i - 5][j + 5] != 1) {
					System.out.println(1);
					System.out.println((i - 5) + " " + (j - 5));
					
					br.close();
					return;
				}
				if(map[i - 1][j] != 1 && map[i][j] == 1 && map[i + 1][j] == 1 && map[i + 2][j] == 1
						 && map[i + 3][j] == 1 && map[i + 4][j] == 1 && map[i + 5][j] != 1) {
					System.out.println(1);
					System.out.println((i - 5) + " " + (j - 5));
					
					br.close();
					return;
				}
				if(map[i][j - 1] != 1 && map[i][j] == 1 && map[i][j + 1] == 1 && map[i][j + 2] == 1
						 && map[i][j + 3] == 1 && map[i][j + 4] == 1 && map[i][j + 5] != 1) {
					System.out.println(1);
					System.out.println((i - 5) + " " + (j - 5));
					
					br.close();
					return;
				}
				if(map[i - 1][j - 1] != 2 && map[i][j] == 2 && map[i + 1][j + 1] == 2 && map[i + 2][j + 2] == 2
						 && map[i + 3][j + 3] == 2 && map[i + 4][j + 4] == 2 && map[i + 5][j + 5] != 2) {
					System.out.println(2);
					System.out.println((i - 5) + " " + (j - 5));
					
					br.close();
					return;
				}
				if(map[i + 1][j - 1] != 2 && map[i][j] == 2 && map[i - 1][j + 1] == 2 && map[i - 2][j + 2] == 2
						 && map[i - 3][j + 3] == 2 && map[i - 4][j + 4] == 2 && map[i - 5][j + 5] != 2) {
					System.out.println(2);
					System.out.println((i - 5) + " " + (j - 5));
					
					br.close();
					return;
				}
				if(map[i - 1][j] != 2 && map[i][j] == 2 && map[i + 1][j] == 2 && map[i + 2][j] == 2
						 && map[i + 3][j] == 2 && map[i + 4][j] == 2 && map[i + 5][j] != 2) {
					System.out.println(2);
					System.out.println((i - 5) + " " + (j - 5));
					
					br.close();
					return;
				}
				if(map[i][j - 1] != 2 && map[i][j] == 2 && map[i][j + 1] == 2 && map[i][j + 2] == 2
						 && map[i][j + 3] == 2 && map[i][j + 4] == 2 && map[i][j + 5] != 2) {
					System.out.println(2);
					System.out.println((i - 5) + " " + (j - 5));
					
					br.close();
					return;
				}
			}
		}

		System.out.println(0);

		br.close();
	}
}
