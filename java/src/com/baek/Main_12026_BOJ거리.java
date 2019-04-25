package com.baek;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main_12026_BOJ거리 {
	static int n;
	static int[] energy;
	static char[] street;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/baek/12026.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		street = br.readLine().toCharArray();
		
		energy = new int[n];
		for (int i = 0; i < n; i++) {
			energy[i] = -1;
		}
		
		energy[0] = 0;
		for (int i = 0; i < n; i++) {
			if(energy[i] == -1) {
				continue;
			}
			for (int j = i + 1; j < n; j++) {
				int diff = street[i] - street[j];
				if(diff == -13 || diff == 5 || diff == 8) {
					if(energy[j] == -1) {
						energy[j] = energy[i] + ((j - i) * (j - i));
					} else {
						int temp = energy[i] + ((j - i) * (j - i));
						energy[j] = temp < energy[j] ? temp : energy[j];
					}
				}
			}
		}
		
		System.out.println(energy[n - 1]);

		br.close();
	}
}
