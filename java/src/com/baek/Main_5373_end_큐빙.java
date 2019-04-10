package com.baek;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main_5373_end_큐빙 {
	static int t, T;
	static int n;
	static String[] input;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/baek/5373.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine().trim());
		
		for (t = 0; t < T; t++) {
			char[][] U = {{'w','w','w'},{'w','w','w'},{'w','w','w'}};
			char[][] D = {{'y','y','y'},{'y','y','y'},{'y','y','y'}};
			char[][] F = {{'r','r','r'},{'r','r','r'},{'r','r','r'}};
			char[][] B = {{'o','o','o'},{'o','o','o'},{'o','o','o'}};
			char[][] L = {{'g','g','g'},{'g','g','g'},{'g','g','g'}};
			char[][] R = {{'b','b','b'},{'b','b','b'},{'b','b','b'}};
			
			n = Integer.parseInt(br.readLine().trim());
			input = br.readLine().split(" ");
			
			for (int i = 0; i < n; i++) {
				char myun = input[i].charAt(0);
				char dir = input[i].charAt(1);
				
				switch(myun) {
				case 'U':
					if(dir == '+') {
						for (int j = 0; j < 3; j++) {
							char temp = B[2][j];
							B[2][j] = L[2][j];
							L[2][j] = F[2][j];
							F[2][j] = R[2][j];
							R[2][j] = temp;
						}
						char temp = U[0][1];
						U[0][1] = U[1][0];
						U[1][0] = U[2][1];
						U[2][1] = U[1][2];
						U[1][2] = temp;
						temp = U[0][0];
						U[0][0] = U[2][0];
						U[2][0] = U[2][2];
						U[2][2] = U[0][2];
						U[0][2] = temp;
					} else {
						for (int j = 0; j < 3; j++) {
							char temp = B[2][j];
							B[2][j] = R[2][j];
							R[2][j] = F[2][j];
							F[2][j] = L[2][j];
							L[2][j] = temp;
						}
						char temp = U[0][1];
						U[0][1] = U[1][2];
						U[1][2] = U[2][1];
						U[2][1] = U[1][0];
						U[1][0] = temp;
						temp = U[0][0];
						U[0][0] = U[0][2];
						U[0][2] = U[2][2];
						U[2][2] = U[2][0];
						U[2][0] = temp;
					}
					break;
				case 'D':
					if(dir == '+') {
						for (int j = 0; j < 3; j++) {
							char temp = B[0][j];
							B[0][j] = R[0][j];
							R[0][j] = F[0][j];
							F[0][j] = L[0][j];
							L[0][j] = temp;
						}
						char temp = D[0][1];
						D[0][1] = D[1][0];
						D[1][0] = D[2][1];
						D[2][1] = D[1][2];
						D[1][2] = temp;
						temp = D[0][0];
						D[0][0] = D[2][0];
						D[2][0] = D[2][2];
						D[2][2] = D[0][2];
						D[0][2] = temp;
					} else {
						for (int j = 0; j < 3; j++) {
							char temp = B[0][j];
							B[0][j] = L[0][j];
							L[0][j] = F[0][j];
							F[0][j] = R[0][j];
							R[0][j] = temp;
						}
						char temp = D[0][1];
						D[0][1] = D[1][2];
						D[1][2] = D[2][1];
						D[2][1] = D[1][0];
						D[1][0] = temp;
						temp = D[0][0];
						D[0][0] = D[0][2];
						D[0][2] = D[2][2];
						D[2][2] = D[2][0];
						D[2][0] = temp;
					}
					break;
				case 'F':
					if(dir == '+') {
						for (int j = 0; j < 3; j++) {
							char temp = D[2][j];
							D[2][j] = R[2-j][2];
							R[2-j][2] = U[2][j];
							U[2][j] = L[j][0];
							L[j][0] = temp;
						}
						char temp = F[0][1];
						F[0][1] = F[1][0];
						F[1][0] = F[2][1];
						F[2][1] = F[1][2];
						F[1][2] = temp;
						temp = F[0][0];
						F[0][0] = F[2][0];
						F[2][0] = F[2][2];
						F[2][2] = F[0][2];
						F[0][2] = temp;
					} else {
						for (int j = 0; j < 3; j++) {
							char temp = D[2][j];
							D[2][j] = L[j][0];
							L[j][0] = U[2][j];
							U[2][j] = R[2-j][2];
							R[2-j][2] = temp;
						}
						char temp = F[0][1];
						F[0][1] = F[1][2];
						F[1][2] = F[2][1];
						F[2][1] = F[1][0];
						F[1][0] = temp;
						temp = F[0][0];
						F[0][0] = F[0][2];
						F[0][2] = F[2][2];
						F[2][2] = F[2][0];
						F[2][0] = temp;
					}
					break;
				case 'B':
					if(dir == '+') {
						for (int j = 0; j < 3; j++) {
							char temp = D[0][j];
							D[0][j] = L[j][2];
							L[j][2] = U[0][j];
							U[0][j] = R[2-j][0];
							R[2-j][0] = temp;
						}
						char temp = B[0][1];
						B[0][1] = B[1][0];
						B[1][0] = B[2][1];
						B[2][1] = B[1][2];
						B[1][2] = temp;
						temp = B[0][0];
						B[0][0] = B[2][0];
						B[2][0] = B[2][2];
						B[2][2] = B[0][2];
						B[0][2] = temp;
					} else {
						for (int j = 0; j < 3; j++) {
							char temp = D[0][j];
							D[0][j] = R[2-j][0];
							R[2-j][0] = U[0][j];
							U[0][j] = L[j][2];
							L[j][2] = temp;
						}
						char temp = B[0][1];
						B[0][1] = B[1][2];
						B[1][2] = B[2][1];
						B[2][1] = B[1][0];
						B[1][0] = temp;
						temp = B[0][0];
						B[0][0] = B[0][2];
						B[0][2] = B[2][2];
						B[2][2] = B[2][0];
						B[2][0] = temp;
					}
					break;
				case 'L':
					if(dir == '+') {
						for (int j = 0; j < 3; j++) {
							char temp = B[j][0];
							B[j][0] = D[2-j][2];
							D[2-j][2] = F[2-j][2];
							F[2-j][2] = U[j][0];
							U[j][0] = temp;
						}
						char temp = L[0][1];
						L[0][1] = L[1][0];
						L[1][0] = L[2][1];
						L[2][1] = L[1][2];
						L[1][2] = temp;
						temp = L[0][0];
						L[0][0] = L[2][0];
						L[2][0] = L[2][2];
						L[2][2] = L[0][2];
						L[0][2] = temp;
					} else {
						for (int j = 0; j < 3; j++) {
							char temp = B[j][0];
							B[j][0] = U[j][0];
							U[j][0] = F[2-j][2];
							F[2-j][2] = D[2-j][2];
							D[2-j][2] = temp;
						}
						char temp = L[0][1];
						L[0][1] = L[1][2];
						L[1][2] = L[2][1];
						L[2][1] = L[1][0];
						L[1][0] = temp;
						temp = L[0][0];
						L[0][0] = L[0][2];
						L[0][2] = L[2][2];
						L[2][2] = L[2][0];
						L[2][0] = temp;
					}
					break;
				case 'R':
					if(dir == '+') {
						for (int j = 0; j < 3; j++) {
							char temp = B[j][2];
							B[j][2] = U[j][2];
							U[j][2] = F[2-j][0];
							F[2-j][0] = D[2-j][0];
							D[2-j][0] = temp;
						}
						char temp = R[0][1];
						R[0][1] = R[1][0];
						R[1][0] = R[2][1];
						R[2][1] = R[1][2];
						R[1][2] = temp;
						temp = R[0][0];
						R[0][0] = R[2][0];
						R[2][0] = R[2][2];
						R[2][2] = R[0][2];
						R[0][2] = temp;
					} else {
						for (int j = 0; j < 3; j++) {
							char temp = B[j][2];
							B[j][2] = D[2-j][0];
							D[2-j][0] = F[2-j][0];
							F[2-j][0] = U[j][2];
							U[j][2] = temp;
						}
						char temp = R[0][1];
						R[0][1] = R[1][2];
						R[1][2] = R[2][1];
						R[2][1] = R[1][0];
						R[1][0] = temp;
						temp = R[0][0];
						R[0][0] = R[0][2];
						R[0][2] = R[2][2];
						R[2][2] = R[2][0];
						R[2][0] = temp;
					}
					break;
				}
			}

			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					System.out.print(U[i][j]);
				}
				System.out.println();
			}
		}
		
		br.close();
	}
}
