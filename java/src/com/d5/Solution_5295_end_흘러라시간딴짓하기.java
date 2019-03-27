package com.d5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * ******시도 01******
 * 1. 중복인 애들의 수를 센다. => m
 * 2. 최고 m ~ 최대 2m개가 나오겠다.(추측) 틀림.
 * 3. 중복인 애들 중에서 위 아래에 같은 숫자가 없는 애들을 지운다.
 * 4. 지울 애들 중에서는 위와 같지 않은 애가 최우선이다.
 * 5. 머리로는 되는데 코드로 안됨...
 * 
 * 
 * ******시도 02******
 * 1. 1,2,3 중의 한 라인씩 추가하는 자료구조를 만든다. 아래는 그 예
 * 2.	5 3 1 6 7   &  4 2 1 6 7 
 * 		5 1 3 4 7   &  5 1 3 4 7
 * 		3 1 5 6 2   &  7 4 5 6 2
 * 3. 이렇게 만들고 나니 안됨...
 * 
 * 
 * ******시도 03******
 * 1. 2번째와 3번째 줄 중에서 없는 애들을 1번째에서 지워버리자!
 * 2-1. 1번째 줄에서 지워지는 애들 index만큼 지우면서 쭉쭉 들어가자!
 * 2-2. 지우는 것을 for문을 돌림. 지우면, 지운 애들 중에서 0이 된 애쪽에서 다시 시작... 느림
 * 2-3. 지우는 것을 dfs로 했을 때 성공.
 * 
 */
public class Solution_5295_end_흘러라시간딴짓하기 {
	static int T, test_case, n, num;
	static int result;
	static StringTokenizer st1, st2, st3;
	/**
	 * 한 줄을 저장한다.
	 * 1번째 줄은 [값]=index 형식으로 저장된다. (index를 빨리 찾기 위해, 중복이 없어서 가능)
	 * 2, 3번째 줄은 [index]=값 형식으로 저장된다.
	 */
	static int[][] line;
	/**
	 * 2, 3번째 줄에서 중복 된 값들을 저장한다.
	 * 2번째 줄이 2 3 2 3 5 1 5 1 1 3 이라면
	 * [1] = 3;
	 * [2] = 2;
	 * [3] = 3;
	 * [4] = 0;
	 * [5] = 2;
	 * 이런 식으로 저장된다.
	 */
	static int[][] lineCnt;
	static boolean[] isClear;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/5925.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine().trim());

		for (test_case = 1; test_case <= T; test_case++) {
			result = 0;

			n = Integer.parseInt(br.readLine().trim());
			line = new int[3][n + 1];
			lineCnt = new int[2][n + 1];
			isClear = new boolean[n + 1];

			st1 = new StringTokenizer(br.readLine());
			st2 = new StringTokenizer(br.readLine());
			st3 = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				//첫 라인의 숫자는 line[값] = index 로 넣어준다!
				line[0][Integer.parseInt(st1.nextToken())] = i;
				
				/**
				 * 값을 저장하고 그 값에 해당하는 cnt를 늘린다.
				 */
				num = Integer.parseInt(st2.nextToken());
				line[1][i] = num;
				lineCnt[0][num]++;
				
				num = Integer.parseInt(st3.nextToken());
				line[2][i] = num;
				lineCnt[1][num]++;
			}
			
			/*
			 * 전체를 돌면서 아직 돌지 않은 곳이고 0이라면 dfs를 시작한다.
			 */
			for (int i = 1; i <= n; i++) {
				if(!isClear[i] && (lineCnt[1][i] == 0 || lineCnt[0][i] == 0)) {
					isClear[i] = true;
					
					//line[0][i]는 index값이 들어있다.
					dfs(line[0][i]);
				}
			}
			
			for (int i = 1; i <= n; i++) {
				if(isClear[i]) {
					result++;
				}
			}

			System.out.println("#" + test_case + " " + result);
		}

		br.close();
	}

	private static void dfs(int index) {
		/*
		 * line[1]과 [2]에는 index에 해당하는 값이 들어있고,
		 * lineCnt[0]과 [1]에는 해당 값의 count가 들어있다.
		 */
		int a = line[1][index];
		int b = line[2][index];
		lineCnt[0][a]--;
		lineCnt[1][b]--;
		
		//해당하는 값의 count가 0이면서, 아직 돌지 않은 곳이면 dfs를 들어간다.
		//line[0][a]는 index가 들어있다.
		if(!isClear[a] && lineCnt[0][a] == 0) {
			isClear[a] = true;
			dfs(line[0][a]);
		}
		if(!isClear[b] && lineCnt[1][b] == 0) {
			isClear[b] = true;
			dfs(line[0][b]);
		}
	}
}
