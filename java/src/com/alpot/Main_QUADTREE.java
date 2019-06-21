package com.alpot;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main_QUADTREE {
	static int c, t;
	static char[] base;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/alpot/quadtree.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		c = Integer.parseInt(br.readLine().trim());

		for (t = 1; t <= c; t++) {

			base = br.readLine().toCharArray();

			System.out.println(turnString(base));
		}

		br.close();
	}

	private static char[] turnString(char[] str) {
		if (str[0] == 'w' || str[0] == 'b') {
			return str;
		}
		int len = str.length;
		int now = 1;
		char[][] subStr = new char[4][];

		for (int i = 0; i < 4; i++) {
			int cnt = 1;
			int j = now;

			for (; j < len; j++) {
				switch (str[j]) {
				case 'w': case 'b':
					cnt--;
					break;
				case 'x':
					cnt += 3;
					break;
				}
				
				if(cnt == 0) {
					break;
				}
			}
			
			subStr[i] = new char[j - now + 1];

			for(int k = now; k <= j; k++) {
				subStr[i][k - now] = str[k];
			}
			
			subStr[i] = turnString(subStr[i]);
			
			now = j + 1;
		}

		return new StringBuilder().append('x').append(subStr[2]).append(subStr[3]).append(subStr[0]).append(subStr[1])
				.toString().toCharArray();
	}
}
