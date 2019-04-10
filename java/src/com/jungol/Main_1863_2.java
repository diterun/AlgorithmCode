package com.jungol;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_1863_2 {
	static int n, m, a, b, result;
	static HashMap<Integer, Integer> map = new HashMap<>();
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/jungol/1863.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		result = 0;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		if(m == 0) {
			System.out.println(n);
		} else {
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				
				if(map.containsKey(a)) {
					map.put(b, map.get(a));
				} else {
					if(map.containsKey(b)) {
						map.put(a, map.get(b));
					} else {
						map.put(a, result);
						map.put(b, result);
						result++;
					}
				}
			}
			System.out.println(result);
		}


		br.close();
	}
}
