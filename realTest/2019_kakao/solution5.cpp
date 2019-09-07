#include <iostream>
#include <vector>
using namespace std;

vector<vector<int>> solution(int n, vector<vector<int>> build_frame);

int main(){
    vector<vector<int>> b1 = {{1,0,0,1},{1,1,1,1},{2,1,0,1},{2,2,1,1},{5,0,0,1},{5,1,0,1},{4,2,1,1},{3,2,1,1}};
    vector<vector<int>> b2 = {{0,0,0,1},{2,0,0,1},{4,0,0,1},{0,1,1,1},{1,1,1,1},{2,1,1,1},{3,1,1,1},{2,0,0,0},{1,1,1,0},{2,2,0,1}};

    vector<vector<int>> a1 = solution(5, b1);
    vector<vector<int>> a2 = solution(5, b2);

    for(int i = 0; i < a1.size(); i++){
        cout << a1[i][0] << " " << a1[i][1] << " " << a1[i][2] << endl;
    }
    cout << endl;
    for(int i = 0; i < a2.size(); i++){
        cout << a2[i][0] << " " << a2[i][1] << " " << a2[i][2] << endl;
    }

    return 0;
}

#define MAX 102

int d2map[MAX][MAX][2];
int x, y, a, b, bs;

vector<vector<int>> solution(int n, vector<vector<int>> build_frame) {
    for(int i = 0; i < MAX; i++){
        for(int j = 0; j < MAX; j++){
            d2map[i][j][0] = 0; // 기둥
            d2map[i][j][1] = 0; // 보
        }
    }

    bs = build_frame.size();

    for(int i = 0; i < bs; i++){
        x = build_frame[i][0];
        y = build_frame[i][1];
        a = build_frame[i][2];
        b = build_frame[i][3];

        if(b == 0){
            if(a == 0){ // 기둥 삭제
                if(d2map[y + 1][x][0] == 0){
                    if(x == 0 && d2map[y + 1][x][1] == 0){
                        d2map[y][x][0] = 0;
                    } else if(x != 0 && d2map[y + 1][x][1] == 0 && d2map[y + 1][x - 1][1] == 0){
                        d2map[y][x][0] = 0;
                    } else if(x != 0 && d2map[y + 1][x][1] == 1 && d2map[y + 1][x - 1][1] == 1){
                        d2map[y][x][0] = 0;
                    }
                }
            } else {    // 보 삭제
                if(x == 0){
                    if(!(d2map[y][x][0] == 1 && d2map[y - 1][x][0] == 0)){
                        d2map[y][x][1] = 0;
                    }
                } else if(x == 1){
                    if(d2map[y][x + 1][1] == 1){
                        if(d2map[y - 1][x + 1][0] == 1 || d2map[y - 1][x + 2][0] == 1){
                            d2map[y][x][1] = 0;
                        }
                    }
                } else {
                    if(d2map[y][x + 1][1] == 1){
                        if(d2map[y][x - 1][1] == 1){
                            if(d2map[y - 1][x + 1][0] == 1 || d2map[y - 1][x + 2][0] == 1 && d2map[y - 1][x - 1][0] == 1 || d2map[y - 1][x - 2][0] == 1){
                                d2map[y][x][1] = 0;
                            }
                        } else {
                            if(d2map[y - 1][x + 1][0] == 1 || d2map[y - 1][x + 2][0] == 1){
                                d2map[y][x][1] = 0;
                            }
                        }
                    } else {
                        if(d2map[y][x - 1][1] == 1){
                            if(d2map[y - 1][x - 1][0] == 1 || d2map[y - 1][x - 2][0] == 1){
                                d2map[y][x][1] = 0;
                            }
                        } else {
                            d2map[y][x][1] = 0;
                        }
                    }
                }
            }
            continue;
        }

        if(a == 0){ // 기둥 설치
            if(y == 0){
                d2map[y][x][0] = 1;
            } else {
                if(d2map[y - 1][x][0] == 1){
                    d2map[y][x][0] = 1;
                } else if(x > 0 && d2map[y][x - 1][1] == 1){
                    d2map[y][x][0] = 1;
                } else if(x == 0 && d2map[y][x][1] == 1){
                    d2map[y][x][0] = 1;
                }
            }
        } else {    // 보 설치
            if(d2map[y - 1][x][0] == 1){
                d2map[y][x][1] = 1;
            } else if(x < n && d2map[y - 1][x + 1][0] == 1){
                d2map[y][x][1] = 1;
            } else if(x > 0 && x < n && d2map[y][x - 1][1] == 1 && d2map[y][x + 1][1] == 1){
                d2map[y][x][1] = 1;
            }
        }
    }

    vector<vector<int>> answer;

    for(int i = 0; i <= n; i++){
        for(int j = 0; j <= n; j++){
            if(d2map[j][i][0] == 1){
                vector<int> a(3);
                a[0] = i;
                a[1] = j;
                a[2] = 0;
                answer.push_back(a);
            }
            if(d2map[j][i][1] == 1){
                vector<int> a(3);
                a[0] = i;
                a[1] = j;
                a[2] = 1;
                answer.push_back(a);
            }
        }
    }

    return answer;
}