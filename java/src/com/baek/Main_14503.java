package com.baek;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Main_14503 {
	static int MAX = 50;
	static int N, M, result;
	static int r, c, d;
	static int[][] map = new int[MAX][MAX];
	static String[] line;
	/** 0(북), 1(동), 2(남), 3(서) */
	static int[][] move = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/baek14503.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		line = in.readLine().split(" ");
		N = Integer.parseInt(line[0]);
		M = Integer.parseInt(line[1]);

		line = in.readLine().split(" ");
		r = Integer.parseInt(line[0]);
		c = Integer.parseInt(line[1]);
		d = Integer.parseInt(line[2]);

		for (int i = 0; i < N; i++) {
			line = in.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(line[j]);
			}
		}

		map[r][c] = 2;
		result++;

		while (true) {
			/** 앞쪽*/
			int fr = r + move[d][0];
			int fc = c + move[d][1];
			int front = map[fr][fc];
			/** 왼쪽*/
			int lr = r + move[(d + 3) % 4][0];
			int lc = c + move[(d + 3) % 4][1];
			int left = map[lr][lc];
			/** 오른쪽*/
			int rr = r + move[(d + 1) % 4][0];
			int rc = c + move[(d + 1) % 4][1];
			int right = map[rr][rc];
			/** 뒤쪽*/
			int br = r + move[(d + 2) % 4][0];
			int bc = c + move[(d + 2) % 4][1];
			int back = map[br][bc];

			/** 모두가 벽이거나 청소한 상태*/
			if((back == 1 || back == 2)
			&& (front == 1 || front == 2)
			&& (left == 1 || left == 2)
			&& (right == 1 || right == 2)) {
				/** 뒤쪽은 벽이고, 나머지는 벽이거나 청소한 상태*/
				if(back == 1) {
					break;
				} /** 뒤쪽은 벽이 아니고 나머지는 벽이거나 청소한 상태*/
				else {
					r = br;
					c = bc;
					continue;
				}
			}
			
			/** 왼쪽은 청소가 되었으나, 나머지는 모르는 상태*/
			d = (d + 3) % 4;
			
			/** 왼쪽에 청소가 안 된 상태*/
			if(left == 0) {
				r = lr;
				c = lc;
				map[r][c] = 2;
				result++;
				continue;
			}
		}

//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		System.out.println(result);

		in.close();
	}

}
