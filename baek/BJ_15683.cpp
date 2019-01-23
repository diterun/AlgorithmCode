#include <iostream>
using namespace std;

int N, M;
int map[10][10];

int main(void){
    register int i, j;

    for(i = 0; i < 10; i++){
        for(j = 0; j < 10; j++){
            map[i][j] = 6;
        }
    }

    cin >> N >> M;

    for(i = 0; i < N; i++){
        for(j = 0; j < M; j++){
            cin >> map[i][j];
        }
    }

    for(i = 0; i < N; i++){
        for(j = 0; j < M; j++){
            cout << map[i][j] << " ";
        }
        cout<<endl;
    }

    return 0;
}