package com.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1493_end {
	static int MAX = 300;
	static int T, test_case;
	static int p, q, x1, y1, x2, y2, temp, x, y;
	static int[] sero = new int[MAX];
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/d3/1493.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine().trim());
		
		sero[0] = 1;
		
		for (int i = 1; i < MAX; i++) {
			sero[i] = sero[i - 1] + i;
		}
		
		for (test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			p = Integer.parseInt(st.nextToken());
			q = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i < MAX - 1; i++) {
				if(sero[i] <= p && p < sero[i + 1]) {
					temp = p - sero[i];
					
					x1 = 1 + temp;
					y1 = i + 1 - temp;
					break;
				}
			}
			
			for (int i = 0; i < MAX - 1; i++) {
				if(sero[i] <= q && q < sero[i + 1]) {
					temp = q - sero[i];

					x2 = 1 + temp;
					y2 = i + 1 - temp;
					break;
				}
			}
			
			x = x1 + x2;
			y = y1 + y2;
			
			sb.append("#").append(test_case).append(" ").append(sero[y + x - 2] + x - 1).append("\n");
		}
		System.out.println(sb);
		
		br.close();
	}
}
