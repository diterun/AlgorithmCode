package com.baek;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main_16235_end_나무재테크 {
	static int MAX = 12, TREEMAX = 100000;
	static int N, M, K, result;
	/**
	 * 맵의 모든 나무들의 나이를 저장하는 변수
	 */
	static int[][][] age = new int[MAX][MAX][TREEMAX];
	/**
	 * 맵 한 칸에 있는 나무의 수
	 * [0] = 나무의 시작 index
	 * [1] = 나무의 끝 index
	 * [1] - [0] = 그 칸에 존재하는 나무의 개수
	 */
	static int[][][] treeIndex = new int[MAX][MAX][2];
	/**
	 * 맵에 존재하는 현재의 양분
	 */
	static int[][] map = new int[MAX][MAX];
	/**
	 * 맵에 매년 더해지는 양분
	 */
	static int[][] eats = new int[MAX][MAX];
	static String[] line;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/baek/16235.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		line = br.readLine().split(" ");
		N = Integer.parseInt(line[0]);
		M = Integer.parseInt(line[1]);
		K = Integer.parseInt(line[2]);
		
		for (int i = 1; i <= N; i++) {
			line = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				eats[i][j + 1] = Integer.parseInt(line[j]);
				map[i][j + 1] = 5;
			}
		}
		
		for (int i = 0; i < M; i++) {
			line = br.readLine().split(" ");
			int x = Integer.parseInt(line[0]);
			int y = Integer.parseInt(line[1]);
			int z = Integer.parseInt(line[2]);
			
			age[x][y][treeIndex[x][y][1]++] = z;
		}
		
		while(K > 0) {
			/**
			 * 봄
			 */
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					int start = treeIndex[j][i][0];
					int end = treeIndex[j][i][1];
					for (int k = end - 1; k >= start; k--) {
						if(age[j][i][k] <= map[j][i]) {
							map[j][i] -= age[j][i][k];
							age[j][i][k]++;
						} else {
							/**
							 * 여름
							 */
							treeIndex[j][i][0] = k + 1;
							for (int k2 = k; k2 >= start; k2--) {
								map[j][i] += (age[j][i][k2] / 2);
								age[j][i][k2] = 0;
							}
							break;
						}
					}
				}
			}
			/**
			 * 가을
			 */
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					int start = treeIndex[j][i][0];
					int end = treeIndex[j][i][1];
					for (int k = end - 1; k >= start; k--) {
						if(age[j][i][k] % 5 == 0) {
							age[j][i + 1][treeIndex[j][i + 1][1]++] = 1;
							age[j + 1][i][treeIndex[j + 1][i][1]++] = 1;
							age[j][i - 1][treeIndex[j][i - 1][1]++] = 1;
							age[j - 1][i][treeIndex[j - 1][i][1]++] = 1;
							age[j - 1][i + 1][treeIndex[j - 1][i + 1][1]++] = 1;
							age[j + 1][i + 1][treeIndex[j + 1][i + 1][1]++] = 1;
							age[j - 1][i - 1][treeIndex[j - 1][i - 1][1]++] = 1;
							age[j + 1][i - 1][treeIndex[j + 1][i - 1][1]++] = 1;
						}
					}
					/**
					 * 겨울
					 */
					map[j][i] += eats[j][i];
				}
			}
			K--;
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				result += (treeIndex[j][i][1] - treeIndex[j][i][0]);
			}
		}
		
		System.out.println(result);
		
		br.close();
	}

}
