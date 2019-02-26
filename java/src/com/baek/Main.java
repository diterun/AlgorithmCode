package com.baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static double a, b;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());

		a = Double.parseDouble(st.nextToken());
		b = Double.parseDouble(st.nextToken());
		
		System.out.println(a/b);
		
		br.close();
	}
}
