package com.d5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_1857_end {
	static int T, test_case;
	/**
	 * map의 최대 사이즈
	 */
	static int MAX = 2002;
	/**
	 * 도미노로 가려지는 숫자들의 max값들의 최대 개수
	 */
	static int MaxSCnt = 35;
	/**
	 * N * N 행렬의 맵과 K개의 도미노
	 */
	static int N, K;
	static String[] line;
	/**
	 * 맵
	 */
	static int[][] map = new int[MAX][MAX];
	/**
	 * 내림정렬 된 max 값들
	 */
	static MaxS[] ms = new MaxS[MaxSCnt];
	/**
	 * max값들 중에서 조합으로 선택 되는 5개의 수
	 */
	static int[] sel = new int[5];
	/**
	 * 결과, 가리기 전에 맵에 있는 전체 값
	 */
	static long result, FULL;

	public static class MaxS {
		int i1, j1;
		int i2, j2;
		int sum;
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/d5/1857.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < MaxSCnt; i++) {
			ms[i] = new MaxS();
		}

		T = Integer.parseInt(br.readLine().trim());

		for (test_case = 1; test_case <= T; test_case++) {
			/*
			 * 초기화
			 */
			FULL = 0L;
			result = 0L;
			for (int i = 0; i < MAX; i++) {
				for (int j = 0; j < MAX; j++) {
					map[i][j] = 0;
				}
			}
			for (int i = 0; i < MaxSCnt; i++) {
				ms[i].i1 = 0;
				ms[i].j1 = 0;
				ms[i].i2 = 0;
				ms[i].j2 = 0;
				ms[i].sum = 0;
			}
			sel[0] = 0;
			sel[1] = 0;
			sel[2] = 0;
			sel[3] = 0;
			sel[4] = 0;

			/*
			 * 모든 입력을 받는다.
			 */
			line = br.readLine().split(" ");
			N = Integer.parseInt(line[0]);
			K = Integer.parseInt(line[1]);

			for (int i = 1; i <= N; i++) {
				line = br.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					map[i][j + 1] = Integer.parseInt(line[j]);
				}
			}

			/*
			 * 최초에 받은 값을 모두 더한다.
			 */
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					FULL += map[i][j];
				}
			}

			/*
			 * 도미노 하나로 가려지는 값이 가장 큰 값부터 30번째로 큰 값까지 저장한다.
			 */
			getMax();

			/*
			 * 도미노가 1개면 가장 큰 값을 뺀다.
			 */
			if (K == 1) {
				result = FULL - ms[0].sum;
			} else { // 도미노가 여러개면 도미노 개수만큼 조합을 돌려서 제일 큰 값을 빼준다.
				int re = johap(0, 0, 0);
				result = FULL - re;
			}

			System.out.println("#" + test_case + " " + result);
		}
		br.close();
	}

	/*
	 * 도미노의 개수만큼 조합을 돌린다.
	 */
	private static int johap(int sum, int count, int start) {
		int subSum = 0;

		if (count == K) {
			/*
			 * 만약에 count개의 max값 들 중에 곂치는 좌표가 있다면 제외 시킨다.
			 */
			for (int i = 0; i < K - 1; i++) {
				for (int j = i + 1; j < K; j++) {
					if (ms[sel[i]].i1 == ms[sel[j]].i1 && ms[sel[i]].j1 == ms[sel[j]].j1
							|| ms[sel[i]].i1 == ms[sel[j]].i2 && ms[sel[i]].j1 == ms[sel[j]].j2
							|| ms[sel[i]].i2 == ms[sel[j]].i1 && ms[sel[i]].j2 == ms[sel[j]].j1
							|| ms[sel[i]].i2 == ms[sel[j]].i2 && ms[sel[i]].j2 == ms[sel[j]].j2) {
						return 0;
					}
				}
			}
			/*
			 * 곂치는 좌표가 없는 count개의 max값을 더한 것들 중에서 가장 큰 값을 찾는다.
			 */
			for (int i = 0; i < K; i++) {
				subSum += ms[sel[i]].sum;
			}
			sum = sum > subSum ? sum : subSum;
			return sum;
		}
		
		/*
		 * 조합
		 */
		for (int i = start; i < MaxSCnt; i++) {
			sel[count] = i;
			subSum = johap(0, count + 1, i + 1);
			sum = sum > subSum ? sum : subSum;
		}
		return sum;
	}

	/**
	 *   0 1 2
	 * 0  ㅇㅇㅇ
	 * 1  ㅇㅇㅇ
	 * 2  ㅇㅇㅇ
	 * 맵에서 0, 0을 가리는 도미노는
	 *   0 1 2        0 1 2
	 * 0 x x o      0 x o o
	 * 1 o o o  혹은  1 x o o
	 * 2 o o o      2 o o o
	 * 위와 같이 가린다.
	 * 이런식으로 모든 N*N을 돌면서 MAX값들을 30개 찾는다.
	 */
	public static void getMax() {
		int twoSum1, twoSum2;

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				twoSum1 = map[i][j] + map[i][j + 1];
				twoSum2 = map[i][j] + map[i + 1][j];

				int k;
				for (k = 0; k < MaxSCnt; k++) {
					if (twoSum1 > ms[k].sum) {
						break;
					}
				}
				if (k != MaxSCnt) {
					for (int k2 = MaxSCnt - 1; k2 > k; k2--) {
						ms[k2].i1 = ms[k2 - 1].i1;
						ms[k2].j1 = ms[k2 - 1].j1;
						ms[k2].i2 = ms[k2 - 1].i2;
						ms[k2].j2 = ms[k2 - 1].j2;
						ms[k2].sum = ms[k2 - 1].sum;
					}
					ms[k].sum = twoSum1;
					ms[k].i1 = i;
					ms[k].j1 = j;
					ms[k].i2 = i;
					ms[k].j2 = j + 1;
				}

				for (k = 0; k < MaxSCnt; k++) {
					if (twoSum2 > ms[k].sum) {
						break;
					}
				}
				if (k != MaxSCnt) {
					for (int k2 = MaxSCnt - 1; k2 > k; k2--) {
						ms[k2].i1 = ms[k2 - 1].i1;
						ms[k2].j1 = ms[k2 - 1].j1;
						ms[k2].i2 = ms[k2 - 1].i2;
						ms[k2].j2 = ms[k2 - 1].j2;
						ms[k2].sum = ms[k2 - 1].sum;
					}
					ms[k].sum = twoSum2;
					ms[k].i1 = i;
					ms[k].j1 = j;
					ms[k].i2 = i + 1;
					ms[k].j2 = j;
				}
			}
		}
	}
}