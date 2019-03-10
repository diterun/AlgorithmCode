package com.baek;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14889_end {
	static int n, result, tCnt;
	static int[] team1, team2;
	static int[][] pair;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/baek14889.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		tCnt = n / 2;
		result = 100000;
		
		pair = new int[n][n];
		team1 = new int[tCnt];
		team2 = new int[tCnt];
		
		boolean[] check = new boolean[n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				pair[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		johab(0, 0, check);
		
		System.out.println(result);

		br.close();
	}

	private static void johab(int cnt, int start, boolean[] check) {
		if(cnt == tCnt) {
			int j = 0, k = 0;
			int team1Power = 0;
			int team2Power = 0;
			int diff;
			
			for (int i = 0; i < n; i++) {
				if(check[i]) {
					team1[j++] = i;
				} else {
					team2[k++] = i;
				}
			}
			
			for (int i = 0; i < tCnt; i++) {
				for (int l = 0; l < tCnt; l++) {
					if(i != l) {
						team1Power += pair[team1[i]][team1[l]]; 
						team2Power += pair[team2[i]][team2[l]]; 
					}
				}
			}
			
			if(team1Power > team2Power) {
				diff = team1Power - team2Power;
			} else {
				diff = team2Power - team1Power;
			}
			
			result = result < diff ? result : diff;
			
			return;
		}
		
		for (int i = start; i < n; i++) {
			check[i] = true;
			johab(cnt + 1, i + 1, check);
			check[i] = false;
		}
	}

}
