package com.none;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2115 {
	static int MAX = 15;
	static int T, test_case, result, n, m, c;
	static int[] gain, seleted;
	static int[][] maxs;
	static int[][] tong;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/2115.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine().trim());

		for (test_case = 1; test_case <= T; test_case++) {
			result = 0;

			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			tong = new int[n][n];
			gain = new int[m];
			seleted = new int[2];
			maxs = new int[MAX][3];
			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					tong[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			getMaxS();
			
//			System.out.print(test_case +" : ");
//			for (int i = 0; i < MAX; i++) {
//				System.out.print(maxs[i][2] + " ");
//			}
//			System.out.println();
			
			johab(0, 0);
			
			sb.append("#").append(test_case).append(" ").append(result).append("\n");
		}
		
		System.out.print(sb);

		br.close();
	}

	private static void johab(int start, int cnt) {
		if(cnt == 2) {
			int y1 = maxs[seleted[0]][0];
			int x1 = maxs[seleted[0]][1];
			int sum1 = maxs[seleted[0]][2];
			
			int y2 = maxs[seleted[1]][0];
			int x2 = maxs[seleted[1]][1];
			int sum2 = sum1 + maxs[seleted[1]][2];
			
			
			if(y1 == y2) {
				if(x1 > x2) {
					if(x2 + m <= x1) {
						result = result > sum2 ? result : sum2;
					}
				} else {
					if(x1 + m <= x2) {
						result = result > sum2 ? result : sum2;
					}
				}
			} else {
				result = result > sum2 ? result : sum2;
			}
			return;
		}
		
		for (int i = start; i < MAX; i++) {
			seleted[cnt] = i;
			johab(i + 1, cnt + 1);
		}
	}

	private static void getMaxS() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= n - m; j++) {
				for (int k = 0; k < m; k++) {
					gain[k] = tong[i][j + k];
				}
				int sum = 0;
				int result = 0;
				
				for (int i2 = 0, size = 1 << m; i2 < size; i2++) {
					sum = 0;
					int subSum = 0;
//					System.out.print(i2 +"," +": ");
					for (int j2 = 0; j2 <m; j2++) {
						if((i2 & 1<<j2)!=0) {
							sum += gain[j2];
							subSum += (gain[j2] * gain[j2]);
//							System.out.print(gain[j2] + " ");
						}
					}
					if(sum != 0 && sum <= c) {
						result = result > subSum ? result : subSum;
					}
				}
				for (int k = 0; k < MAX; k++) {
					if(maxs[k][2] < result) {
						for (int k2 = MAX - 2; k2 >= k; k2--) {
							maxs[k2 + 1][0] = maxs[k2][0];
							maxs[k2 + 1][1] = maxs[k2][1];
							maxs[k2 + 1][2] = maxs[k2][2];
						}
						
						maxs[k][0] = i;
						maxs[k][1] = j;
						maxs[k][2] = result;

//						System.out.print(test_case +" : ");
//						for (int ii = 0; ii < MAX; ii++) {
//							System.out.print("(" + maxs[ii][0] + ", " + maxs[ii][1] + ", "+ maxs[ii][2] + ") ");
//						}
//						System.out.println();
						
						break;
					}
				}
			}
		}
	}

}
