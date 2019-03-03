package com.none;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2383 {
	static int INF = Integer.MAX_VALUE;
	static int MAX = 10;
	static int T, test_case, n, result, input;
	/**
	 * huIndex	- 사람 수
	 * stIndex	- 계단 수
	 * huMax	- 매번 계단1에 가게 될 사람 수
	 */
	static int huIndex, stIndex, huMax;
	/**
	 * human[i][0] - i번째 사람의 y축
	 * human[i][1] - i번째 사람의 x축
	 */
	static int[][] human = new int[MAX][2];
	/**
	 * i번째 계단의
	 * stair[i][0] - y축
	 * stair[i][1] - x축
	 * stair[i][2] - 길이(분)
	 */
	static int[][] stair = new int[2][3];
	static int[][] stairForHuman = new int[2][MAX];
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/2383.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine().trim());

		for (test_case = 1; test_case <= T; test_case++) {
			/** 초기화 */
			huIndex = stIndex = 0;
			result = 10000000;

			/** 입력 */
			n = Integer.parseInt(br.readLine().trim());
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					input = st.nextToken().charAt(0) - '0';

					if (input == 1) {
						human[huIndex][0] = i;
						human[huIndex++][1] = j;
					} else if (input > 1) {
						stair[stIndex][0] = i;
						stair[stIndex][1] = j;
						stair[stIndex++][2] = input;
					}
				}
			}
			
			/**
			 * 모든 human들이 각각
			 * 1번 혹은 2번 계단을 이용한다는 것을 담을 배열
			 * humans1을 건내주면서
			 * nC0 ~ nCn 의 모든 경우를 계산한다.
			 */
			int[] humans1 = new int[huIndex];
			for (huMax = 0; huMax <= huIndex; huMax++) {
				getStair(0, humans1, 0);
			}
			
			System.out.println("#" + test_case + " " + result);
		}

		br.close();
	}

	private static void getStair(int start, int[] hu, int cnt) {
		if(cnt == huMax) {
			int x, y;
			
			/**
			 * 각 계단으로 가는 사람에 대한 배열을 초기화한다.
			 */
			for (int i = 0; i < MAX; i++) {
				stairForHuman[0][i] = 0;
				stairForHuman[1][i] = 0;
			}
			
			/**
			 * 사람과 계단 사이의 거리를 검사한다. 도착 1분 후 출발하기 때문에 1을 더한다.
			 * ****
			 * hu[i]에는 0 혹은 1이 들어가서
			 * 1번 계단 혹은 2번 계단임을 알 수 있다.
			 */
			for (int i = 0; i < huIndex; i++) {
				y = Math.abs(stair[hu[i]][0] - human[i][0]);
				x = Math.abs(stair[hu[i]][1] - human[i][1]);
				
				stairForHuman[hu[i]][i] = x + y + 1;
			}

			/**
			 * index i는 사람의 번호이기 때문에,
			 * 그 계단으로 가지 않은 사람은 INF로 바꿔 절대 가지 않음을 표시한다.
			 */
			for (int i = 0; i < MAX; i++) {
				if(stairForHuman[0][i] == 0) {
					stairForHuman[0][i] = INF;
				}
				if(stairForHuman[1][i] == 0) {
					stairForHuman[1][i] = INF;
				}
			}
			
			/**
			 * 최종 결과 도출 함수.
			 */
			getResult();
			
			return;
		}
		
		/**
		 * hu[i]에는
		 * 0000
		 * ~
		 * 1111
		 * 까지 모든 경우를 검사한다.
		 */
		for (int i = start; i < huIndex; i++) {
			hu[i] = 1;
			getStair(i + 1, hu, cnt + 1);
			hu[i] = 0;
		}
	}

	private static void getResult() {
		/**
		 * 오름차순 정리하여, 각 계단에 빨리 도착한 순서대로 세운다.
		 */
		for (int i = 0; i < MAX; i++) {
			for (int j = i + 1; j < MAX; j++) {
				int temp;
				if(stairForHuman[0][i] > stairForHuman[0][j]) {
					temp = stairForHuman[0][i];
					stairForHuman[0][i] = stairForHuman[0][j];
					stairForHuman[0][j] = temp;
				}
				if(stairForHuman[1][i] > stairForHuman[1][j]) {
					temp = stairForHuman[1][i];
					stairForHuman[1][i] = stairForHuman[1][j];
					stairForHuman[1][j] = temp;
				}
			}
		}
		int sub1 = 0, sub2 = 0;
		/**
		 * 개수가
		 * 0개는		size 0
		 * 1~3개는	size 1
		 * 4~6개는	size 2
		 * 7~9개는	size 3
		 * 10개는		size 4
		 * index는 가장 끝에 서있는 사람의 index를 3으로 나누어서 남은 나머지이다.
		 * 0 1 2 0 1 2 ... 순서
		 */
		int size1 = (huIndex - huMax + 2) / 3;
		int size2 = (huMax + 2) / 3;
		int index1 = (huIndex - huMax + 2) % 3;
		int index2 = (huMax + 2) % 3;
		
		/**
		 * 2 2 3 4 4 7 일때,
		 * 계단 길이가 3이라면 10이고 ( 3 + 3 < 7 ---- 7 + 3 = 10 )
		 * 계단 길이가 5라면 13이다. ( 3 + 5 > 7 ---- 3 + 5 + 5 = 13 )
		 */
		for (int i = 0; i < size1; i++) {
			int s1 = stairForHuman[0][index1 + (3 * i)] + stair[0][2];
			int s2 = sub1 + stair[0][2];
			sub1 = s1 > s2 ? s1 : s2;
		}
		
		for (int i = 0; i < size2; i++) {
			int s1 = stairForHuman[1][index2 + (3 * i)] + stair[1][2];
			int s2 = sub2 + stair[1][2];
			sub2 = s1 > s2 ? s1 : s2;
		}
		
		int rsub = Math.max(sub1, sub2);
		
		result = result < rsub ? result : rsub;
	}
}
