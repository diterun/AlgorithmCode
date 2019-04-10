package com.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3378_end_스타일리쉬들여쓰기 {
	static int MAX = 100;
	static int T, t, p, q, r, c, s;
	static char[] line;
	static int[][] me2;
	static int[][] master;
	static int[] result;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/d4/3378.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine().trim());

		for (t = 1; t <= T; t++) {
			r = c = s = 0;
			sb.append("#").append(t).append(" ");
			
			st = new StringTokenizer(br.readLine());
			p = Integer.parseInt(st.nextToken());
			q = Integer.parseInt(st.nextToken());
			/**
			 * 0~3 : r, c, s, 점의 개수
			 */
			master = new int[p][4];
			me2 = new int[q][3];
			result = new int[q];
			
			for (int i = 0; i < p; i++) {
				line = br.readLine().toCharArray();
				int dot = 0;
				boolean start = false;
				
				for (int j = 0, size = line.length; j < size; j++) {
					if(!start && line[j] == '.') {
						dot++;
						continue;
					} else if(!start) {
						start = true;
						
						master[i][0] = r;
						master[i][1] = c;
						master[i][2] = s;
						master[i][3] = dot;
					}
					
					switch(line[j]) {
					case '(': r++; break;
					case '{': c++; break;
					case '[': s++; break;
					case ')': r--; break;
					case '}': c--; break;
					case ']': s--; break;
					}
				}
			}
			r = c = s = 0;
			for (int i = 0; i < q; i++) {
				line = br.readLine().toCharArray();
				
				me2[i][0] = r;
				me2[i][1] = c;
				me2[i][2] = s;
				
				for (int j = 0, size = line.length; j < size; j++) {
					switch(line[j]) {
					case '(': r++; break;
					case '{': c++; break;
					case '[': s++; break;
					case ')': r--; break;
					case '}': c--; break;
					case ']': s--; break;
					}
				}
			}
			
			for (int i = 1; i <= 20; i++) {
				for (int j = 1; j <= 20; j++) {
					for (int k = 1; k <= 20; k++) {
						if(masterOK(i, j, k)) {
							getResult(i, j, k);
						}
					}
				}
			}
			for (int i = 0; i < q; i++) {
				sb.append(result[i] + " ");
			}
			
			sb.append("\n");
		}
		
		System.out.print(sb);

		br.close();
	}

	private static void getResult(int r, int c, int s) {
		for (int i = 0; i < q; i++) {
			int sum = me2[i][0] * r + me2[i][1] * c + me2[i][2] * s;
			
			if(result[i] == 0) {
				result[i] = sum;
			} else {
				if(result[i] != sum) {
					result[i] = -1;
				}
			}
		}
	}

	private static boolean masterOK(int r, int c, int s) {
		for (int i = 0; i < p; i++) {
			if(master[i][0] * r + master[i][1] * c + master[i][2] * s != master[i][3]) {
				return false;
			}
		}
		return true;
	}
}
