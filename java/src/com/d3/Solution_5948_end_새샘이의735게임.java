package com.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5948_end_새샘이의735게임 {
	static int T, t;
	static int[] result, num = new int[7];
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/5948.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine().trim());

		for (t = 1; t <= T; t++) {
			result = new int[5];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 7; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			
			johab(0, 0, 0);
			
			sb.append("#").append(t).append(" ").append(result[4]).append("\n");
		}

		System.out.print(sb);

		br.close();
	}

	private static void johab(int start, int cnt, int sum) {
		if(cnt == 3) {
			if(result[0] < sum) {
				result[4] = result[3];
				result[3] = result[2];
				result[2] = result[1];
				result[1] = result[0];
				result[0] = sum;
			} else if(result[0] == sum) {}
			else if(result[1] < sum) {
				result[4] = result[3];
				result[3] = result[2];
				result[2] = result[1];
				result[1] = sum;
			} else if(result[1] == sum) {}
			else if(result[2] < sum) {
				result[4] = result[3];
				result[3] = result[2];
				result[2] = sum;
			} else if(result[2] == sum) {}
			else if(result[3] < sum) {
				result[4] = result[3];
				result[3] = sum;
			} else if(result[3] == sum) {}
			else if(result[4] < sum) {
				result[4] = sum;
			} 
			return;
		}
		
		for (int i = start; i < 7; i++) {
			johab(i + 1, cnt + 1, sum + num[i]);
		}
	}
}
