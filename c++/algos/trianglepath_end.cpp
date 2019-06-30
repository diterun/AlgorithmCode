#include<iostream>
using namespace std;

int T, t, n, result;
int **map;
int **dp;

int main(void){
    cin >> T;

    for(t = 0; t < T; ++t){
        result = 0;

        cin >> n;
        map = new int*[n + 1];
        for(int i = 0; i <= n; i++){
            map[i] = new int[n + 1];
        }
        dp = new int*[n + 1];
        for(int i = 0; i <= n; i++){
            dp[i] = new int[n + 1];
        }
        for(int i = 0; i <= n; ++i){
            for(int j = 0; j <= n; ++j){
                map[i][j] = 0;
                dp[i][j] = 0;
            }
        }

        for(int i = 1; i <= n; ++i){
            for(int j = 1; j <= i; ++j){
                cin >> map[i][j];
            }
        }
        dp[1][1] = map[1][1];

        for(int i = 2; i <= n; ++i){
            for(int j = 1; j <= i; ++j){
                int a = dp[i - 1][j] + map[i][j];
                int b = dp[i - 1][j - 1] + map[i][j];

                dp[i][j] = a > b ? a : b;
            }
        }

        for(int i = 1; i <= n; ++i){
            result = result > dp[n][i] ? result : dp[n][i];
        }

        cout << result << endl;

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