package com.d5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_6058_end {
	static int MAX = 402;
	static int T, test_case, k, ki;
	static int L, N, glass;
	static double B, result;
	static String[] line;
	/** i층 j번 와인 잔에 남아있는 와인 양 */
	static double[][] wine = new double[2][(MAX * (MAX + 1)) / 2];

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/d5/6058.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine().trim());

		for (test_case = 1; test_case <= T; test_case++) {
			result = 0;
			for (int i = 0, isize = (MAX * (MAX + 1)) / 2; i < isize; i++) {
				wine[0][i] = 0;
				wine[1][i] = 0;
			}

			line = br.readLine().split(" ");
			B = Double.parseDouble(line[0].trim());
			L = Integer.parseInt(line[1].trim());
			N = Integer.parseInt(line[2].trim());

			if (L == 1 && N == 1) {
				result = 250.0;
			} else {
				/** 1층에서 부터 시작 */
				wine[1][1] = B * 750.0;
				
				/** 목적하는 층 바로 전까지 진행한다.*/
				for (int i = 1; i < L; i++) {
					/** i층에 있는 전체 glass의 갯수*/
					glass = (i * (i + 1)) / 2;
					
					/** 
					 * i층 j잔의 아래에 있는 3개의 잔
					 * i + 1층
					 * (j)잔
					 * (j + k)잔
					 * (j + k + 1)잔
					 */
					k = 1;
					ki = 0;
					for (int j = 1; j <= glass; j++) {
						/** 현재 진행 될 층*/
						int nowIndex = i % 2;
						/** 현재 진행되는 층의 와인잔이 넘쳐서 내려갈 다음 층*/
						int nextIndex = (i + 1) % 2;
						
						/** 잔이 넘친다면*/
						if (wine[nowIndex][j] > 250) {
							double temp = wine[nowIndex][j] - 250;

							/** 아래 3잔에 나누어서 들어간다.*/
							wine[nextIndex][j] += temp / 3;
							wine[nextIndex][j + k] += temp / 3;
							wine[nextIndex][j + k + 1] += temp / 3;
						}
						/** 이미 지나간 잔이면 초기화*/
						wine[nowIndex][j] = 0;
						
						/** k와 ki 계산*/
						ki++;
						if (ki == k) {
							k++;
							ki = 0;
						}
					}
				}

				int nowIndex = L % 2;
				result = wine[nowIndex][N] > 250 ? 250.0 : wine[nowIndex][N];
			}

			System.out.println("#" + test_case + " " + result);
		}

		br.close();
	}

}
