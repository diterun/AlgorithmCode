package com.none;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Solution4317_DaYe3{
	static int T, test_case;
	static int H, W, result;
	static int[][] map = new int[12][27];
	static int[][] dp = new int[27][1<<12];
	static String[] inputLine;
	
	static boolean check(int r, int c) {
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				if(r + i > H || c + j > W) {
					return false;
				}
				if(map[r + i][c + j] != 0) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	static void paint(int r, int c, int num) {
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				map[r + i][c + j] = num;
			}
		}
	}
	
	static void func(int r, int c, int cnt) {
		if(c == W + 1) {
			result = result > cnt ? result : cnt;
			return;
		}
		if(r == 1) {
			int bit = 0;
			
			for (int i = 1; i <= H; i++) {
				bit |= map[i][c] << i;
			}
			
			if(dp[c][bit] >= cnt) {
				return;
			}
			dp[c][bit] = cnt;
		}
		
		int nr = r + 1;
		int nc = c;
		
		if(nr == H + 1) {
			nr = 1;
			nc++;
		}
		if (check(r, c)) {
			paint(r, c, 1);
			func(nr, nc, cnt + 1);
			paint(r, c, 0);
		}
		func(nr, nc, cnt);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("res/4317.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine().trim());
		
		for(test_case = 1; test_case <= T; test_case++) {
			result = 0;
			for (int i = 0; i < 27; i++) {
				for (int j = 0; j < (1 << 12); j++) {
					dp[i][j] = -1;
				}
			}
			result = 0;
			
			inputLine = br.readLine().split(" ");
			H = Integer.parseInt(inputLine[0].trim());
			W = Integer.parseInt(inputLine[1].trim());
			
			for (int i = 1; i <= H; i++) {
				inputLine = br.readLine().split(" ");
				for (int j = 1; j <= W; j++) {
					map[i][j] = Integer.parseInt(inputLine[j - 1].trim());
				}
			}
			
			func(1, 1, 0);
			
			System.out.println("#" + test_case + " " + result);
		}
		
		br.close();
	}
}