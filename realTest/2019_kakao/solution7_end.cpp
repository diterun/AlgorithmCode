#include <iostream>
#include <vector>
using namespace std;

int solution(vector<vector<int>> board);

int main(){
    vector<vector<int>> b1 = {{0,0,0,1,1},{0,0,0,1,0},{0,1,0,1,1},{1,1,0,0,1},{0,0,0,0,0}};

    cout << solution(b1) << endl;
    return 0;
}

#define MAX 104

int mymap[MAX][MAX];
int dp[MAX][MAX][2];
int n;
int answer;

void dfs(int y, int x, int type, int cnt);
int getMin(int a, int b);

int solution(vector<vector<int>> board) {
    for(int i = 0; i < MAX; i++){
        for(int j = 0; j < MAX; j++){
            mymap[i][j] = 1;
            dp[i][j][0] = 100000;
            dp[i][j][1] = 100000;
        }
    }
    n = board.size();

    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            mymap[i + 1][j + 1] = board[i][j];
        }
    }

    answer = 100000;
    dp[1][1][1] = 0;
    dfs(1, 1, 1, 0);
    return answer;
}

void dfs(int y, int x, int type, int cnt){
    if(y == n && x == n - 1 && type == 1){
        answer = getMin(answer, cnt);
        return;
    }
    if(y == n - 1 && x == n && type == 0){
        answer = getMin(answer, cnt);
        return;
    }
    if(cnt >= answer){
        return;
    }

    if(type == 1){
        if(mymap[y][x + 2] == 0 && dp[y][x + 1][1] > cnt + 1){
            dp[y][x + 1][1] = cnt + 1;
            dfs(y, x + 1, 1, cnt + 1);
        }
        if(mymap[y][x - 1] == 0 && dp[y][x - 1][1] > cnt + 1){
            dp[y][x - 1][1] = cnt + 1;
            dfs(y, x - 1, 1, cnt + 1);
        }
        if(mymap[y + 1][x] == 0 && mymap[y + 1][x + 1] == 0){
            if(dp[y + 1][x][1] > cnt + 1){
                dp[y + 1][x][1] = cnt + 1;
                dfs(y + 1, x, 1, cnt + 1);
            }
            if(dp[y][x][0] > cnt + 1){
                dp[y][x][0] = cnt + 1;
                dfs(y, x, 0, cnt + 1);
            }
            if(dp[y][x + 1][0] > cnt + 1){
                dp[y][x + 1][0] = cnt + 1;
                dfs(y, x + 1, 0, cnt + 1);
            }
        }
        if(mymap[y - 1][x] == 0 && mymap[y - 1][x + 1] == 0){
            if(dp[y - 1][x][1] > cnt + 1){
                dp[y - 1][x][1] = cnt + 1;
                dfs(y - 1, x, 1, cnt + 1);
            }
            if(dp[y - 1][x][0] > cnt + 1){
                dp[y - 1][x][0] = cnt + 1;
                dfs(y - 1, x, 0, cnt + 1);
            }
            if(dp[y - 1][x + 1][0] > cnt + 1){
                dp[y - 1][x + 1][0] = cnt + 1;
                dfs(y - 1, x + 1, 0, cnt + 1);
            }
        }
    } else {
        if(mymap[y + 2][x] == 0 && dp[y + 1][x][0] > cnt + 1){
            dp[y + 1][x][0] = cnt + 1;
            dfs(y + 1, x, 0, cnt + 1);
        }
        if(mymap[y - 1][x] == 0 && dp[y - 1][x][0] > cnt + 1){
            dp[y - 1][x][0] = cnt + 1;
            dfs(y - 1, x, 0, cnt + 1);
        }
        if(mymap[y][x + 1] == 0 && mymap[y + 1][x + 1] == 0){
            if(dp[y][x + 1][0] > cnt + 1){
                dp[y][x + 1][0] = cnt + 1;
                dfs(y, x + 1, 0, cnt + 1);
            }
            if(dp[y][x][1] > cnt + 1){
                dp[y][x][1] = cnt + 1;
                dfs(y, x, 1, cnt + 1);
            }
            if(dp[y + 1][x][1] > cnt + 1){
                dp[y + 1][x][1] = cnt + 1;
                dfs(y + 1, x, 1, cnt + 1);
            }
        }
        if(mymap[y][x - 1] == 0 && mymap[y + 1][x - 1] == 0){
            if(dp[y][x - 1][0] > cnt + 1){
                dp[y][x - 1][0] = cnt + 1;
                dfs(y, x - 1, 0, cnt + 1);
            }
            if(dp[y][x - 1][1] > cnt + 1){
                dp[y][x - 1][1] = cnt + 1;
                dfs(y, x - 1, 1, cnt + 1);
            }
            if(dp[y + 1][x - 1][1] > cnt + 1){
                dp[y + 1][x - 1][1] = cnt + 1;
                dfs(y + 1, x - 1, 1, cnt + 1);
            }
        }
    }
}

int getMin(int a, int b){
    return a < b ? a : b;
}