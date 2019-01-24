package com.d4;

import java.io.BufferedReader;
import java.io.FileReader;

public class Solution_1249 {
	static int MAX = 102;
	static int T, test_case;
	static int result, n;
	/**
	 * 전체 맵
	 * -1로 초기화 하여서 -1은 아예 갈 수 없는 맵의 끝
	 */
	static int[][] map = new int[MAX][MAX];
	/**
	 * 맵의 그 부분을 갔는지 안 갔는지 체크한다.
	 */
	static boolean[][] check = new boolean[MAX][MAX];
	/**
	 * 그 좌표에 도달 할 수 있는 최소의 값
	 * 처음에는 100 * 100 * 10 이라는 모두 파져 있어도 나올 수 없는 값으로 초기화한다.
	 */
	static int[][] minimum = new int[MAX][MAX];
	static int[][] move = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	static char[] line;

	public static void main(String[] args) throws Exception{
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("res/1249.txt"));
		
		T = Integer.parseInt(br.readLine().trim());

		for (test_case = 1; test_case <= T; test_case++) {
			result = 0;
			for (int i = 0; i < MAX; i++) {
				for (int j = 0; j < MAX; j++) {
					map[i][j] = -1;
					minimum[i][j] = 100000;
					check[i][j] = false;
				}
			}
			
			n = Integer.parseInt(br.readLine().trim());

			for (int i = 1; i <= n; i++) {
				line = br.readLine().toCharArray();
				for (int j = 1; j <= n; j++) {
					map[i][j] = line[j - 1] - '0';
				}
			}
			
//			for (int i = 1; i <= n; i++) {
//				for (int j = 1; j <= n; j++) {
//					System.out.print(map[i][j] + " ");
//				}
//				System.out.println();
//			}
			
			/**
			 * 시작 좌표 1, 1
			 * 그리고 가장 처음 구덩이를 팠던 값은 0
			 */
			result = getLowerWay(1, 1, 0);
			
			System.out.println("#" + test_case + " " + result);
		}
		
		br.close();
	}

	private static int getLowerWay(int y, int x, int sum) {
		if(y == n && x == n) {
			return sum;
		}
		
		check[y][x] = true;
		sum += map[y][x];
		if(minimum[y][x] > sum) {
			minimum[y][x] = sum;
		} else {
			System.out.println("hi");
			return -1;
		}
		
		for (int i = 0; i < 4; i++) {
			int my = y + move[i][0];
			int mx = x + move[i][1];
			
			if(map[my][mx] != -1 && !check[my][mx]) {
				int subSum = getLowerWay(my, mx, sum);
				if(subSum != -1) {
					sum = sum < subSum ? sum : subSum;
				}
			}
		}
		
		return sum;
	}

}
