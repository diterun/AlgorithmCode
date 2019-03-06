package com.jungol;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_2606_end {
	static int n, m, h, result;
	static int[][][] box;
	static boolean checkBox[][][], last;
	static LinkedList<Integer> qj = new LinkedList<>();
	static LinkedList<Integer> qi = new LinkedList<>();
	static LinkedList<Integer> qk = new LinkedList<>();
//	static StringTokenizer st;
	static int[][] move = { { 0, 0, 1 }, { 0, 0, -1 }, { 1, 0, 0 }, { -1, 0, 0 }, { 0, 1, 0 }, { 0, -1, 0 } };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/jung2606.txt"));
		Scanner sc = new Scanner(System.in);
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		last = true;

//		st = new StringTokenizer(br.readLine().trim());
//		st = new StringTokenizer(sc.nextLine());
//		m = Integer.parseInt(st.nextToken().trim());
//		n = Integer.parseInt(st.nextToken().trim());
//		h = Integer.parseInt(st.nextToken().trim());
		m = sc.nextInt();
		n = sc.nextInt();
		h = sc.nextInt();

		box = new int[m + 2][n + 2][h + 2];
		checkBox = new boolean[m + 2][n + 2][h + 2];
		for (int i = 0; i < n + 2; i++) {
			for (int j = 0; j < m + 2; j++) {
				for (int k = 0; k < h + 2; k++) {
					box[j][i][k] = -1;
				}
			}
		}

		for (int k = 1; k <= h; k++) {
			for (int i = 1; i <= n; i++) {
//				st = new StringTokenizer(br.readLine().trim());
//				st = new StringTokenizer(sc.nextLine());
				for (int j = 1; j <= m; j++) {
//					box[j][i][k] = Integer.parseInt(st.nextToken().trim());
					box[j][i][k] = sc.nextInt();
					if(box[j][i][k] == 1) {
						qj.offer(j);
						qi.offer(i);
						qk.offer(k);
						checkBox[j][i][k] = true;
					} else if(box[j][i][k] == -1) {
						checkBox[j][i][k] = true;
					}
				}
			}
		}
		
		while (!qj.isEmpty()) {
			int len = qj.size();
			
			for (int i = 0; i < len; i++) {
				int nj = qj.poll();
				int ni = qi.poll();
				int nk = qk.poll();
				
				for (int j = 0; j < 6; j++) {
					int dj = nj + move[j][0];
					int di = ni + move[j][1];
					int dk = nk + move[j][2];
					
					if(!checkBox[dj][di][dk] && box[dj][di][dk] == 0) {
						box[dj][di][dk] = 1;
						checkBox[dj][di][dk] = true;

						qj.offer(dj);
						qi.offer(di);
						qk.offer(dk);
					}
				}
			}

//			for (int k = 1; k <= h; k++) {
//				for (int i = 1; i <= n; i++) {
//					for (int j = 1; j <= m; j++) {
//						System.out.print(box[j][i][k] + " ");
//					}
//					System.out.println();
//				}
//			}
//			System.out.println();
			
			result++;
		}

		for (int k = 1; k <= h; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= m; j++) {
					if (box[j][i][k] == 0) {
						last = false;
					}
				}
			}
		}
		
		if(last) {
			System.out.println(result - 1);
		} else {
			System.out.println(-1);
		}

//		br.close();
		sc.close();
	}
}
