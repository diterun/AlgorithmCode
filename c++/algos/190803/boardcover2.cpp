#include<iostream>
using namespace std;

#define MAX 11

int T, t, n, i, j, temp, result;
double towers[MAX][3];

int main(void){
    cin >> T;

    for(t = 0; t < T; ++t){
        result = 0;

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