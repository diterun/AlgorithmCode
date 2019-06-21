package com.alpot;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_CLOCKSYNC {
	static int c, t, result;
	static int[] map;
	/**
	 * 8과 12는 같아야 한다.
	 * 14와 15는 같아야 한다.
	 * 8과 12는 '4' 단 한 개에서 변한다.
	 * 11은 '1' 단 한 개에서 변한다.
	 * 13은 '9' 단 한 개에서 변한다.
	 * 
	 * 위 작업이 끝나면,
	 * 9는 더 이상 변할 수 없다.
	 * 10은 '2' 단 한 개에서 변한다.
	 * 6은 '3' 단 한 개에서 변한다.
	 * 
	 * 위 작업이 끝나면,
	 * 4와 5는 같아야 한다.
	 * 7은 '7' 단 한 개에서 변한다.
	 * 
	 * 위 작업이 끝나면,
	 * 4와 5는 '8' 단 한 개에서 변한다.
	 * 
	 * 위 작업이 끝나면,
	 * 3은 '6' 단 한 개에서 변한다.
	 * 
	 * 위 작업이 끝나면,
	 * 14와 15는 '5' 단 한 개에서 변한다.
	 * 
	 * 위 작업이 끝나면,
	 * '0' 단 한 개만 남는다.
	 */
	static int[][] bingle = {{0, 1, 2}
							, {3, 7, 9, 11}
							, {4, 10, 14, 15}
							, {0, 4, 5, 6, 7}
							, {6, 7, 8, 10, 12}
							, {0, 2, 14, 15}
							, {3, 14, 15}
							, {4, 5, 7, 14, 15}
							, {1, 2, 3, 4, 5}
							, {3, 4, 5, 9, 13}
							};
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/alpot/clocksync.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		c = Integer.parseInt(br.readLine().trim());
		
		for (t = 1; t <= c; t++) {
			result = 0;
			map = new int[16];
			
			st = new StringTokenizer(br.readLine().trim());
			for (int i = 0; i < 16; i++) {
				map[i] = Integer.parseInt(st.nextToken().trim());
			}
			
			if(map[8] != map[12] || map[14] != map[15]) {
				System.out.println(-1);
				continue;
			}

			if(map[8] != 12) {
				int dist = 12 - map[8];
				result += (dist / 3);
				
				for (int i = 0; i < 5; i++) {
					int a = map[bingle[4][i]] + dist;
					a = a > 12 ? a - 12 : a;
					map[bingle[4][i]] = a;
				}
			}
			if(map[11] != 12) {
				int dist = 12 - map[11];
				result += (dist / 3);
				
				for (int i = 0; i < 4; i++) {
					int a = map[bingle[1][i]] + dist;
					a = a > 12 ? a - 12 : a;
					map[bingle[1][i]] = a;
				}
			}
			if(map[13] != 12) {
				int dist = 12 - map[13];
				result += (dist / 3);
				
				for (int i = 0; i < 5; i++) {
					int a = map[bingle[9][i]] + dist;
					a = a > 12 ? a - 12 : a;
					map[bingle[9][i]] = a;
				}
			}
			if(map[9] != 12) {
				System.out.println(-1);
				continue;
			}
			if(map[10] != 12) {
				int dist = 12 - map[10];
				result += (dist / 3);
				
				for (int i = 0; i < 4; i++) {
					int a = map[bingle[2][i]] + dist;
					a = a > 12 ? a - 12 : a;
					map[bingle[2][i]] = a;
				}
			}
			if(map[6] != 12) {
				int dist = 12 - map[6];
				result += (dist / 3);
				
				for (int i = 0; i < 5; i++) {
					int a = map[bingle[3][i]] + dist;
					a = a > 12 ? a - 12 : a;
					map[bingle[3][i]] = a;
				}
			}
			if(map[4] != map[5]) {
				System.out.println(-1);
				continue;
			}
			if(map[7] != 12) {
				int dist = 12 - map[7];
				result += (dist / 3);
				
				for (int i = 0; i < 5; i++) {
					int a = map[bingle[7][i]] + dist;
					a = a > 12 ? a - 12 : a;
					map[bingle[7][i]] = a;
				}
			}
			if(map[4] != 12) {
				int dist = 12 - map[4];
				result += (dist / 3);
				
				for (int i = 0; i < 5; i++) {
					int a = map[bingle[8][i]] + dist;
					a = a > 12 ? a - 12 : a;
					map[bingle[8][i]] = a;
				}
			}
			if(map[3] != 12) {
				int dist = 12 - map[3];
				result += (dist / 3);
				
				for (int i = 0; i < 3; i++) {
					int a = map[bingle[6][i]] + dist;
					a = a > 12 ? a - 12 : a;
					map[bingle[6][i]] = a;
				}
			}
			if(map[14] != map[15]) {
				System.out.println(-1);
				continue;
			}
			if(map[14] != 12) {
				int dist = 12 - map[14];
				result += (dist / 3);
				
				for (int i = 0; i < 4; i++) {
					int a = map[bingle[5][i]] + dist;
					a = a > 12 ? a - 12 : a;
					map[bingle[5][i]] = a;
				}
			}
			if(map[0] != map[1] || map[0] != map[2]) {
				System.out.println(-1);
				continue;
			}
			if(map[0] != 12) {
				int dist = 12 - map[0];
				result += (dist / 3);
			}
			
			System.out.println(result);
		}
		
		br.close();
	}
}
