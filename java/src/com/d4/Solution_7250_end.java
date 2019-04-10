package com.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_7250_end {
	static int T, test_case;
	static int n, m, k, result;
	static char[][] map;
	static int[][] move = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	static char[] input;
	static boolean[][][] check;
	static int[][] check2;
	static LinkedList<Integer> scatQ = new LinkedList<>();
	static LinkedList<Integer> ghostQ = new LinkedList<>();
	static LinkedList<Integer> fireQ = new LinkedList<>();
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/d4/7250.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine().trim());

		for (test_case = 1; test_case <= T; test_case++) {
			result = 0;
			scatQ.clear();
			ghostQ.clear();
			fireQ.clear();
			
			st = new StringTokenizer(br.readLine());

			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			
			map = new char[n + 2][m + 2];
			check = new boolean[2][n + 2][m + 2];
			check2 = new int[n + 2][m + 2];
			
			for (int i = 0; i < n + 2; i++) {
				for (int j = 0; j < m + 2; j++) {
					map[i][j] = 'X';
					check2[i][j] = 100;
				}
			}
			
			for (int i = 1; i <= n; i++) {
				input = br.readLine().toCharArray();
				for (int j = 1; j <= m; j++) {
					map[i][j] = input[j - 1];
					if(map[i][j] == 'S') {
						map[i][j] = 'A';
						check2[i][j] = 1;
						scatQ.offer(i * 10000 + j);
					}
					if(map[i][j] == 'V') {
						map[i][j] = 'A';
						check[0][i][j] = true;
						ghostQ.offer(i * 10000 + j);
					}
					if(map[i][j] == 'F') {
						check[1][i][j] = true;
						fireQ.offer(i * 10000 + j);
					}
				}
			}
			
			bfs();
			
			System.out.println("#" + test_case + " " + (result + 1));
		}

		br.close();
	}
	
	static void bfs() {
		while(!scatQ.isEmpty()) {
			int fsize = fireQ.size();
			
			for (int i = 0; i < fsize; i++) {
				int num = fireQ.poll();
				int y = num / 10000;
				int x = num % 10000;
				
				for (int j = 0; j < 4; j++) {
					int dy = y + move[j][0];
					int dx = x + move[j][1];
					
					if(!check[1][dy][dx] && map[dy][dx] == 'A') {
						check[1][dy][dx] = true;
						map[dy][dx] = 'F';
						
						fireQ.offer(dy * 10000 + dx);
					}
				}
			}
			
			int gsize = ghostQ.size();
			
			for (int i = 0; i < gsize; i++) {
				int num = ghostQ.poll();
				int y = num / 10000;
				int x = num % 10000;
				
				for (int j = 0; j < 4; j++) {
					int dy = y + move[j][0];
					int dx = x + move[j][1];
					
					if(!check[0][dy][dx]) {
						if(map[dy][dx] == 'E') {
							result = -2;
							return;
						} else if(map[dy][dx] == 'A' || map[dy][dx] == 'F') {
							check[0][dy][dx] = true;
							
							ghostQ.offer(dy * 10000 + dx);
						}
					}
				}
			}
			
			int ssize = scatQ.size();
			
			for (int i = 0; i < ssize; i++) {
				int num = scatQ.poll();
				int c = num / 100000000;
				int y = (num % 100000000) / 10000;
				int x = num % 10000;
				
				for (int j = 0; j < 4; j++) {
					int dy = y + move[j][0];
					int dx = x + move[j][1];
					
					if(check2[dy][dx] > c) {
						if(map[dy][dx] == 'E') {
							return;
						} else if(map[dy][dx] == 'W' && c < k) {
//							System.out.println(dx + ", " + dy + " : " + c);
							check2[dy][dx] = c + 1;
							scatQ.offer((c + 1) * 100000000 + dy * 10000 + dx);
						} else if(map[dy][dx] == 'A') {
							check2[dy][dx] = 0;
							scatQ.offer(dy * 10000 + dx);
						}
					}
				}
			}
			
//			for (int i = 1; i <= n; i++) {
//				for (int j = 1; j <= m; j++) {
//					System.out.print(map[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
			result++;
		}
		result = -2;
	}
}
