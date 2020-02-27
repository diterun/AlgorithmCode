#include<iostream>
using namespace std;
 
#define MAX 2020
#define MaxSCnt 25
 
int N, K;
int map[MAX][MAX];
int result, full;
int ms[MaxSCnt][5];
int sel[5];
int MaxSCnt2;
 
int johap(int sum, int count, int start);
void getMax();
 
int main(int argc, char** argv)
{
    int test_case;
    int T;

    scanf("%d", &T);
 
    for(test_case = 1; test_case <= T; ++test_case)
    {
        N = K = 0;
        full = result = 0;
        for (int i = 0; i < MAX; i++){
            for (int j = 0; j < MAX; j++){
                map[i][j] = 0;
            }
        }
        for (int i = 0; i < MaxSCnt; i++) {
            ms[i][0] = 0;
            ms[i][1] = 0;
            ms[i][2] = 0;
            ms[i][3] = 0;
            ms[i][4] = 0;
        }
        sel[0] = 0;
        sel[1] = 0;
        sel[2] = 0;
        sel[3] = 0;
        sel[4] = 0;
 
        scanf("%d %d", &N, &K);
        if(K == 5){
            MaxSCnt2 = 25;
        }
        else if(K == 4){
            MaxSCnt2 = 20;
        }
        else if(K == 3){
            MaxSCnt2 = 15;
        }
        else if(K == 2){
            MaxSCnt2 = 10;
        }
        else if(K == 1){
            MaxSCnt2 = 5;
        }
 
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                scanf("%d", &map[i][j]);
                full += map[i][j];
            }
        }
             
        getMax();
 
        if(K == 1) {
            result = full - ms[0][4];
        } else {
            int re = johap(0, 0, 0);
            result = full - re;
        }
 
        printf("#%d %d\n", test_case, result);
    }
    return 0;
}
 
int johap(int sum, int count, int start) {
    int subSum = 0;
     
    if(count == K) {
        for (int i = 0; i < K - 1; i++) {
            for (int j = i + 1; j < K; j++) {
                if(ms[sel[i]][0] == ms[sel[j]][0] && ms[sel[i]][1] == ms[sel[j]][1] ||
                    ms[sel[i]][0] == ms[sel[j]][2] && ms[sel[i]][1] == ms[sel[j]][3] ||
                    ms[sel[i]][2] == ms[sel[j]][0] && ms[sel[i]][3] == ms[sel[j]][1] ||
                    ms[sel[i]][2] == ms[sel[j]][2] && ms[sel[i]][3] == ms[sel[j]][3]) {
                    return 0;
                }
            }
        }
        for (int i = 0; i < K; i++) {
            subSum += ms[sel[i]][4];
        }
 
        sum = sum > subSum? sum : subSum;
        return sum;
    }
     
    for (int i = start; i < MaxSCnt2; i++) {
        sel[count] = i;
        subSum = johap(0, count + 1, i + 1);
        sum = sum > subSum? sum : subSum;
    }
    return sum;
}
 
void getMax() {
    int twoSum1, twoSum2;
     
    for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= N; j++) {
            twoSum1 = map[i][j] + map[i][j + 1];
            twoSum2 = map[i][j] + map[i + 1][j];
             
            int k;
            for (k = 0; k < MaxSCnt2; k++) {
                if(twoSum1 > ms[k][4]) {
                    break;
                }
            }
            if(k != MaxSCnt2) {
                for (int k2 = MaxSCnt - 1; k2 > k; k2--) {
                    ms[k2][0] = ms[k2 - 1][0];
                    ms[k2][1] = ms[k2 - 1][1];
                    ms[k2][2] = ms[k2 - 1][2];
                    ms[k2][3] = ms[k2 - 1][3];
                    ms[k2][4] = ms[k2 - 1][4];
                }
                ms[k][4] = twoSum1;
                ms[k][0] = i;
                ms[k][1] = j;
                ms[k][2] = i;
                ms[k][3] = j + 1;
            }
             
            for (k = 0; k < MaxSCnt2; k++) {
                if(twoSum2 > ms[k][4]) {
                    break;
                }
            }
            if(k != MaxSCnt2) {
                for (int k2 = MaxSCnt - 1; k2 > k; k2--) {
                    ms[k2][0] = ms[k2 - 1][0];
                    ms[k2][1] = ms[k2 - 1][1];
                    ms[k2][2] = ms[k2 - 1][2];
                    ms[k2][3] = ms[k2 - 1][3];
                    ms[k2][4] = ms[k2 - 1][4];
                }
                ms[k][4] = twoSum2;
                ms[k][0] = i;
                ms[k][1] = j;
                ms[k][2] = i + 1;
                ms[k][3] = j;
            }
        }
    }
}