package com.d2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_1859 {
	static int T, test_case;
	static int n, result;
	static int[] price;
	static Stack<Integer> max = new Stack<Integer>();
	static Stack<Integer> maxi = new Stack<Integer>();
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/d2/1859.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine().trim());
		
		for(test_case = 1; test_case <= T; test_case++) {
			result = 0;
			
			n = Integer.parseInt(br.readLine().trim());
			price = new int[n];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				price[i] = Integer.parseInt(st.nextToken());
				
				while(!max.isEmpty()) {
					if(max.peek() <= price[i]) {
						max.pop();
						maxi.pop();
					} else {
						max.push(price[i]);
						maxi.push(i);
						break;
					}
				}
			}
			
			System.out.println("#" + test_case + " " + result);
		}
		
		br.close();
	}
}
