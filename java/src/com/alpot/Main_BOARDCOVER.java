package com.alpot;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOARDCOVER {
	static int c, t, h, w, result, dotCnt;
	static char[][] map;
	static int[][][] stamp = {{{1, 0}, {1, -1}}, {{1, 0}, {0, 1}}
							, {{0, 1}, {1, 1}}, {{1, 0}, {1, 1}}};
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/alpot/boardcover.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		c = Integer.parseInt(br.readLine().trim());
		
		for (t = 1; t <= c; t++) {
			result = dotCnt = 0;
			
			st = new StringTokenizer(br.readLine().trim());
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			
			map = new char[h][];
			
			for (int i = 0; i < h; i++) {
				map[i] = br.readLine().toCharArray();
				
				for (int j = 0; j < w; j++) {
					if(map[i][j] == '.') {
						dotCnt++;
					}
				}
			}
			
			if(dotCnt % 3 != 0) {
				System.out.println(0);
				continue;
			}
			dotCnt = dotCnt / 3;
			
			paintStamp(0, 0, 0);
			
			System.out.println(result);
		}
		
		br.close();
	}

	private static void paintStamp(int y, int x, int cnt) {
		if(cnt == dotCnt) {
			result++;
			return;
		}
		if(y == h - 1) {
			return;
		}
		
		if(map[y][x] == '#') {
			if(x == w - 1)
				paintStamp(y + 1, 0, cnt);
			else
				paintStamp(y, x + 1, cnt);
		} else {
			if(x == w - 1) {
				if(map[y + 1][x] == '.' && map[y + 1][x - 1] == '.') {
					map[y][x] = '#';
					map[y + 1][x] = '#';
					map[y + 1][x - 1] = '#';
					
					paintStamp(y + 1, 0, cnt + 1);
					
					map[y][x] = '.';
					map[y + 1][x] = '.';
					map[y + 1][x - 1] = '.';
				} else {
					return;
				}
			} else if(x == 0) {
				for (int i = 1; i < 4; i++) {
					boolean canPaint = true;
					
					for (int j = 0; j < 2; j++) {
						int dy = y + stamp[i][j][0];
						int dx = x + stamp[i][j][1];
						
						if(map[dy][dx] == '#') {
							canPaint = false;
							break;
						}
					}
					
					if(canPaint) {
						map[y][x] = '#';
						map[y + stamp[i][0][0]][x + stamp[i][0][1]] = '#';
						map[y + stamp[i][1][0]][x + stamp[i][1][1]] = '#';
						
						paintStamp(y, x + 1, cnt + 1);
						
						map[y][x] = '.';
						map[y + stamp[i][0][0]][x + stamp[i][0][1]] = '.';
						map[y + stamp[i][1][0]][x + stamp[i][1][1]] = '.';
					}
				}
			} else {
				for (int i = 0; i < 4; i++) {
					boolean canPaint = true;
					
					for (int j = 0; j < 2; j++) {
						int dy = y + stamp[i][j][0];
						int dx = x + stamp[i][j][1];
						
						if(map[dy][dx] == '#') {
							canPaint = false;
							break;
						}
					}
					
					if(canPaint) {
						map[y][x] = '#';
						map[y + stamp[i][0][0]][x + stamp[i][0][1]] = '#';
						map[y + stamp[i][1][0]][x + stamp[i][1][1]] = '#';
						
						paintStamp(y, x + 1, cnt + 1);
						
						map[y][x] = '.';
						map[y + stamp[i][0][0]][x + stamp[i][0][1]] = '.';
						map[y + stamp[i][1][0]][x + stamp[i][1][1]] = '.';
					}
				}
			}
		}
	}
}
