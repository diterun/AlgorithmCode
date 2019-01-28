package com.baek;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main_1725 {
	static int MAX = 100001;
	static int N, result, index, subResult, subIndex, height;
	static int[] numbers = new int[MAX];

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/1725.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(br.readLine());
			
			if(height > numbers[i]) {
				
			}
		}
		
		System.out.println(result);
		
		br.close();
	}
}
