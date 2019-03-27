package com.baek;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15684_사다리조작 {
	static int n, m, h, result, a, b, max;
	static boolean[][] sadary;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		result = 0;
		
		System.setIn(new FileInputStream("baek/15684.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		/**
		 * 0번째와 n번째는 사다리의 끝 부분이다!
		 * 1 - 1번과 2번 사이의 가로줄이 있는 영역...
		 * 2 - 2번과 3번 사이의 가로줄이 있는 영역...
		 * ...
		 */
		sadary = new boolean[n + 1][h + 1];
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			sadary[b][a] = true;
		}
		
		if(canSadaryGame()) {
			System.out.println(0);
			br.close();
			return;
		}

		max = 1;
		sadaryGame(1, 0);
		if(result != 0) {
			System.out.println(result);
			br.close();
			return;
		}
		max = 2;
		sadaryGame(1, 0);
		if(result != 0) {
			System.out.println(result);
			br.close();
			return;
		}
		max = 3;
		sadaryGame(1, 0);
		if(result != 0) {
			System.out.println(result);
			br.close();
			return;
		}
		
		System.out.println(-1);
		
		br.close();
	}

	private static void sadaryGame(int si, int cnt) {
		if(cnt == max) {
			if(canSadaryGame()) {
				result = max;
			}
			return;
		}
		
		for (int i = si; i < n; i++) {
			for (int j = 1; j <= h; j++) {
				if(!sadary[i][j] && !sadary[i - 1][j] && !sadary[i + 1][j]) {
					sadary[i][j] = true;
					sadaryGame(i, cnt + 1);
					sadary[i][j] = false;
				}
			}
		}
	}

	private static boolean canSadaryGame() {
		boolean okok = true;
		int a = 1;

//		for (int i = 0; i <= n; i++) {
//			for (int j = 1; j <= h; j++) {
//				if(sadary[i][j]) {
//					System.out.print("t ");
//				} else {
//					System.out.print("f ");
//				}
//			}
//			System.out.println();
//		}
		
		for (int i = 1; i <= n; i++) {
			a = i;
			
			for (int j = 1; j <= h; j++) {
				if(sadary[a][j]) {
					a++;
				} else if(sadary[a - 1][j]) {
					a--;
				}
			}
			
//			System.out.println(a + " " + i );
			if(a != i) {
				okok = false;
				break;
			}
		}
//		System.out.println(okok);
//		System.out.println();
		
		return okok;
	}
}
