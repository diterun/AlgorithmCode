package com.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_1225_end {
	static int T, test_case;
	static int n, zero, cycle, point;
	static String[] line;
	static int[] num = new int[8];
	static long start, end;
	
	public static void main(String[] args) throws Exception {
		start = System.nanoTime();
		System.setIn(new FileInputStream("res/1225.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
//		T = 10;
		
		for(test_case = 1; test_case <= 10; test_case++) {
			n = Integer.parseInt(br.readLine().trim());
			line = br.readLine().split(" ");
			cycle = 1;
			point = 0;
			
			for (int i = 0; i < 8; i++) {
				num[i] = Integer.parseInt(line[i]);
			}
			
			do {
				zero = num[point];
				zero -= cycle;
				num[point] = zero > 0 ? zero : 0;
				cycle = cycle % 5 + 1;
				point = (point + 1) % 8;
			} while(zero > 0);
			
			System.out.print("#" + test_case + " ");
			for (int i = point; i < 8; i++) {
				System.out.print(num[i] + " ");
			}
			for (int i = 0; i < point; i++) {
				System.out.print(num[i] + " ");
			}
			System.out.println();
		}
		
		br.close();
		end = System.nanoTime();
		System.out.println("time :" + (end - start));
	}
}
