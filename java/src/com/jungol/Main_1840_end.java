package com.jungol;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_1840_end {
	static int y, x, cnt, hour;
	static int[][] map;
	static int[][] move = {{1, 0},{-1, 0},{0, 1},{0, -1}};
	static LinkedList<Integer> q = new LinkedList<>();
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/jung1840.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		y = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		map = new int[y + 2][x + 2];
		
		for (int i = 0; i < y + 2; i++) {
			for (int j = 0; j < x + 2; j++) {
				map[i][j] = 2;
			}
		}
		
		for (int i = 1; i <= y; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= x; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(true) {
			boolean last = true;
			boolean[][] check = new boolean[y + 2][x + 2];
			int subCnt = 0;
			
			q.offer(1001);
			check[1][1] = true;
			
			while(!q.isEmpty()) {
				int num = q.poll();
				int ny = num / 1000;
				int nx = num % 1000;
				
				for (int i = 0; i < 4; i++) {
					int dy = ny + move[i][0];
					int dx = nx + move[i][1];
					
					if(!check[dy][dx] && map[dy][dx] == 1) {
						check[dy][dx] = true;
						subCnt++;
						map[dy][dx] = 0;
						last = false;
					} else if(!check[dy][dx] && map[dy][dx] == 0) {
						check[dy][dx] = true;
						q.offer(dy * 1000 + dx);
					}
				}
			}
			
			hour++;
			if(last) {
				hour--;
				break;
			} else {
				cnt = subCnt;
			}
		}

		System.out.println(hour);
		System.out.println(cnt);
		
		br.close();
	}
}
