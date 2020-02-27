#include <iostream>
using namespace std;

#define MAX 51

int n, m;
int godiva[MAX][MAX];
int sumsum[MAX][MAX];

/*
한 선을 기준으로 양옆의 값이 엇비슷한 곳을 찾아서 차이가 엎치락 위치락 되는 곳 양 옆을 잘라본다...?
*/
int process(){
    return 0;
}

void makesumsum(){
    int linesum[MAX];

    for(int i = 0; i < MAX; i++){
        for(int j = 0; j < MAX; j++){
            sumsum[i][j] = 0;
        }
        linesum[i] = 0;
    }

    sumsum[0][0] = godiva[0][0];
    for(int j = 1; j < n; j++){
        sumsum[0][j] = godiva[0][j] + sumsum[0][j - 1];
    }

    for(int i = 1; i < n; i++){
        linesum[0] = godiva[i][0];
        sumsum[i][0] = linesum[0] + sumsum[i - 1][0];
        for(int j = 1; j < n ; j++){
            linesum[j] = godiva[i][j] + linesum[j - 1];
            sumsum[i][j] = linesum[j] + sumsum[i - 1][j];
        }
    }
}

void input(){
    cin >> n >> m;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            cin >> godiva[i][j];
        }
    }
}

void printSumsum(){
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            cout << sumsum[i][j] << " ";
        }
        cout << endl;
    }
}

int main(void){
    int T, t;
    cin >> T;

    for(t = 1; t <= T; t++){
        input();
        makesumsum();
        printSumsum();
        cout << "#" << t << " " << process() << endl;
    }

    return 0;
}