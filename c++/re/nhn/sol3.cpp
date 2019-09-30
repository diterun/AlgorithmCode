#include <iostream>
#include <stdio.h>
using namespace std;

int n;
int now;
bool** player;
int* candyCnt;
bool* checker;
char command;

void initial(){
    scanf("%d", &n);
    player = new bool*[n];
    for(int i = 0; i < n; i++){
        player[i] = new bool[n];
    }
    candyCnt = new int[n];
    checker = new bool[n];

    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            if(i == j){
                player[i][j] = true;
            } else {
                player[i][j] = false;
            }
        }

        candyCnt[i] = 0;
    }
}

void initChecker(){
    for(int i = 0; i < n; i++){
        checker[i] = false;
    }
}

void dfsPlayer(int playerNumber){
    for(int i = 0; i < n; i++){
        if(playerNumber != i && !checker[i] && player[playerNumber][i]){
            checker[i] = true;
            candyCnt[i]++;
            dfsPlayer(i);
        }
    }
}

int main() {
    initial();
    scanf("%c", &command);

    now = 0;
    while(true){
        scanf("%c", &command);
        // command = getchar();

        switch (command){
        case 'A':
            candyCnt[now]++;
            initChecker();
            for(int i = 0; i < n; i++){
                if(now != i && !checker[i] && player[now][i]){
                    checker[i] = true;
                    candyCnt[i]++;
                    dfsPlayer(i);
                }
            }
            now++;
            break;
        case 'J':
            if(now == 0){
                candyCnt[now + 1]++;
                initChecker();
                for(int i = 0; i < n; i++){
                    if(now + 1 != i && !checker[i] && player[now + 1][i]){
                        checker[i] = true;
                        candyCnt[i]++;
                        dfsPlayer(i);
                    }
                }
                candyCnt[n - 1]++;
                initChecker();
                for(int i = 0; i < n; i++){
                    if(n - 1 != i && !checker[i] && player[n - 1][i]){
                        checker[i] = true;
                        candyCnt[i]++;
                        dfsPlayer(i);
                    }
                }
            } else if(now == n - 1){
                candyCnt[0]++;
                initChecker();
                for(int i = 0; i < n; i++){
                    if(i != 0 && !checker[i] && player[0][i]){
                        checker[i] = true;
                        candyCnt[i]++;
                        dfsPlayer(i);
                    }
                }
                candyCnt[now - 1]++;
                initChecker();
                for(int i = 0; i < n; i++){
                    if(now - 1 != i && !checker[i] && player[now - 1][i]){
                        checker[i] = true;
                        candyCnt[i]++;
                        dfsPlayer(i);
                    }
                }
            } else {
                candyCnt[now + 1]++;
                initChecker();
                for(int i = 0; i < n; i++){
                    if(now + 1 != i && !checker[i] && player[now + 1][i]){
                        checker[i] = true;
                        candyCnt[i]++;
                        dfsPlayer(i);
                    }
                }
                candyCnt[now - 1]++;
                initChecker();
                for(int i = 0; i < n; i++){
                    if(now - 1 != i && !checker[i] && player[now - 1][i]){
                        checker[i] = true;
                        candyCnt[i]++;
                        dfsPlayer(i);
                    }
                }
            }
            now++;
            break;
        case 'Q':
            for(int i = 0; i < n; i++){
                candyCnt[i]++;
            }
            now++;
            break;
        case 'K':
            command = getchar(); // space 없애기
            command = getchar(); // 숫자

            int follow = command - '0';

            player[now][follow] = true;
            now++;
            break;
        }

        if(now == n){
            now = 0;
        }
        if(command == '\n'){
            break;
        }
    }

    for(int i = 0; i < n; i++){
        printf("%d ", candyCnt[i]);
    }
    printf("\n");

    for(int i = 0; i < n; i++){
        delete[] player[i];
    }
    delete[] player;
    delete[] candyCnt;
    delete[] checker;

	return 0;
}