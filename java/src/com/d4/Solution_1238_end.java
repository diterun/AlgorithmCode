package com.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_1238_end {
	static int MAX = 101;
	static int T, test_case;
	static int result, n, s;
	static boolean[][] rel;
	static boolean[] check;
	static LinkedList<Integer> q;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/d4/1238.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = 10;

		for (test_case = 1; test_case <= T; test_case++) {
			rel = new boolean[MAX][MAX];
			check = new boolean[MAX];
			q = new LinkedList<>();
			result = 0;
			
			st = new StringTokenizer(br.readLine().trim());
			n = Integer.parseInt(st.nextToken()) / 2;
			s = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine().trim());
			for (int i = 0; i < n; i++) {
				rel[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
			}
			
			q.offer(s);
			check[s] = true;
			
			while(true) {
				int size = q.size();
				int max = 0;
				
				for (int i = 0; i < size; i++) {
					int num = q.poll();
					
					for (int j = 0; j < MAX; j++) {
						if(!check[j] && rel[num][j]) {
							check[j] = true;
							q.offer(j);
							max = max > j ? max : j;
						}
					}
				}
				
				if(q.isEmpty()) {
					break;
				}
				result = max;
			}
			
			sb.append("#").append(test_case).append(" ").append(result).append("\n");
		}
		System.out.print(sb);
		
		br.close();
	}

}
