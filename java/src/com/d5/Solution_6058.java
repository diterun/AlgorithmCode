package com.d5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
/**
 * [입력]

첫 번째 줄에 테스트 케이스의 수 T가 주어진다.

각 테스트 케이스의 첫 번째 줄에 세 정수 B, L, N 이 공백으로 구분되어 주어진다.
1<=B<=50000
1<=L<=400
1<=N<=(L*(L+1))/2

[출력]

각 테스트 케이스마다 첫 번째 줄에는 ‘#x’(T는 테스트케이스 번호를 의미하며 1부터 시작한다)를 출력하고,

각 테스트 케이스마다 B개의 와인병을 붓고나면 L, N의 위치에 있는 와인잔에 몇 ml의 와인이 들어있게 되는지 출력한다.

정답과의 절대오차 혹은 상대오차가 10-6 이하이면 정답으로 인정한다.
 * @author HanamHwang
 *
#1 166.666666666667
#2 250.000000000000
#3 250.000000000000
#4 0.000000000000
#5 55.555555555556
#6 157.407407407407
 */
public class Solution_6058 {
	static int MAX = 102;
	static int T, test_case;
	static int result, n;

	public static void main(String[] args) throws Exception{
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("res/6058.txt"));
		
		T = Integer.parseInt(br.readLine().trim());

		for (test_case = 1; test_case <= T; test_case++) {
			
			System.out.println("#" + test_case + " " + result);
		}
		
		br.close();
	}

}
