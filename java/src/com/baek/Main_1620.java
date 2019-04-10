package com.baek;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1620 {
	static int n, m, a;
	static String input;
	static String[] poke;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/baek/1620.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine().trim());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		poke = new String[n + 1];
		
		for (int i = 1; i <= n; i++) {
			poke[i] = br.readLine();
		}
		
		for (int i = 0; i < m; i++) {
			input = br.readLine();
			a = input.charAt(0) - '0';
			
			if(0 <= a && a <= 9) {
				sb.append(poke[Integer.parseInt(input)]).append("\n");
			} else {
				for (int j = 1; j <= n; j++) {
					if(poke[j].equals(input)) {
						sb.append(j).append("\n");
						break;
					}
				}
			}
		}
		
		System.out.print(sb);
		
		br.close();
	}

}
