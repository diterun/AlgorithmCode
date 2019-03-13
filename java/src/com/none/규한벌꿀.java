package com.none;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 규한벌꿀 {
	static int N;
	static int M;
	static int C;
	static int map[][];
	static int dp[][];
	static int tof[];
	static int max;
	static int ans1;
	static int ans1_x;
	static int ans1_y;
	static int ans2;
	static int ans2_x;
	static int ans2_y;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // <=10 벌통들의 크기
			M = Integer.parseInt(st.nextToken()); // <=5 벌통의 개수
			C = Integer.parseInt(st.nextToken()); // <= 30 꿀을 채취할 수 있는 최대 양

			map = new int[N][N];
			dp = new int[N][N];
			tof = new int[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N - M + 1; j++) { // 그 이후 범위는 마지막 조합에 포함되므로 돌릴 필요가 없음.
					make(j, i, 0);
					dp[i][j] = max;
					max = 0;
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N - M + 1; j++) { 
					if (ans1 < dp[i][j]) { // 현재 최대값(ans1)보다 클 경우,
						if (ans1_y == i && (ans1_x < j && ans1_x + M >= j)) { 
							// ans1보다 크고 ans1의 x좌표가 최대값(dp[i][j])의 범주에 속해있으면 ans1의 값은 ans2가 될 수 없으므로, ans2는 이전값 유지
						} else { // 아닐 경우, ans1의 값이 2번째로 큰값(ans2)가 된다.
							ans2 = ans1;
						}
						ans1 = dp[i][j];
						ans1_x = j;
						ans1_y = i;
					} else if (ans1 >= dp[i][j] && ans2 < dp[i][j]) { // dp[i][j]가 2번째로 클 경우, (ans1 <= dp[i][j] < ans2)
						if (ans1_y == i && (ans1_x < j && ans1_x + M >= j)) { // ans1의 x 범위에 포함되면 ans2로 선택될 수 없으므로 건너뜀
							continue;
						} else {
							ans2 = dp[i][j];
						}
					}
				}
			}
			
			System.out.println("#" + tc + " " + (ans1 + ans2));
			ans1 = 0;
			ans2 = 0;
		}
	}

	private static void make(int x, int y, int cnt) { // 중복순열을 만들면서 최대값을 찾음
		// TODO Auto-generated method stub
		if (cnt == M) {
			int count = 0;
			int gop = 0;
			int now;
			for (int i = 0; i < cnt; i++) {
				if (tof[i] == 1) {
					now = map[y][i + x];
					if (count + now > C) { // 해당 순열의 합이 C를 넘어서면 안되므로
						return;
					}
					gop += now * now;
					count += now;
				}
			}

			max = Math.max(max, gop);
			return;
		}
		if (x + cnt + 1 > N) { // 좌표 범위를 넘어서면 계산하면 안되므로 끝냄
			make(x, y, M);
			return;
		}
		
		// 중복 순열 만듬 ( 2^M )
		tof[cnt] = 1;
		make(x, y, cnt + 1);
		tof[cnt] = 0;
		make(x, y, cnt + 1);
	}

}