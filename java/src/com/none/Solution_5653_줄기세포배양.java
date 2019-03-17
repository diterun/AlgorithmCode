package com.none;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_5653_줄기세포배양 {
	static int PA = 300;
	static int T, test_case, n, m, k, result, cnt;
	static LinkedList<Integer> q = new LinkedList<Integer>();
	static int[][] map;
	static int[][] move = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/5653.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine().trim());

		for (test_case = 1; test_case <= T; test_case++) {
			result = cnt = 0;
			q.clear();

			st = new StringTokenizer(br.readLine().trim());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			PA = k;

			map = new int[n + (PA * 2)][m + (PA * 2)];
			
			
			for (int i = PA; i < PA +  n; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j = PA; j < PA + m; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					
					if(map[i][j] > 0) {
						q.offerFirst(map[i][j] * 100000000 + map[i][j] * 1000000 + i * 1000 + j);
					}
				}
			}
			
			while(!q.isEmpty()) {
				int size = q.size();
				
				for (int i = 0; i < size; i++) {
					int num = q.pollLast();
					int age = num / 100000000;
					int now = (num % 100000000) / 1000000;
					int y = (num % 1000000) / 1000;
					int x = num % 1000;
					
					now--;
					if(now == -1) {
						map[y][x] = (age + cnt) * 10;
						
						for (int j = 0; j < 4; j++) {
							int dy = y + move[j][0];
							int dx = x + move[j][1];
							
							if(map[dy][dx] == 0) {
								map[dy][dx] = age;
								q.offerFirst(age * 100000000 + age * 1000000 + dy * 1000 + dx);
							}
						}
					} else {
						q.offerFirst(age * 100000000 + now * 1000000 + y * 1000 + x);
					}
				}
				
				Collections.sort(q);
				
				cnt++;
				if(k == cnt) {
					break;
				}
			}

			for (int i = 0; i < n + (PA * 2); i++) {
				for (int j = 0; j < m + (PA * 2); j++) {
					if(map[i][j] <= 10 && map[i][j] > 0) {
						result++;
					} else if(map[i][j] > 10){
						if(map[i][j] > k * 10) {
							result++;
						}
					}
				}
			}

			sb.append("#").append(test_case).append(" ").append(result).append("\n");
		}
		System.out.print(sb);

		br.close();
	}

}
