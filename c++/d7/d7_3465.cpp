#include<iostream>
using namespace std;
/*
부하 연봉 -> 상사 연봉 증가
연봉이 증가 된 cnt 출력

다슬이는 기본
이후 직원 N명

연봉 (다슬)
연봉 상사
연봉 상사
...

1 <= N <= 300000
1 <= 연봉 <= 1,000,000,000

자신의 상사들을 기억하고 //<vector>처럼 해야겠다...
자신 보다 연봉이 높은 상사의 컷이 어딘지 기억해 놓는다.
만약 신입의 연봉이 자신보다 높다면,
자신의 상사 중에서 자신보다 높은 상사를 제외하고
모든 상사들을 돌며 연봉을 높이고 그 상사들의 숫자 만큼 결과를 높인다.
그 이후에는 자신보다 연봉이 높은 상사로 가거나 다슬이에게 간다.
*/
#define MAX 300001

int N, result, money, up;
int worker[MAX][2];

void getUpgradeCnt(){
    cin >> N;
    cin >> worker[0][0];
    worker[0][1] = -1;

    for(int i = 1; i <= N; i++){
        scanf("%d", &worker[i][0]);
        scanf("%d", &worker[i][1]);

        money = worker[i][0];
        up = worker[i][1];

        while(up != -1){
            if(worker[up][0] < money){
                result++;
                worker[up][0] = money;
            } else {
                break;
            }

            up = worker[up][1];
        }
    }
}

void initialize(){
    for(int i = 0; i < MAX; i++){
        worker[i][0] = 0;
        worker[i][1] = 0;
    }
    result = 0;
}

int main(int argc, char** argv)
{
	int test_case;
	int T;
    cout<< endl;

	cin>>T;

	for(test_case = 1; test_case <= T; ++test_case)
	{
        initialize();

        getUpgradeCnt();

        cout << "#" << test_case << " " << result << endl;
	}
	return 0;
}