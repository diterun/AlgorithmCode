package com.jungol;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main_1828 {
	static int n, endOfTem, result;
	static int[][] ref;
	static String[] inputS;
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/jung1828.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		ref = new int[n][2];
		for (int i = 0; i < n; i++) {
			inputS = br.readLine().split(" ");
			ref[i][0] = Integer.parseInt(inputS[0]);
			ref[i][1] = Integer.parseInt(inputS[1]);
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - 1; j++) {
				if (ref[j][1] > ref[j + 1][1]) {
					int temp = ref[j][0];
					ref[j][0] = ref[j + 1][0];
					ref[j + 1][0] = temp;
					
					temp = ref[j][1];
					ref[j][1] = ref[j + 1][1];
					ref[j + 1][1] = temp;
				}
			}
		}
//		for (int i = 0; i < n; i++) {
//			System.out.println(ref[i][0] + "~" + ref[i][1]);
//		}

		endOfTem = -272;
		for (int i = 0; i < n; i++) {
			if(ref[i][0] > endOfTem) {
				System.out.println(ref[i][1] + 270);
				endOfTem = ref[i][1];
				result++;
			}
		}
		
		System.out.println(result);
		
		br.close();
	}
}
