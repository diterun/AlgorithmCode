package com.baek;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main_15683_end {
	static int MAX = 10, CCTVMAX = 8;
	static int N, M, c, result;
	/**
	 * CCTV들
	 * [0] = y축
	 * [1] = x축
	 * [2] = 번호
	 */
	static int[][] CCTV = new int[CCTVMAX][3];
	/**
	 * 순서대로 아래, 왼쪽, 위, 오른쪽
	 */
	static int[][] move = {{}, {1, 0},{0, -1},{-1, 0},{0, 1}};
	static String[] line;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/baek/15683.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		/**
		 * 맵
		 */
		int[][] map = new int[MAX][MAX];
		
		for (int i = 0; i < MAX; i++) {
			for (int j = 0; j < MAX; j++) {
				map[i][j] = 6;
			}
		}
		
		line = br.readLine().split(" ");
		N = Integer.parseInt(line[0]);
		M = Integer.parseInt(line[1]);
		
		c = 0;
		for (int i = 1; i <= N; i++) {
			line = br.readLine().split(" ");
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(line[j - 1]);
				
				if(1 <= map[i][j] && map[i][j] <= 5) {
					CCTV[c][0] = i;
					CCTV[c][1] = j;
					CCTV[c++][2] = map[i][j];
				}
			}
		}
		
		result = getHideGround(map, 0);
		
		System.out.println(result);
		
		br.close();
	}

	public static int getHideGround(int[][] map, int cnt) {
		int sum = 1000, subsum = 1000;
		if(cnt == c) {
			int count = 0;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					if(map[i][j] == 0) {
						count++;
					}
				}
			}
//			if(sum == 0) {
//				for (int i = 1; i <= N; i++) {
//					for (int j = 1; j <= M; j++) {
//						System.out.print(map[i][i] + " ");
//					}
//					System.out.println();
//				}
//			}
			
			return count;
		}
		int[][] newMap;
		
		switch(CCTV[cnt][2]) {
		case 5:
			newMap = makeNewMap(map);
			paint(newMap, CCTV[cnt][0], CCTV[cnt][1], 1, 5);
			paint(newMap, CCTV[cnt][0], CCTV[cnt][1], 2, 5);
			paint(newMap, CCTV[cnt][0], CCTV[cnt][1], 3, 5);
			paint(newMap, CCTV[cnt][0], CCTV[cnt][1], 4, 5);
			sum = getHideGround(newMap, cnt + 1);
			break;
		case 4:
			newMap = makeNewMap(map);
			paint(newMap, CCTV[cnt][0], CCTV[cnt][1], 1, 4);
			paint(newMap, CCTV[cnt][0], CCTV[cnt][1], 2, 4);
			paint(newMap, CCTV[cnt][0], CCTV[cnt][1], 3, 4);
			subsum = getHideGround(newMap, cnt + 1);
			sum = sum < subsum ? sum : subsum;
			
			newMap = makeNewMap(map);
			paint(newMap, CCTV[cnt][0], CCTV[cnt][1], 1, 4);
			paint(newMap, CCTV[cnt][0], CCTV[cnt][1], 2, 4);
			paint(newMap, CCTV[cnt][0], CCTV[cnt][1], 4, 4);
			subsum = getHideGround(newMap, cnt + 1);
			sum = sum < subsum ? sum : subsum;
			
			newMap = makeNewMap(map);
			paint(newMap, CCTV[cnt][0], CCTV[cnt][1], 1, 4);
			paint(newMap, CCTV[cnt][0], CCTV[cnt][1], 3, 4);
			paint(newMap, CCTV[cnt][0], CCTV[cnt][1], 4, 4);
			subsum = getHideGround(newMap, cnt + 1);
			sum = sum < subsum ? sum : subsum;
			
			newMap = makeNewMap(map);
			paint(newMap, CCTV[cnt][0], CCTV[cnt][1], 2, 4);
			paint(newMap, CCTV[cnt][0], CCTV[cnt][1], 3, 4);
			paint(newMap, CCTV[cnt][0], CCTV[cnt][1], 4, 4);
			subsum = getHideGround(newMap, cnt + 1);
			sum = sum < subsum ? sum : subsum;
			break;
		case 3:
			newMap = makeNewMap(map);
			paint(newMap, CCTV[cnt][0], CCTV[cnt][1], 1, 3);
			paint(newMap, CCTV[cnt][0], CCTV[cnt][1], 2, 3);
			subsum = getHideGround(newMap, cnt + 1);
			sum = sum < subsum ? sum : subsum;

			newMap = makeNewMap(map);
			paint(newMap, CCTV[cnt][0], CCTV[cnt][1], 2, 3);
			paint(newMap, CCTV[cnt][0], CCTV[cnt][1], 3, 3);
			subsum = getHideGround(newMap, cnt + 1);
			sum = sum < subsum ? sum : subsum;

			newMap = makeNewMap(map);
			paint(newMap, CCTV[cnt][0], CCTV[cnt][1], 3, 3);
			paint(newMap, CCTV[cnt][0], CCTV[cnt][1], 4, 3);
			subsum = getHideGround(newMap, cnt + 1);
			sum = sum < subsum ? sum : subsum;

			newMap = makeNewMap(map);
			paint(newMap, CCTV[cnt][0], CCTV[cnt][1], 1, 3);
			paint(newMap, CCTV[cnt][0], CCTV[cnt][1], 4, 3);
			subsum = getHideGround(newMap, cnt + 1);
			sum = sum < subsum ? sum : subsum;
			break;
		case 2:
			newMap = makeNewMap(map);
			paint(newMap, CCTV[cnt][0], CCTV[cnt][1], 1, 2);
			paint(newMap, CCTV[cnt][0], CCTV[cnt][1], 3, 2);
			subsum = getHideGround(newMap, cnt + 1);
			sum = sum < subsum ? sum : subsum;

			newMap = makeNewMap(map);
			paint(newMap, CCTV[cnt][0], CCTV[cnt][1], 2, 2);
			paint(newMap, CCTV[cnt][0], CCTV[cnt][1], 4, 2);
			subsum = getHideGround(newMap, cnt + 1);
			sum = sum < subsum ? sum : subsum;
			break;
		case 1:
			newMap = makeNewMap(map);
			paint(newMap, CCTV[cnt][0], CCTV[cnt][1], 1, 1);
			subsum = getHideGround(newMap, cnt + 1);
			sum = sum < subsum ? sum : subsum;

			newMap = makeNewMap(map);
			paint(newMap, CCTV[cnt][0], CCTV[cnt][1], 2, 1);
			subsum = getHideGround(newMap, cnt + 1);
			sum = sum < subsum ? sum : subsum;

			newMap = makeNewMap(map);
			paint(newMap, CCTV[cnt][0], CCTV[cnt][1], 3, 1);
			subsum = getHideGround(newMap, cnt + 1);
			sum = sum < subsum ? sum : subsum;

			newMap = makeNewMap(map);
			paint(newMap, CCTV[cnt][0], CCTV[cnt][1], 4, 1);
			subsum = getHideGround(newMap, cnt + 1);
			sum = sum < subsum ? sum : subsum;
			break;
		}
		
		return sum;
	}
	
	public static int[][] makeNewMap(int[][] map){
		int[][] newMap = new int[MAX][MAX];
		
		for (int i = 0; i < MAX; i++) {
			for (int j = 0; j < MAX; j++) {
				newMap[i][j] = map[i][j];
			}
		}
		
		return newMap;
	}
	
	public static void paint(int[][] map, int y, int x, int dir, int color) {
		for (int i = 0; i < 10; i++) {
			int dy = y + (move[dir][0] * i);
			int dx = x + (move[dir][1] * i);
			
			if(map[dy][dx] == 6) {
				break;
			} else if(map[dy][dx] == 0) {
				map[dy][dx] = color;
			}
		}
	}
}
