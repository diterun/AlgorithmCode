package com.baek;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3055_end_탈출 {
	static int r, c, result;
	static char[][] map;
	static int[][] move = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static boolean[][] check;
	static boolean isLast;
	static MQ water = new MQ();
	static MQ gosem = new MQ();
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/baek/3055.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		result = 0;
		
		map = new char[r + 2][c + 2];
		check = new boolean[r + 2][c + 2];
		for (int i = 0; i < r + 2; i++) {
			for (int j = 0; j < c + 2; j++) {
				map[i][j] = 'X';
			}
		}
		
		for (int i = 1; i <= r; i++) {
			char[] line = br.readLine().toCharArray();
			for (int j = 1; j <= c; j++) {
				switch(line[j - 1]) {
				case 'X':
					map[i][j] = 'X';
					break;
				case '.':
					map[i][j] = '.';
					break;
				case 'D':
					map[i][j] = 'D';
					break;
				case 'S':
					gosem.offer(i * 100 + j);
					map[i][j] = '.';
					check[i][j] = true;
					break;
				case '*':
					water.offer(i * 100 + j);
					map[i][j] = '*';
					break;
				}
			}
		}
		
		while(!gosem.isEmpty()) {
			isLast = false;
			int size = water.size;
			
			for (int i = 0; i < size; i++) {
				int n = water.poll();
				int dy = n / 100;
				int dx = n % 100;
				
				for (int j = 0; j < 4; j++) {
					int ny = dy + move[j][0];
					int nx = dx + move[j][1];
					
					if(map[ny][nx] == '.') {
						water.offer(ny * 100 + nx);
						map[ny][nx] = '*';
					}
				}
			}
			
			size = gosem.size;
			
			for (int i = 0; i < size; i++) {
				int n = gosem.poll();
				int dy = n / 100;
				int dx = n % 100;
				
				for (int j = 0; j < 4; j++) {
					int ny = dy + move[j][0];
					int nx = dx + move[j][1];
					
					if(!check[ny][nx] && map[ny][nx] == '.') {
						check[ny][nx] = true;
						gosem.offer(ny * 100 + nx);
					} else if(map[ny][nx] == 'D') {
						isLast = true;
						i = size;
						break;
					}
				}
			}

			result++;
			if(isLast) {
				break;
			}
		}
		
		if(isLast) {
			System.out.println(result);
		} else {
			System.out.println("KAKTUS");
		}

		br.close();
	}
	
	static class MQ {
		private int MAX = 100;
		private int s = 0;
		private int e = 0;
		private int[] list = new int[MAX];
		int size = 0;
		
		public boolean isFull() {
			return s - MAX == e;
		}
		
		public boolean isEmpty() {
			return s == e;
		}
		
		public void offer(int n) {
			if(isFull()) {
				return;
			}
			list[s % MAX] = n;
			s++;
			size++;
		}
		
		public int poll() {
			if(isEmpty()) {
				return -1;
			}
			int n = list[e % MAX];
			e++;
			size--;
			return n;
		}
		
		public int peek() {
			if(isEmpty()) {
				return -1;
			}
			return list[e];
		}
		
		public void clear() {
			s = e = size = 0;
		}
	}
}
