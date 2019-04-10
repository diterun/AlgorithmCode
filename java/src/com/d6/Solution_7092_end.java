package com.d6;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_7092_end {
	private static int T, test_case;
	private static int n, one, twoM;
	private static int[] fails = new int[3], two = new int[3];
	private static char[] m, j, g;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/d6/7092.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine().trim());

		for (test_case = 1; test_case <= T; test_case++) {
			/**입력*/
			n = Integer.parseInt(br.readLine().trim());
			m = br.readLine().toCharArray();
			j = br.readLine().toCharArray();
			g = br.readLine().toCharArray();
			/**
			 * 초기화
			 * 처음에는 모두 문제를 틀렸다고 초기화한다.
			 */
			for (int i = 0; i < 3; i++) {
				fails[i] = n;	//모두 틀림
				two[i] = 0;
			}
			one = 0;

			/**
			 * 명우, 정우, 근우의 답에 따라서 달라진다.
			 * 셋 모두 똑같은 정답을 내면, 모두 맞았다고 한다.
			 * 3명 중 2명만이 같은 답을 내면, 종류에 따라 따로 저장한다.
			 * two[0] => 0 or 1, 2 가 정답.
			 * two[1] => 1 or 0, 2 가 정답.
			 * two[2] => 2 or 0, 1 이 정답.
			 * 3명 중 모두가 다른 답을 내면 one에 저장한다.
			 */
			for (int i = 0; i < n; i++) {
				int a = m[i];
				int b = j[i];
				int c = g[i];

				if (a == b && a == c) {
					fails[0]--;
					fails[1]--;
					fails[2]--;
				} else if (a == b && !(a == c)) {
					two[2]++;
				} else if (!(a == b) && a == c) {
					two[1]++;
				} else if (!(a == b) && b == c) {
					two[0]++;
				} else {
					one++;
				}
			}

			/**
			 * 2명이 맞는 경우 1, 2, 3이 모두 있는 경우
			 * AAAABB
			 * AABBAA
			 * BBAAAA
			 * 일 때는 모든 정답을 A로 했을 때, 모두 4개씩 맞게 된다.
			 */
			twoM = two[0] < two[1] ? two[0] : two[1];
			twoM = twoM < two[2] ? twoM : two[2];

			/**2명이 정답인 경우 중 제일 적은 경우에 대하여 그 경우의 *2 만큼 맞게 해준다.*/
			for (int i = 0; i < 3; i++) {
				fails[i] -= twoM * 2;
				two[i] -= twoM;
			}

			/**
			 * 2명이 맞는 경우 1, 2, 3이 모두 있는 경우
			 * AABB
			 * AAAA
			 * BBAA
			 * 일 때는 모든 정답을 A로 했을 때, 각각 2, 4, 2 문제 맞게 된다..
			 */
			twoM = 0;
			for (int i = 0; i < 3; i++) {
				if (two[i] == 0) {
					/** 0인 애를 제외한 나머지가 0이 아니어야 한다. */
					int nam1 = (i + 1) % 3;
					int nam2 = (i + 2) % 3;
					if (two[nam1] != 0 && two[nam2] != 0) {
						twoM = two[nam1] < two[nam2] ? two[nam1] : two[nam2];
						
						/**
						 * two의 경우는 아래와 같다. 때문에 two[0]가 0일 때는 two[2]와 two[1]에 있는 대로
						 * fails[0]는 2개, fails[1]과 fails[2]는 1개 줄어든다.
						 * 			two[2]	two[1]	two[0]
						 * fails[0]		A		A		B
						 * fails[1]		A		B		A
						 * fails[2]		B		A		A
						 */
						fails[i] -= twoM * 2;
						fails[nam1] -= twoM;
						fails[nam2] -= twoM;
						two[nam1] -= twoM;
						two[nam2] -= twoM;
					}
				}
			}
			
			/** 2명이 맞는 경우 중에 1가지만 있는 경우 */
			twoM = 0;
			for (int i = 0; i < 3; i++) {
				if (two[i] > 0) {
					/**
					 * 모두 다른 경우인 one보다 적을 경우에는
					 * one과 함께 세어서 3명이 맞는 경우로 만든다.
					 * AA
					 * AB
					 * BC
					 * 일때에 정답은 A, C를 주어서 모두 1개씩 맞게 한다.
					 */
					if(two[i] < one) {
						one -= two[i];
						for (int j = 0; j < 3; j++) {
							fails[j] -= two[i];
						}
					} else {
						/**
						 * 모두 다른 경우보다 많다면,
						 * one만큼을 줄인다.
						 */
						twoM = one;
						two[i] -= one;
						one = 0;
						
						/**
						 * 이후 남은 것을 반으로 잘라서 2명이 맞게 하거나 1명만 맞게하는 경우로 쪼갠다.
						 * AA
						 * AA
						 * BB
						 * 일때, 정답은 A, B로 함으로써 모두 1개씩만 맞게한다.
						 */
						twoM += two[i] / 2;
						two[i] %= 2;
						
						/**모든 fails에 지금까지 계산 된 twoM을 뺀다.*/
						for (int j = 0; j < 3; j++) {
							fails[j] -= twoM;
						}
						/**혹시 2명이 똑같은 정답인 경우가 1개 남으면, 그 2명을 맞게 해준다.*/
						fails[(i + 1) % 3] -= two[i];
						fails[(i + 2) % 3] -= two[i];
					}
				}
			}

			/**모두 정답이 다른 경우*/
			for (int i = 0; i < one; i++) {
				int max = 0;
				int maxi = 0;
				for (int j = 0; j < 3; j++) {
					if(max < fails[j]) {
						max = fails[j];
						maxi = j;
					}
				}
				fails[maxi]--;
			}

			/**최종적으로 제일 많이 틀린 학생을 구한다.*/
			int max = 0;
			int maxi = 0;
			for (int j = 0; j < 3; j++) {
				if(max < fails[j]) {
					max = fails[j];
					maxi = j;
				}
			}
			System.out.println("#" + test_case + " " + (n - fails[maxi]));
		}

		br.close();
	}

}
