package com.d5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_7396_종구의딸이름짓기 {
	static int T, t, n, m;
	static char[][] map;
	static boolean[][] check;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static MQ q = new MQ();

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/7396.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine().trim());

		for (t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			map = new char[n][];
			check = new boolean[n][m];
			
			for (int i = 0; i < n; i++) {
				map[i] = br.readLine().toCharArray();
			}
			
			sb.append(map[0][0]);
			check[0][0] = true;
			q.offer(0);
			while(!q.isEmpty()) {
				MQ tq = new MQ();
				int size = q.size;
				char now = 'z' + 1;
				
//				System.out.println("============" +size);
				for (int i = 0; i < size; i++) {
					int num = q.pop();
					int y = num / 10000;
					int x = num % 10000;
					int dy = y + 1;
					int dx = x + 1;
					
//					System.out.println(num + " : " + dy + " " + x);
					if(dy < n && !check[dy][x]) {
						check[dy][x] = true;
						if(now > map[dy][x]) {
							tq.clear();
							now = map[dy][x];
							tq.offer(dy * 10000 + x);
						} else if(now == map[dy][x]) {
							tq.offer(dy * 10000 + x);
						}
					}
					if(dx < m && !check[y][dx]) {
						check[y][dx] = true;
						if(now > map[y][dx]) {
							tq.clear();
							now = map[y][dx];
							tq.offer(y * 10000 + dx);
						} else if(now == map[y][dx]) {
							tq.offer(y * 10000 + dx);
						}
					}
				}
				
				if(!tq.isEmpty()) {
					sb.append(tq.peek());
				}
				
				q.clear();
				size = tq.size;
				for (int i = 0; i < size; i++) {
					q.offer(tq.pop());
				}
			}
			
			sb.append("\n");
		}
		System.out.print(sb);

		br.close();
	}
	
	public static class MQ{
		private int max = 4000;
		private int s;
		private int e;
		private int[] list = new int[max];
		public int size;
		
		public boolean isEmpty() {
			return s == e;
		}
		
		public boolean isFull() {
			return s - max == e;
		}
		
		public void offer(int num) {
			if(isFull()) {
				return;
			}
			list[s % max] = num;
			s++;
			size++;
		}
		
		public int pop() {
			if(isEmpty()) {
				return -1;
			}
			int a = list[e % max];
			e++;
			size--;
			return a;
		}
		
		public char peek() {
			int n = list[e];
			return map[n / 10000][n % 10000];
		}
		
		public void clear() {
			s = e = size = 0;
		}
	}
}
