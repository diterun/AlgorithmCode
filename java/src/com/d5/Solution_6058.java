package com.d5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
/** 아이고 어렵다
 * 
각 와인잔은 250ml의 와인을 담을 수 있다. 바텐더는 750ml의 와인 B 병을 가장 위의 와인잔(L=1, N=1)에 붓는다.

즉, 총 750 x B ml의 와인을 붓는 것이다.

계속 와인을 붓게 되면 와인잔에 250ml의 와인이 부어져 가득 찼기 때문에

계속 부어지는 와인이 와인잔 밖으로 넘치게 될 것이다.

우리가 사용하는 와인잔은 이런 경우를 위해 특별히 제작되었기 때문에,

넘치는 와인은 일체의 낭비 없이 이 와인잔의 밑에 있는 세 개의 와인잔에 동등하게 나눠진다.

바텐더가 모든 와인을 붓고 나면 L, N의 위치에 있는 와인잔에 몇 ml의 와인이 들어있을지 구하는 프로그램을 작성하라.

[3층 구조]
  1
 2 3
4 5 6

[입력]

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

6번 답은 4250 / 27 이더라...
원래 5000인데, 5층으로 750이 떨어진거다...
 */
public class Solution_6058 {
	static int MAX = 102;
	static int T, test_case;
	static int B, L, N;
	static double result;
	static String[] line;

	public static void main(String[] args) throws Exception{
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("res/6058.txt"));
		
		T = Integer.parseInt(br.readLine().trim());

		for (test_case = 1; test_case <= T; test_case++) {
			result = 0;
			
			line = br.readLine().split(" ");
			B = Integer.parseInt(line[0].trim());
			L = Integer.parseInt(line[1].trim());
			N = Integer.parseInt(line[2].trim());
			
			if(L == 1 && N == 1) {
				result = 250.0;
			} else {
				
			}
			
			System.out.println("#" + test_case + " " + result);
		}
		
		br.close();
	}

}
