package com.jungol;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2283_end_RGB마을 {
	static int n, result, r1, g1, b1, r2, g2, b2, in1, in2, in3;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("jungol/2283.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		result = 0;
		r1 = g1 = b1 = Integer.MAX_VALUE;

		n = Integer.parseInt(br.readLine().trim());
		st = new StringTokenizer(br.readLine());
		
		r1 = Integer.parseInt(st.nextToken());
		g1 = Integer.parseInt(st.nextToken());
		b1 = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			in1 = Integer.parseInt(st.nextToken());
			in2 = Integer.parseInt(st.nextToken());
			in3 = Integer.parseInt(st.nextToken());

			r2 = Math.min(in1 + g1, in1 + b1);
			g2 = Math.min(in2 + r1, in2 + b1);
			b2 = Math.min(in3 + r1, in3 + g1);

			r1 = r2;
			g1 = g2;
			b1 = b2;
		}
		
		result = Math.min(r1, g1);
		result = Math.min(b1, result);

		System.out.println(result);

		br.close();
	}
}
