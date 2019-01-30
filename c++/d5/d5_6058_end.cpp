#include<iostream>
using namespace std;

#define MAX 402

int T, test_case, k, ki, i, j, isize;
int L, N, glass;
double B, result;
/** i층 j번 와인 잔에 남아있는 와인 양 */
double wine[2][(MAX * (MAX + 1)) / 2];

int main(void)
{
    scanf("%d", &T);

	for (test_case = 1; test_case <= T; test_case++) {
        result = 0;
        for (i = 0, isize = (MAX * (MAX + 1)) / 2; i < isize; i++) {
            wine[0][i] = 0;
            wine[1][i] = 0;
        }

        scanf("%lf", &B);
        scanf("%d", &L);
        scanf("%d", &N);

        if (L == 1 && N == 1) {
            result = 250.0;
        } else {
            /** 1층에서 부터 시작 */
            wine[1][1] = B * 750.0;
				
            /** 목적하는 층 바로 전까지 진행한다.*/
            for (i = 1; i < L; i++) {
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
                for (j = 1; j <= glass; j++) {
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

        printf("#%d %lf\n",test_case, result);
    }

    return 0;
}
