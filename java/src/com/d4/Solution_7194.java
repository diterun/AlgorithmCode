package com.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_7194 {
	static int T, test_case;
	static long start, end, a, b, result, sub, cnt;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder(2000);

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/7194.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine().trim());

		for (test_case = 1; test_case <= T; test_case++) {
			result = 0;
			
			st = new StringTokenizer(br.readLine());
			
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			while(true) {
				if(end % b == 0 && end / b >= start) {
					end /= b;
					result++;
				} else {
					sub = end % b;
					if(sub == 0) {
						end -= a;
						result++;
					} else {
						cnt = sub / a;
						if(sub % a == 0) {
							result += cnt;
							end -= sub;
						} else {
							result += (cnt + 1);
							end -= ((cnt + 1) * a);
						}
					}
				}
				
				System.out.println(start + " ~ " + end + " | " + result);
				
				if(end == start) {
					break;
				} else if(end < start){
					result = -1;
					break;
				}
			}
			
			sb.append("#").append(test_case).append(" ").append(result).append("\n");
		}
		System.out.println(sb);

		br.close();
	}
}
