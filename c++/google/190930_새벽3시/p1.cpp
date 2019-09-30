#include <iostream>
#include <vector>
using namespace std;
/*
4
8 2
300 100 300 300 200 100 800 500
5 3
100 100 100 100 3
7 3
10 20 40 10 10 30 30
10 2
30 30 60 60 90 90 60 60 30 30

3
0
1
2

벽의 개수는 최대 100개
*/
#define MAX 101

int T, t;
int n, k, now, diff;
int walls[MAX];

int processing(){
    now = 0;
    diff = -1;
    scanf("%d %d", &n, &k);
    for(int i = 0; i < n; i++){
        scanf("%d", &walls[i]);
        if(now != walls[i]){
            now = walls[i];
            diff++;
        }
    }

    if(diff <= k){
        return 0;
    }

    // 이때 어떻게 하지?????

    return 0;
}

void init(){
    scanf("%d", &T);
    for(int i = 0; i < MAX; i++){
        walls[i] = 0;
    }
}

int main(void){
    init();
    for(t = 1; t <= T; t++){
        printf("Case #%d: %d\n", t, processing());
    }
    return 0;
}