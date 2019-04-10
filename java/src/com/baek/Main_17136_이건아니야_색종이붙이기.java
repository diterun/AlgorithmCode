package com.baek;

import java.io.FileInputStream;
import java.util.Scanner;

public class Main_17136_이건아니야_색종이붙이기 {
	static int n = 10, max, result, ones;
	static int[][] map = new int[n][n];
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/baek/17136.txt"));
		Scanner sc = new Scanner(System.in);
		
		result = Integer.MAX_VALUE;
		ones = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
				
				max += map[i][j];
			}
		}
		
		for (int i = 1; i < n - 1; i++) {
			for (int j = 1; j < n - 1; j++) {
				if(map[i][j] == 1) {
					int cc = 0;
					if(map[i - 1][j] == 0) {
						cc++;
					}
					if(map[i + 1][j] == 0) {
						cc++;
					}
					if(map[i][j - 1] == 0) {
						cc++;
					}
					if(map[i][j + 1] == 0) {
						cc++;
					}
					if(cc >= 3) {
						ones++;
					}
				}
			}
		}
		
		if(max < 4) {
			System.out.println(max);
			sc.close();
			return;
		} else if(max == 100) {
			System.out.println(4);
			sc.close();
			return;
		} else if(ones >= 6) {
			System.out.println(-1);
			sc.close();
			return;
		}
		

		for (int five = 0; five <= 3; five++) {
			for (int four = 0; four <= 5; four++) {
				for (int three = 0; three <= 5; three++) {
					for (int two = 0; two <= 5; two++) {
						for (int one = ones; one <= 5; one++) {
							int sum = one + (4 * two) + (9 * three) + (16 * four) + (25 * five);
							int cnt = one + two + three + four + five;
							if(sum == max && cnt < result) {
								if(canPaper(map, one, two, three, four, five)) {
									System.out.println(one + " " + two + " " + three + " " + four + " " + five);
									result = result < cnt ? result : cnt;
								}
							}
						}
					}
				}
			}
		}
		
		if(result == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(result);
		}
		
		sc.close();
	}

	private static boolean canPaper(int[][] map, int one, int two, int three, int four, int five) {
		
		if(five > 0) {
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 6; j++) {
					if(map[i][j] == 1) {
						if(canDelete(map, i, j, 5)) {
							int[][] temp = new int[n][n];
							for (int k = 0; k < n; k++) {
								for (int k2 = 0; k2 < n; k2++) {
									temp[k][k2] = map[k][k2];
								}
							}
							
							for (int ii = i; ii < i + 5; ii++) {
								for (int jj = j; jj < j + 5; jj++) {
									temp[ii][jj] = 0;
								}
							}
							
							if(canPaper(temp, one, two, three, four, five - 1)) {
								return true;
							}
						}
					}
				}
			}
			
			return false;
		}
		
		if(four > 0) {
			for (int i = 0; i < 7; i++) {
				for (int j = 0; j < 7; j++) {
					if(map[i][j] == 1) {
						if(canDelete(map, i, j, 4)) {
							int[][] temp = new int[n][n];
							
							for (int k = 0; k < n; k++) {
								for (int k2 = 0; k2 < n; k2++) {
									temp[k][k2] = map[k][k2];
								}
							}
							
							for (int ii = i; ii < i + 4; ii++) {
								for (int jj = j; jj < j + 4; jj++) {
									temp[ii][jj] = 0;
								}
							}
							
							if(canPaper(temp, one, two, three, four - 1, five)) {
								return true;
							}
						}
					}
				}
			}
			
			return false;
		}
		
		if(three > 0) {
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if(map[i][j] == 1) {
						if(canDelete(map, i, j, 3)) {
							int[][] temp = new int[n][n];
							
							for (int k = 0; k < n; k++) {
								for (int k2 = 0; k2 < n; k2++) {
									temp[k][k2] = map[k][k2];
								}
							}
							
							for (int ii = i; ii < i + 3; ii++) {
								for (int jj = j; jj < j + 3; jj++) {
									temp[ii][jj] = 0;
								}
							}
							
							if(canPaper(temp, one, two, three - 1, four, five)) {
								return true;
							}
						}
					}
				}
			}
			
			return false;
		}
		
		if(two > 0) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					if(map[i][j] == 1) {
						if(canDelete(map, i, j, 2)) {
							int[][] temp = new int[n][n];
							
							for (int k = 0; k < n; k++) {
								for (int k2 = 0; k2 < n; k2++) {
									temp[k][k2] = map[k][k2];
								}
							}
							
							for (int ii = i; ii < i + 2; ii++) {
								for (int jj = j; jj < j + 2; jj++) {
									temp[ii][jj] = 0;
								}
							}
							
							if(canPaper(temp, one, two - 1, three, four, five)) {
								return true;
							}
						}
					}
				}
			}
			
			return false;
		}
		
		if(one > 0) {
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					if(map[i][j] == 1) {
						int[][] temp = new int[n][n];
						
						for (int k = 0; k < n; k++) {
							for (int k2 = 0; k2 < n; k2++) {
								temp[k][k2] = map[k][k2];
							}
						}
						
						temp[i][j] = 0;
						
						if(canPaper(temp, one - 1, two, three, four, five)) {
							return true;
						}
					}
				}
			}
			
			return false;
		}
		
		return true;
	}

	private static boolean canDelete(int[][] map, int y, int x, int cnt) {
		for (int i = y; i < y + cnt; i++) {
			for (int j = x; j < x + cnt; j++) {
				if(map[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}
}