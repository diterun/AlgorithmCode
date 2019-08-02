#include<iostream>
using namespace std;

#define MAX 11

int T, t, h, w, r, c, i, j, result;
char map[MAX][MAX];
char block[MAX][MAX];

int main(void){
    cin >> T;

    for(t = 0; t < T; ++t){
        result = 0;
        for(i = 0; i < MAX; i++){
            for(j = 0; j < MAX; j++){
                map[i][j] = '#';
                block[i][j] = '.';
            }
        }

        /* 입력 */
        cin >> h >> w >> r >> c;
        for(i = 0; i < h; i++){
            cin >> map[i];
        }
        for(i = 0; i < r; i++){
            cin >> block[i];
        }

        // for(i = 0; i < h; i++){
        //     for(j = 0; j < w; j++){
        //         cout << map[i][j];
        //     }
        //     cout<< endl;
        // }

        cout << result << endl;
    }

    return 0;
}