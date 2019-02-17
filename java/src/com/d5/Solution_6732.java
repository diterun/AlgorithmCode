package com.d5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Solution_6732 {
	static int T, test_case;
	static String[] inS;
	/**
	 * ss	: 간선의 출발지
	 * es	: 간선의 도착지
	 */
	static int n, m, z, result, ss, es;
	/**i번째 역을 지났는지 체크*/
	static boolean[] check;
	/**i에서 j로 갈 수 있는 간선의 여부*/
	static boolean[][] mapping;
	/**i에서 j로 갈 수 있을 때, 그 거리*/
	static int[][] count;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/6732.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine().trim());

		for (test_case = 1; test_case <= T; test_case++) {
			result = 0;

			inS = br.readLine().split(" ");
			n = Integer.parseInt(inS[0]);
			m = Integer.parseInt(inS[1]);
			z = Integer.parseInt(inS[2]);

			check = new boolean[n + 1];
			mapping = new boolean[n + 1][n + 1];
			count = new int[n + 1][n + 1];
			
			for (int i = 0; i < m; i++) {
				inS = br.readLine().split(" ");
				
				ss = Integer.parseInt(inS[0]);
				es = Integer.parseInt(inS[1]);

				mapping[ss][es] = true;
				mapping[es][ss] = true;
			}
			
			/**일단 loop가 가능한지 여부와, loop의 개수와 loop의 길이를 구해야한다.*/
			
			/**각 loop들을 순회하면서 그 loop를 중심으로 모든 애들을 검사한다.*/

			/**loop에 포함되는 애는, loop내의 다른 곳으로 가는 길이 a(시계), b(반시계)의 합은 loop길이와 같다.*/
			/**loop에 포함되지 않는 애는, loop로 도달하는 길이를 각각 더해주면 된다.*/
			
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
//					System.out.println("=========" + i + ", " + j + "===========");
					letsGoStation(i, j, i, 0);
				}
			}
			
//			for (int i = 1; i <= n; i++) {
//				for (int j = 1; j <= n; j++) {
//					System.out.print(mapping[i][j] +" ");
//				}
//				System.out.println();
//			}
			
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					System.out.print(count[i][j] +" ");
				}
				System.out.println();
			}
			
			System.out.println("#" + test_case + " " + result);
		}

		br.close();
	}

	/**이건 단순히 start에서 end로 가능게 몇번 걸리는지!! 순회도 없고... ㅠㅠ*/
	private static void letsGoStation(int start, int end, int now, int cnt) {
		check[start] = true;
		
		for (int i = 1; i <= n; i++) {
			if(mapping[now][i] && !check[i]) {
//				System.out.println(now + "->" + i);
				check[i] = true;
				letsGoStation(start, end, i, cnt + 1);
				check[i] = false;
			}
		}
		
		if(now == end && count[start][end] == 0) {
//			System.out.println(start + " hi " + end);
			count[start][end] = cnt;
			check[start] = false;
			return;
		}
	}
}