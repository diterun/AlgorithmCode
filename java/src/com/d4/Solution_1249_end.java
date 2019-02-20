package com.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Solution_1249_end {
	static int MAX = 102;
	static int T, test_case;
	static int result, n;
	/**
	 * 전체 맵
	 * -1로 초기화 하여서 -1은 아예 갈 수 없는 맵의 끝
	 */
	static int[][] map = new int[MAX][MAX];
	/**
	 * 그 좌표에 도달 할 수 있는 최소의 값
	 * 처음에는 100 * 100 * 10 이라는 모두 파져 있어도 나올 수 없는 값으로 초기화한다.
	 */
	static int[][] minimum = new int[MAX][MAX];
	static int[][] move = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	static char[] line;

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/1249.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine().trim());

		for (test_case = 1; test_case <= T; test_case++) {
			/**
			 * 초기화
			 */
			result = 100000;	//나올 수 없는 값
			for (int i = 0; i < MAX; i++) {
				for (int j = 0; j < MAX; j++) {
					map[i][j] = -1;
					minimum[i][j] = 100000;	//나올 수 없는 값
				}
			}
			
			n = Integer.parseInt(br.readLine().trim());

			for (int i = 1; i <= n; i++) {
				line = br.readLine().toCharArray();
				for (int j = 1; j <= n; j++) {
					map[i][j] = line[j - 1] - '0';
				}
			}
			
			/**
			 * 시작 좌표 1, 1
			 * 그리고 가장 처음 구덩이를 팠던 값은 0
			 */
			getLowerWay(1, 1, 0);
			
			System.out.println("#" + test_case + " " + result);
		}
		
		br.close();
	}

	private static void getLowerWay(int y, int x, int sum) {
		if(y == n && x == n) {
			result = result < sum ? result : sum;
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int my = y + move[i][0];
			int mx = x + move[i][1];
			
			/**
			 * 움직이려는 곳이 벽(-1)이면 가지 않는다.
			 */
			if(map[my][mx] != -1) {
				sum += map[my][mx];
				/**
				 * 움직인 곳을 더했는데, 이미 한 번 나왔던 result보다 크다면 그쪽으로 가지 않는다.
				 */
				if(sum > result) {
					sum -= map[my][mx];
					continue;
				}
				/**
				 * 밟은 곳에 적혀 있는 minimum값보다 크면 가지 않는다.
				 */
				if(minimum[my][mx] > sum) {
					minimum[my][mx] = sum;	//sum이 작으면 작은 값을 넣어준다.
					
					getLowerWay(my, mx, sum);
				}
				sum -= map[my][mx];
			}
		}
	}

}
