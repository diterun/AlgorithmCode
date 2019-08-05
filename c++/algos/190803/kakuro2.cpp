#include<iostream>
using namespace std;

/*
답이 없다.
 */
#define MAX 21

int T, t, n, q, i, j;
int map[MAX][MAX];
int question[MAX * MAX][4];

int main(void){
    cin >> T;

    for(t = 0; t < T; ++t){
        for(i = 0; i < MAX; i++){
            for(j = 0; j < MAX; j++){
                map[i][j] = 0;
                question[i * j][0] = 0;
                question[i * j][1] = 0;
                question[i * j][2] = 0;
                question[i * j][3] = 0;
            }
        }

        cin >> n;
        for(i = 0; i < n; i++){
            for(j = 0; j < n; j++){
                cin >> map[i][j];
            }
        }

        cin >> q;
        for(i = 0; i < q; i++){
            cin >> question[i][0] >> question[i][1] >> question[i][2] >> question[i][3];
        }
    }

    return 0;
}