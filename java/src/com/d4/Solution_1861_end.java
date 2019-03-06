package com.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_1861_end {
	static int T, test_case;
	static int result[], n, max, maxi, len;
	static int[][] map;
	static int[][] move = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 }};
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/1861.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine().trim());

		for (test_case = 1; test_case <= T; test_case++) {
			max = 0;
			
			n = Integer.parseInt(br.readLine().trim());
			len = n * n + 1;

			map = new int[n + 2][n + 2];
			result = new int[len];

			for (int i = 1; i <= n; i++) {
				st = new StringTokenizer(br.readLine());

				for (int j = 1; j <= n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					result[map[i][j]] = bfs(i, j);
				}
			}
			
			for (int i = 0; i < len; i++) {
				if(max < result[i]) {
					max = result[i];
					maxi = i;
				}
			}

			System.out.println("#" + test_case + " " + maxi + " " + max);
		}

		br.close();
	}

	private static int bfs(int i, int j) {
		LinkedList<Integer> yq = new LinkedList<>();
		LinkedList<Integer> xq = new LinkedList<>();
		int y, x, ny, nx;
		int now = map[i][j];
		int cnt = 1;

		yq.offer(i);
		xq.offer(j);
		
		while(!yq.isEmpty()) {
			y = yq.poll();
			x = xq.poll();
			
			for (int k = 0; k < 4; k++) {
				ny = y + move[k][0];
				nx = x + move[k][1];
				
				if(map[ny][nx] == now + 1) {
					now = map[ny][nx];
					yq.offer(ny);
					xq.offer(nx);
					cnt++;
					break;
				}
			}
		}
		
		return cnt;
	}
}
