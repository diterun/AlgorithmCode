package com.baek;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_396_1 {
	static int n, result;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/baek/396.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		result = 0;
		
		n = Integer.parseInt(br.readLine());
		int[][] egg = new int[n][2];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			egg[i][0] = Integer.parseInt(st.nextToken());
			egg[i][1] = Integer.parseInt(st.nextToken());
		}
		
		crash(0, egg);
		
		System.out.println(result);
		
		br.close();
	}

	private static void crash(int index, int[][] egg) {
		if(index == n) {
			int subResult = 0;
			
			for (int i = 0; i < n; i++) {
				if(egg[i][0] <= 0) {
					subResult++;
				}
			}
			result = result > subResult ? result : subResult;
			return;
		}
		
		if(egg[index][0] > 0) {
			for (int i = 0; i < n; i++) {
				if(index != i) {
					if(egg[i][0] > 0) {
						egg[index][0] -= egg[i][1];
						egg[i][0] -= egg[index][1];
						
						crash(index + 1, egg);
						
						egg[index][0] += egg[i][1];
						egg[i][0] += egg[index][1];
					} else {
						crash(index + 1, egg);
					}
				}
			}
		} else {
			crash(index + 1, egg);
		}
	}
}
