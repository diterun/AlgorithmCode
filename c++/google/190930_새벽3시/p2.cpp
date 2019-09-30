#include <iostream>
#include <vector>
using namespace std;
/*
2
4 100
4 80 90 100 5
1 90
1 80
3 80 90 100
3 30
4 10 11 12 13
4 10 11 12 13
5 25 26 27 28 29

7
4

1<=T<=100
1<=s<=1000
1<=c<=5
1<=a<=s
2<=n<=50000
*/

int T, t;
int n, s, now, diff;
int employee[50001][6];
vector<int> skills[1001];

int processing(){
    int result = 0;

    scanf("%d %d", &n, &s);
    for(int i = 0; i < n; i++){
        scanf("%d", &employee[i][0]);
        for(int j = 1; j <= employee[i][0]; j++){
            scanf("%d", &employee[i][j]);
            skills[employee[i][j]].push_back(i);
        }
    }

    for(int i = 0; i < n; i++){
        int im[50001] = {0, };
        int canNot = 0;

        for(int j = 1; j <= employee[i][0]; j++){
            int skillNum = employee[i][j];
            int skillSize = skills[skillNum].size();
            for(int k = 0; k < skillSize; k++){
                im[skills[skillNum][k]]++;
                if(im[skills[skillNum][k]] == employee[i][0]){
                    canNot++;
                }
            }
        }
        
        result += n - canNot;
    }

    return result;
}

void init(){
    scanf("%d", &T);
    for(int i = 0; i < 1001; i++){
        skills[i].clear();
    }
}

int main(void){
    init();
    for(t = 1; t <= T; t++){
        printf("Case #%d: %d\n", t, processing());
    }
    return 0;
}