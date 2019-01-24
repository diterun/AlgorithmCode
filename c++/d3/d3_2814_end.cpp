#include<iostream>
using namespace std;

#define SC 12   //spot count

int T, test_case;
int i, j, N, M, result, sub;
int spot1, spot2;
bool spot[SC][SC];
bool has[SC];

int getLongerLine(int num){
    int cnt = 1, k;
    has[num] = true;

    for(k = 1; k <= N; k++){
        if(spot[num][k] && has[k] == false){
            int c = getLongerLine(k) + 1;
            cnt = cnt > c ? cnt : c;
            has[k] = false;
        }
    }
    return cnt;
}

// 초기화
void initialize(){
    for(i = 0; i < SC; i++){
        for(j = 0; j < SC; j++){
            spot[i][j] = false;
        }
    }
    result = 0;
}

int main(void){
    cin >> T;

    for(test_case = 1; test_case <= T; test_case++){
        initialize();

        cin >> N >> M;

        for(i = 0; i < M; i++){
            cin >> spot1 >> spot2;

            spot[spot1][spot2] = true;
            spot[spot2][spot1] = true;
        }

        for(i = 1; i <= N; i++){
            for(j = 0; j < SC; j++){
                has[j] = false;
            }
            sub = getLongerLine(i);
            result = result > sub ? result : sub;
        }

        cout << "#" << test_case << " " << result << endl;
    }
    return 0;
}