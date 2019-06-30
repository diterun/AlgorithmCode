#include<iostream>
using namespace std;

int T, t, n;
int **map;
int **dp;

void jump(int y, int x, int count){
    if(dp[y][x] == -1){
        dp[y][x] = count;

        int dy = y + map[y][x];
        int dx = x + map[y][x];

        if(dy < n){
            jump(dy, x, count + 1);
        }
        if(dx < n){
            jump(y, dx, count + 1);
        }
    }
}

int main(void){
    cin >> T;

    for(t = 0; t < T; ++t){
        cin >> n;
        map = new int*[n];
        for(int i = 0; i < n; i++){
            map[i] = new int[n];
        }
        dp = new int*[n];
        for(int i = 0; i < n; i++){
            dp[i] = new int[n];
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                cin >> map[i][j];
                dp[i][j] = -1;
            }
        }
        
        jump(0, 0, 0);

        if(dp[n - 1][n - 1] == -1){
            cout << "NO" << endl;
        } else {
            cout << "YES" << endl;
        }

        for(int i = 0; i < n; i++){
            delete dp[i];
        }
        delete dp;
        for(int i = 0; i < n; i++){
            delete map[i];
        }
        delete map;
    }

    return 0;
}