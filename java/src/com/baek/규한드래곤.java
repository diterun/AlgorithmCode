package com.baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
/*
3
3 3 0 1 // x, y, dir, gen
4 2 1 3
4 2 2 1
 
 <dir>		<90도 뒤>
 0 : 오른쪽	-> 1
 1 : 위쪽		-> 2
 2 : 왼쪽		-> 3
 3 : 아래쪽 	-> 0		=> 90도 뒤, (dir+1)%4
 
 * */
public class 규한드래곤 {
static int N;
static int map[][]; // 0 ~ 100
static int arr_dir[][] = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		map = new int[101][101];
		N = Integer.parseInt(br.readLine());
		int x, y, dir, gen;
		int nx, ny;
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			dir = Integer.parseInt(st.nextToken());
			gen = Integer.parseInt(st.nextToken());
			map[y][x] = 1;
			x = x+arr_dir[dir][0];
			y = y+arr_dir[dir][1];
			map[y][x] = 1; // 0세대
			list.add(dir); // 0이 1을 만듬
			int len;
			for(int j=1; j<=gen; j++) {
				len = list.size() - 1;
				for(int go=len; go>=0; go--) {
					dir = (list.get(go)+1)%4;
					x = x+arr_dir[dir][0];
					y = y+arr_dir[dir][1];
					map[y][x] = 1; // 0세대
					list.add(dir); // 0이 1을 만듬
//					System.out.println(go);
				}
			}
			list.clear();
		}
		int cnt = 0;
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				if(map[i][j] == 1 && map[i+1][j] == 1 && map[i][j+1] ==1 && map[i+1][j+1] == 1) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}

}
