package com.d6;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
/**
 * 이건ㅇ나ㅣㄴ이노디놔 안돼!!!!!!!!!!!
 * 디피로 풀어야 해!!!!!!!!!!
 * 경우의 수 쭉~ 들어간 다음에~ 하고 뒤로 와서 하고~~~ 그래야 해~~~~~~~~~~
 * 
 * @author student
 *
 */
public class Solution_7092 {
	static int T, test_case;
	static int n, result, sub;
	static char[] m, j, g;
	static String[] inS;
	static int[][][] results = new int[3][4][30002];

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/7092.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine().trim());
		
		for (int j = 0; j < 3; j++) {
			for (int k = 0; k < 4; k++) {
				results[j][k][0] = 0;
			}
		}
		
		for (test_case = 1; test_case <= T; test_case++) {
			result = 30000;
			
			n = Integer.parseInt(br.readLine().trim());
			m = br.readLine().toCharArray();
			j = br.readLine().toCharArray();
			g = br.readLine().toCharArray();
			
			for (int i = 1; i <= n; i++) {
				for (int j = 0; j < 3; j++) {
					for (int k = 0; k < 4; k++) {
						results[j][k][i] = results[j][k][i - 1];
					}
				}
				
				results[0][m[i - 1] - 'A'][i]++;
				results[1][j[i - 1] - 'A'][i]++;
				results[2][g[i - 1] - 'A'][i]++;
			}
			
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 4; k++) {
					sub = n - results[j][k][n];
					
					result = result < sub ? result : sub;
				}
			}
			

			System.out.println("#"+test_case+" "+ result);
		}

		br.close();
	}

}
