package com.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_4366_end_정식이의은행업무 {
	static int T, t, size;
	static long result;
	static long[] binary;
	static char[] line;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/d4/4366.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine().trim());

		for (t = 1; t <= T; t++) {
			line = br.readLine().toCharArray();
			size = line.length;
			binary = new long[size];
			
			/**Make binary numbers at that can*/
			for (int i = 0; i < size; i++) {
				int temp = 1;
				int num = 0;
				
				for (int j = size - 1; j >= 0; j--) {
					num = line[j] - '0';
					/**If same j at i, change the bit*/
					if(i == j) {
						num = (num + 1) % 2;
					}
					binary[i] += num * temp;
					temp *= 2;
				}
			}
			
			line = br.readLine().toCharArray();
			size = line.length;
			for (int i = 0; i < size; i++) {
				int temp = 1;
				int num1 = 0;
				int num2 = 0;
				long sub1 = 0;
				long sub2 = 0;
				
				for (int j = size - 1; j >= 0; j--) {
					num1 = num2 = line[j] - '0';
					if(i == j) {
						num1 = (num1 + 1) % 3;
						num2 = (num2 + 2) % 3;
					}
					sub1 += num1 * temp;
					sub2 += num2 * temp;
					temp *= 3;
				}
				
				for (int j = 0; j < binary.length; j++) {
					if(sub1 == binary[j] || sub2 == binary[j]) {
						result = binary[j];
						i = size;
						break;
					}
				}
			}
			
			System.out.println("#" + t + " " + result);
		}

		br.close();
	}
}
