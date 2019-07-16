#include<iostream>
using namespace std;

#define MAX 101
/*
시계 12시 방향을 기준으로...
12시 방향 점을 포함하는 원 중에서
기준 원의 시계방향으로 가장 많이 갈 수 있는 원을 잡는다.
그리고 그 원에서 기준 원의 시계방향으로 가장 많이 간 점을 포함하는 원...
그런식으로 가다가 이미 볼 수 있는 영역을 왔을 때?????
 */
int T, t, n, i, j, temp, result;
double towers[MAX][3];

int main(void){
    cin >> T;

    for(t = 0; t < T; ++t){
        /* 입력 */
        cin >> n;
        for(i = 0; i < n; i++){
            cin >> towers[i][0] >> towers[i][1] >> towers[i][2];
        }

        cout << result << endl;

        /* 초기화 */
        result = 0;
        for(i = 0; i < n; i++){
            towers[i][0] = 0;
            towers[i][1] = 0;
            towers[i][2] = 0;
        }
    }

    return 0;
}