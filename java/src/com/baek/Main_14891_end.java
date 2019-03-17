package com.baek;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14891_end {
	static int k, result;
	/**
	 * 톱니바퀴 1번부터 4번이 각각 0~3번 index에 대응 된다.
	 */
	static char[][] top = new char[4][8];
	static boolean[] check = new boolean[4];
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("baek/14891.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		result = 0;
		
		for (int i = 0; i < 4; i++) {
			top[i] = br.readLine().toCharArray();
		}
		
		k = Integer.parseInt(br.readLine().trim());
		for (int i = 0; i < k; i++) {
			/**
			 * 톱니바퀴 돌린 것을 초기화 한다.
			 */
			for (int j = 0; j < 4; j++) {
				check[j] = false;
			}
			st = new StringTokenizer(br.readLine().trim());
			
			/**
			 * 입력과 동시에 돌리러 간다.
			 * 1번 톱니바퀴는 0번 index이니 -1 해준다.
			 */
			dolimpan(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()));
		}

		/**
		 * 각 톱니바퀴의 점수는 S극이 12시 일 때, 2^index이다.
		 */
		for (int i = 0; i < 4; i++) {
			if(top[i][0] == '1') {
				result += (1 << i);
			}
		}

		System.out.println(result);

		br.close();
	}

	private static void dolimpan(int n, int dir) {
		check[n] = true;
		
		/**
		 * 왼쪽에 톱니바퀴가 있고, 아직 돌린 적이 없으면서, 나와 극이 다르다면 돌리러간다.
		 */
		if(n - 1 >= 0 && !check[n - 1] && top[n][6] != top[n - 1][2]) {
			dolimpan(n - 1, -dir);
		}
		/**
		 * 오른쪽에 톱니바퀴가 있고, 아직 돌린 적이 없으면서, 나와 극이 다르다면 돌리러간다.
		 */
		if(n + 1 < 4 && !check[n + 1] && top[n][2] != top[n + 1][6]) {
			dolimpan(n + 1, -dir);
		}
		
		if(dir == 1) {
			//시계 방향
			char temp = top[n][7];
			for (int i = 7; i >= 1; i--) {
				top[n][i] = top[n][i - 1];
			}
			top[n][0] = temp;
		} else if(dir == -1) {
			//반시계 방향
			char temp = top[n][0];
			for (int i = 1; i < 8; i++) {
				top[n][i - 1] = top[n][i];
			}
			top[n][7] = temp;
		}

	}
}