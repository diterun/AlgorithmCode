package com.none;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 민경벌꿀 {
	static int T, N, M, C;
	static int map[][];
	static int honey[][];
	static int MAX;

	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/2115.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(in.readLine().trim());
//		T = 1;

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(in.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			map = new int[N][N];
			honey = new int[N][N - M + 1];

			MAX = 0;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			print();
			getHoney();
			print_honey();

//			for (int i = 0; i < M; i++) {
//				System.out.println(i);
//				MAX = Math.max(MAX, getMax(i));
//			}

			MAX += getMax();
			MAX += getMax();

			System.out.println("#" + test_case + " " + MAX);
		}
	}
	private static int getMax() {
		int max = 0;
		int r = 0, c = 0, size = honey[0].length ;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < size; j++) {
				if (max <= honey[i][j]) {
					r = i;
					c = j;
					max = honey[i][j];
				}
			}
		}
//		for (int i = 0; c + i < size && i<M; i++) {
//			honey[r][c + i] = 0;
//		}
		for (int i = 0; i<size; i++) {
			honey[r][i] = 0;
		}
		print_honey();
		return max;
	}

	private static int getSuik(int r, int c) {
		int hap, jegobhap;
		hap = jegobhap = 0;
		for (int k = 0; k < M; k++) {
			hap += map[r][c + k];
		}

		if (hap > C) {
			int haps[] = new int[1 << M];
			int jegobhaps[] = new int[1 << M];
			for (int i = 0, size = 1 << M; i < size; i++) {
				for (int j = 0; j < M; j++) {
					if ((i & (1 << j)) == 0) {
						haps[i] += map[r][c + j];
						jegobhaps[i] += Math.pow(map[r][c + j], 2);
					}
				}
				if (haps[i] > C) {
					jegobhaps[i] = 0;
				}
			}
			Arrays.sort(jegobhaps);
			jegobhap = jegobhaps[jegobhaps.length-1];
		} else {
			for (int k = 0; k < M; k++) {
				jegobhap += Math.pow(map[r][c + k], 2);
			}
		}
		return jegobhap;
	}


	private static void getHoney() {
		int hap, jegobhap;
		for (int i = 0; i < N; i++) {
			for (int j = 0, size = N - M + 1; j < size; j++) {
				hap = 0;
				jegobhap = 0;
				for (int k = 0; k < M; k++) {
					hap += map[i][j + k];
					jegobhap += Math.pow(map[i][j + k], 2);
				}
				if (hap > C) {
					honey[i][j] = getSuik(i, j);
				} else {
					honey[i][j] = jegobhap;
				}
			}
		}
	}

	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.printf("%3d  ", map[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	private static void print_honey() {
		for (int i = 0; i < N; i++) {
			for (int j = 0, size = N - M + 1; j < size; j++) {
				System.out.printf("%3d  ", honey[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
}
