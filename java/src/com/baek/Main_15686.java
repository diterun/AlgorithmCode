package com.baek;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15686 {
	static int n, m, a, result;
	/**
	 * home	- 집들을 저장, index로 homei
	 * shop	- 치킨 가게들을 저장, index로 shopi
	 */
	static int homei, shopi;
	static int[][] home = new int[102][2];
	static int[][] shop = new int[14][2];
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/baek15686.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		/**
		 * 초기화
		 * result는 절대 나올 수 없는 최대 값 10만으로 설정한다.
		 */
		homei = shopi = 0;
		result = 100000;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				/**
				 * map을 입력 받을 때 map정보를 모두 가지지 않고,
				 * 집과 치킨집에 관한 정보만 저장한다.
				 * (x, y 좌표 그리고 수)
				 */
				a = Integer.parseInt(st.nextToken());

				if (a == 1) {
					home[homei][0] = i;
					home[homei++][1] = j;
				} else if (a == 2) {
					shop[shopi][0] = i;
					shop[shopi++][1] = j;
				}
			}
		}

		/**
		 * 살아남을 치킨 집의 숫자를 고정적으로 한다.
		 * 이후에 조합을 돌린다.
		 */
		int[][] survive = new int[m][2];
		johab(0, 0, survive);
		
		System.out.println(result);

		br.close();
	}

	private static void johab(int cnt, int start, int[][] sur) {
		/**남길 치킨 집이 결정 되면,*/
		if(cnt == m) {
			int sum = 0;
			int x, y;
			
			/**
			 * 각 집을 돌면서 가장 가까운 치킨집을 찾는다.
			 * 각 집의 가장 가까운 치킨집이 결정되면 그 값을 모두 더한 sum을 가진다.
			 */
			for (int i = 0; i < homei; i++) {
				int dist = 1000;
				for (int j = 0; j < m; j++) {
					x = home[i][0] - sur[j][0];
					y = home[i][1] - sur[j][1];

					x = x < 0? -x : x;
					y = y < 0? -y : y;
					
					int subDist = x + y;
					
					/**
					 * 가까운 치킨 집의 거리로 갱신한다.
					 */
					if(dist > subDist) {
						dist = subDist;
					}
				}
				
				sum += dist;
			}
			
			/**현재 가진 결과보다 sum이 작으면 갱신한다.*/
			result = result < sum ? result : sum;
			return;
		}
		
		/**
		 * index가 이미 들어간 애보다 큰 애만 들어가게 한다.
		 * 000 ---> 001
		 * 역순으로 들어가는 것을 방지한다.
		 * 012 -/-> 010
		 */
		for (int i = start; i < shopi; i++) {
			sur[cnt][0] = shop[i][0];
			sur[cnt][1] = shop[i][1];
			
			johab(cnt + 1, i + 1, sur);
		}
	}

}
