package com.baek;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15684_사다리조작 {
	static int n, m, h, result, a, b;
	static boolean[][] sadary;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
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
		sadary = new boolean[n + 1][h];
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken()) - 1;
			b = Integer.parseInt(st.nextToken());
			
			sadary[b][a] = true;
		}
		
		
		System.out.println(result);
		
		br.close();
	}
}
