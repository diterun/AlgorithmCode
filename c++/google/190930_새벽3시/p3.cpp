#include <iostream>
#include <vector>
using namespace std;
/*
3
9
-10 4 -10 8 20 30 -2 -3 7
1 4
2 4
4 3
9 4
9 8
7 5
6 7
7 9
4
-2 20 20 20
1 2
1 3
1 4
5
-5 -10 8 -7 -2
5 4
4 3
3 2
2 1

67
58
0

마을은 최대 10만개
마을을 잇는 간선 있음
마을은 B라는(음수가능) 아름다움을 가짐
등대 설치하면 아름다움 만큼 점수를 얻음
등대 마구 설치 가능, 벗뜨 모든 등대는 연결되어 있어야함
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