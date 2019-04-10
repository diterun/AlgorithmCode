package com.none;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4014_end_활주로건설 {
	static int T, t;
	static int n, x, result, prev, now;
	static int[][] map;
	static int[] jihyoungCnt = new int[7];
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/none/4014.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine().trim());

		for (t = 1; t <= T; t++) {
			result = 0;
			
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			map = new int[n][n];
			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				boolean can = true;
				boolean isUp = true;
				prev = 0;
				
				for (int j = 0; j < n; j++) {
					now = Integer.parseInt(st.nextToken());
					map[i][j] = now;
					
					if(now != prev && prev != 0) {
						if(now == prev + 1) {
							if(isUp) {
								if(jihyoungCnt[prev] >= x) {
										jihyoungCnt[prev] = 0;
										jihyoungCnt[now] = 1;
								} else {
									jihyoungCnt[prev] = 0;
									can = false;
								}
							} else {
								if(jihyoungCnt[prev] >= (x * 2)) {
									jihyoungCnt[prev] = 0;
									jihyoungCnt[now] = 1;
								} else {
									jihyoungCnt[prev] = 0;
									can = false;
								}
							}
							isUp = true;
						} else if(now == prev - 1) {
							if(!isUp) {
								if(jihyoungCnt[prev] >= x) {
									jihyoungCnt[prev] = 0;
									jihyoungCnt[now] = 1;
								} else {
									jihyoungCnt[prev] = 0;
									can = false;
								}
							} else {
								jihyoungCnt[prev] = 0;
								jihyoungCnt[now] = 1;
							}
							isUp = false;
						} else {
							jihyoungCnt[prev] = 0;
							can = false;
						}
					} else {
						jihyoungCnt[now]++;
					}
					prev = now;
				}
				if(!isUp) {
					if(jihyoungCnt[now] < x) {
						can = false;
					}
				}
				jihyoungCnt[now] = 0;
				if(can) {
					result++;
				}
			}
			
			for (int j = 0; j < n; j++) {
				boolean can = true;
				boolean isUp = true;
				prev = 0;
				
				for (int i = 0; i < n; i++) {
					now = map[i][j];
					
					if(now != prev && prev != 0) {
						if(now == prev + 1) {
							if(isUp) {
								if(jihyoungCnt[prev] >= x) {
										jihyoungCnt[prev] = 0;
										jihyoungCnt[now] = 1;
								} else {
									jihyoungCnt[prev] = 0;
									can = false;
								}
							} else {
								if(jihyoungCnt[prev] >= (x * 2)) {
									jihyoungCnt[prev] = 0;
									jihyoungCnt[now] = 1;
								} else {
									jihyoungCnt[prev] = 0;
									can = false;
								}
							}
							isUp = true;
						} else if(now == prev - 1) {
							if(!isUp) {
								if(jihyoungCnt[prev] >= x) {
									jihyoungCnt[prev] = 0;
									jihyoungCnt[now] = 1;
								} else {
									jihyoungCnt[prev] = 0;
									can = false;
								}
							} else {
								jihyoungCnt[prev] = 0;
								jihyoungCnt[now] = 1;
							}
							isUp = false;
						} else {
							jihyoungCnt[prev] = 0;
							can = false;
						}
					} else {
						jihyoungCnt[now]++;
					}
					prev = now;
				}
				
				if(!isUp) {
					if(jihyoungCnt[now] < x) {
						can = false;
					}
				}
				jihyoungCnt[now] = 0;
				if(can) {
					result++;
				}
			}
			
			System.out.println("#" + t + " " + result);
		}

		br.close();
	}
}
