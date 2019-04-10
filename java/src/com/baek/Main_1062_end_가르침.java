package com.baek;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1062_end_가르침 {
	static int n, k, result;
	static int[] dan;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		result = 0;
		
		System.setIn(new FileInputStream("res/baek/1062.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine().trim());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken()) - 5;
		dan = new int[n];
		
		if(k < 0) {
			System.out.println(0);
			return;
		}
		for (int i = 0; i < n; i++) {
			char[] temp = br.readLine().toCharArray();
			int size = temp.length;
			
			if(size == 8) {
				
			} else {
				for (int j = 4; j < size - 4; j++) {
					dan[i] |= (1 << (temp[j] - 'a'));
				}
			}

			dan[i] |= (1 << ('a' - 'a'));
			dan[i] |= (1 << ('n' - 'a'));
			dan[i] |= (1 << ('t' - 'a'));
			dan[i] |= (1 << ('i' - 'a'));
			dan[i] |= (1 << ('c' - 'a'));
		}
		
		int a = (1 << ('a' - 'a')) | (1 << ('n' - 'a')) | (1 << ('t' - 'a')) | (1 << ('i' - 'a')) | (1 << ('c' - 'a'));
		johab(a, 0, 0);
		
		System.out.println(result);
		
		br.close();
	}

	private static void johab(int flag, int start, int cnt) {
		if(cnt == k) {
			int sub = 0;
			
			for (int i = 0; i < n; i++) {
				if(flag == (flag | dan[i])) {
					sub++;
				}
			}
			
			result = result > sub ? result : sub;
			return;
		}
		
		for (int i = start; i < 26; i++) {
			if((flag & (1 << i)) == 0) {
				johab(flag | (1 << i), i, cnt + 1);
			}
		}
	}

}
