package com.jungol;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2634_end {
	static int n, m, l, result, x, y, left, right, min, mid, max;
	static int[] shooter;
	static boolean[] check;
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/jungol/2634.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		result = 0;

		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());

		shooter = new int[m];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			shooter[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(shooter);
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			if(y > l) {
				continue;
			}

			left = x - (l - y);
			right = x + (l - y);
			
			min = 0;
			max = m - 1;
			
			while(min <= max) {
				mid = (max + min) / 2;
				
				if(left <= shooter[mid] && shooter[mid] <= right) {
					result++;
					break;
				}
				
				if(left > shooter[mid]) {
					min = mid + 1;
				} else if(shooter[mid] > right) {
					max = mid - 1;
				}
			}
		}

		System.out.println(result);

		br.close();
	}
}
