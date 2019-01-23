#include<iostream>

using namespace std;
/*
오델로 게임!
원하는 오델로 판을 만들기까지 걸리는 횟수!

n*n 크기 (n은 짝수)
1<=n<=1000
*/
#define MAX 1001;

int n, i, j;
char map[MAX][MAX];
char gaol[MAX][MAX];

bool isSame(){
    for(i = 0; i < n; i++){
        for(j = 0; j < n; j++){
            if(map[i][j] != gaol[i][j]){
                return false;
            }
        }
    }

    return true;
}

void initialize(){
    for(i = 0; i < MAX; i++){
        for(j = 0; j < MAX; j++){
            map[i][j] = 'W';
            gaol[i][j] = ' ';
        }
    }
}

int main(int argc, char** argv)
{
	int test_case;
	int T;

	cin>>T;

	for(test_case = 1; test_case <= T; ++test_case)
	{
        cin >> n;

        for(i = 0; i < n; i++){
            fgets(gaol[i]);
        }

        for(int k = 0; k < 100; k++){
            if(getCnt(k)){
                
            }
        }
	}
	return 0;
}