package com.alpot;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_PICNIC {
	static int c, t, n, m, a, b, result;
	static boolean[][] friends;
	static boolean[] iGotPair;
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/alpot/picnic.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		c = Integer.parseInt(br.readLine().trim());
		
		for (t = 1; t <= c; t++) {
			result = 0;
			
			st = new StringTokenizer(br.readLine().trim());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			friends = new boolean[n][n];
			iGotPair = new boolean[n];
			
			st = new StringTokenizer(br.readLine().trim());
			for (int i = 0; i < m; i++) {
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());

				friends[a][b] = true;
				friends[b][a] = true;
			}
			
			makePair(0, 0);
			
			System.out.println(result);
		}
		
		br.close();
	}

	private static void makePair(int num, int cnt) {
		if(cnt == n / 2) {
			result++;
			return;
		}
		
		if(iGotPair[num]) {
			makePair(num + 1, cnt);
		} else {
			for (int i = 0; i < n; i++) {
				if(friends[num][i] && !iGotPair[i]) {
					iGotPair[num] = true;
					iGotPair[i] = true;
					
					makePair(num + 1, cnt + 1);
					
					iGotPair[num] = false;
					iGotPair[i] = false;
				}
			}
		}
	}
}
