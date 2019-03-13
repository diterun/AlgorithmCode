package com.baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 종완드래곤 {

	static int[][] map;
	static ArrayList<Integer> list;

	static int[] dy = { 0, -1, 0, 1 };
	static int[] dx = { 1, 0, -1, 0 };
	
	static int result;

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());

		map = new int[101][101];
		list = new ArrayList<>();

		String[] line;
		for (int i = 0; i < N; i++) {
			list.clear();
			line = in.readLine().split(" ");
			int y = Integer.parseInt(line[1]);
			int x = Integer.parseInt(line[0]);
			int initDir = Integer.parseInt(line[2]);
			int cnt = Integer.parseInt(line[3]);
			int[] lastPoint = new int[2];
			lastPoint[0] = y+ dy[initDir];
			lastPoint[1] = x+ dx[initDir];
			map[y][x] = 1;
			map[lastPoint[0]][lastPoint[1]] = 1;
			
			
			list.add(initDir);
			for (int j = 0; j < cnt; j++) {
				for (int k = list.size()-1; k >= 0; k--) {

					int dir = list.get(k);
					if(dir == 3) {
						dir = 0;
					}else {
						dir+=1;
					}
					
					list.add(dir);
					lastPoint[0]+= dy[dir];
					lastPoint[1]+= dx[dir];
					if(lastPoint[0] < 0 || lastPoint[1] < 0 ||lastPoint[0] >=101 ||lastPoint[1] >=101) continue; 
					map[lastPoint[0]][lastPoint[1]] = 1;
				}
			}
		}
		
		for (int i = 0; i <= 99; i++) {
			for (int j = 0; j <= 99; j++) {
				if(map[i][j] == 1 && map[i][j+1] == 1 && map[i+1][j] == 1 && map[i+1][j+1] == 1) {
					result++;
				}
			}
		}
		
		System.out.println(result);

	}

}
