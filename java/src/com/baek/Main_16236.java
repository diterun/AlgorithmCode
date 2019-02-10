package com.baek;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main_16236 {
	static int MAX = 23;
	static int n, result;
	/**
	 * fs - 상어의 size eat - 현재 상어가 먹은 물고기 수 x, y - 현재 상어의 위치
	 */
	static int fs, eat, x, y, moveCnt;
	/** 아기 상어가 움직이는 map */
	static int[][] map = new int[MAX][MAX];
	/** 상어가 map의 그 칸을 지났는지 검사하는 변수 */
	static boolean[][] check = new boolean[MAX][MAX];
	static int[][] move = { {}, { 0, -1 }, { -1, 0 }, { 1, 0 }, { 0, 1 } };
	static String[] line;
	/** 먹을 수 있는 물고기가 있는 칸 */
	static MQ fish = new MQ();
	static MQ q = new MQ();

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/baek16236.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < MAX; i++) {
			for (int j = 0; j < MAX; j++) {
				map[i][j] = 100; // 패딩
				check[i][j] = false;
			}
		}
		fs = 2;
		eat = 0;

		n = Integer.parseInt(br.readLine());

		for (int i = 1; i <= n; i++) {
			line = br.readLine().split(" ");
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(line[j - 1]);
				if (map[i][j] == 9) {
					y = i;
					x = j;
				}
			}
		}
		map[y][x] = 0;
		check[y][x] = true;
		canMove(y, x);

		moveCnt = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			/** 한 칸 이동 했다! */
			moveCnt++;
			
			/** 갈 수 있는 곳 중에서 먹을 수 있는 물고기가 있다면, */
			if(!fish.isEmpty()) {
				int fishCnt = fish.size();
				int eaty = MAX;
				int eatx = MAX;
				
				/**
				 * 먹을 수 있는 물고기 중에서
				 * 조건 [가장 위, 그 중에서 가장 왼쪽]
				 * 에 맞는 물고기 찾기
				 */
				for (int i = 0; i < fishCnt; i++) {
					int p = fish.pop();
					int ny = p / 100;
					int nx = p % 100;
//					System.out.println("이걸 먹을까? " + ny +" " + nx);
					
					/** 가장 위 */
					if(eaty > ny) {
						eaty = ny;
						eatx = nx;
					} else if(eaty == ny) {
						/** 여러마리면 그 중에서 가장 왼쪽 */
						if(eatx > nx) {
							eaty = ny;
							eatx = nx;
						}
					}
				}
				
				/** 먹은 물고기는 지우고, 크기를 키운다. */
				map[eaty][eatx] = 0;
				eat++;
				if (fs == eat) {
					fs++;
					eat = 0;
				}
//				System.out.println(y + " " + x);
				result += moveCnt;
				moveCnt = 0;
//				System.out.println(eaty + " " + eatx + " size=" + fs + " : " + result);
//				for (int i = 1; i <= n; i++) {
//					for (int j = 1; j <= n; j++) {
//						if(i==eaty && j==eatx) {
//							System.out.print("9 ");
//						}else {
//
//							System.out.print(map[i][j] + " ");
//						}
//					}
//					System.out.println();
//				}

				/** 한 마리 먹었으니 초기화 */
				q.clean();
				cleanCheck();
				y = eaty;
				x = eatx;
				check[y][x] = true;
				
				/** 초기화 후에 자기 자신을 중심으로 다시 움직일 수 있는 곳을 찾는다. */
				canMove(y, x);
			} else {
				for (int i = 0; i < size; i++) {
					int p = q.pop();
					int ny = p / 100;
					int nx = p % 100;

					/** 먹을 수 있는 물고기가 없을 때는 BFS로 모든 곳을 돈다. */
					canMove(ny, nx);
				}
			}
		}

		System.out.println(result);

		br.close();
	}

	/** 현재 갈 수 있는 모든 곳을 검사한다. */
	private static void canMove(int y, int x) {
		for (int i = 1; i < 5; i++) {
			int dy = y + move[i][0];
			int dx = x + move[i][1];
			
			/** 갈 수 있는 곳 */
			if (map[dy][dx] <= fs && !check[dy][dx]) {
				/** 가는 곳은 true로 바꿔준다. */
				check[dy][dx] = true;
				/** 갈 수 있는 곳 중에서, 먹을 수 있는 물고기가 있는 칸. */
				if(map[dy][dx] != 0 && map[dy][dx] != fs) {
					fish.push(dy * 100 + dx);
				}
				q.push(dy * 100 + dx);
			}
		}
	}

	/** 한 마리를 먹고나면 지나왔던 모든 곳을 초기화한다. */
	private static void cleanCheck() {
		for (int i = 0; i < MAX; i++) {
			for (int j = 0; j < MAX; j++) {
				check[i][j] = false;
			}
		}
	}

	/** 그냥 개인 큐*/
	static class MQ {
		private int QMAX = 50;
		private int f, t, size = 0;
		private int[] queue = new int[QMAX];

		public boolean isEmpty() {
			return f == t;
		}

		private boolean isFull() {
			return f - QMAX == t;
		}

		public int size() {
			return size;
		}

		public void push(int n) {
			if (isFull()) {
				System.out.println(n + " 큐 꽉 찼다!!!!");
				return;
			}
			queue[f % QMAX] = n;
			f++;
			size++;
		}

		public int pop() {
			int n = -1;
			if (isEmpty()) {
				System.out.println("큐 비었다!!!!");
				return n;
			}
			n = queue[t % QMAX];
			t++;
			size--;

			return n;
		}

		public void clean() {
			f = t = size = 0;
		}
	}

}
