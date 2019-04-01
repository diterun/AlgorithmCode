package com.d7;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;
/**
 * 접근 자체를 잘못해버렸더.....
 * 
 * 나와 옆에 놈을 합치는 것으로 해서...
 * 그 값이 작은 애들부터 해야하면서도...
 * 2^n승에 해당하는 정도까지만... 그니까 토너먼트 마냥... 그런식으로... 아...
 * @author student
 *
 */

public class Solution_3146_소설가의파일합치기 {
	static int T, test_case, n;
	static long result;
	static LinkedList<Integer> q = new LinkedList<>();
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/3146.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());

		for(test_case = 1; test_case <= T; ++test_case)
		{
			result = 0;
			
			n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				q.offer(Integer.parseInt(st.nextToken()));
			}
			
			Collections.sort(q);
			while(!q.isEmpty()) {
				int size = q.size() / 2;
				
				int a = q.poll();
				int b = q.poll();
				result += a + b;
				q.offer(a + b);
				int min = a;
//				System.out.print(min + " : ");
//				System.out.print(a + "+");
//				System.out.print(b + "=");
//				System.out.println(a + b);
				
				
				for (int i = 1; i < size; i++) {
					a = q.poll();
					b = q.poll();
					
					if(b < min * 2) {
//						System.out.print(a + "+");
//						System.out.print(b + "=");
//						System.out.println(a + b);
						result += a + b;
						q.offer(a + b);
					} else {
						q.offer(a);
						q.offer(b);
						break;
					}
				}
//				System.out.println(" = " + result);
				Collections.sort(q);
				if(size == 1) {
					if(q.size() == 2) {
						a = q.poll();
						b = q.poll();
						
						result += a + b;
					}
					break;
				}
			}
			q.clear();
	        
	        System.out.println("#" + test_case + " " + result);
		}
		
		br.close();
	}

}