#include<iostream>
using namespace std;

#define MAX 1002

unsigned int N, result, cnt;
unsigned int numList[MAX];
unsigned int dp[MAX];

void initialize(){
    for(int i = 0; i < MAX; i++){
        numList[i] = 0;
        dp[i] = 0;
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

        cin >> N;
        for (int i = 0; i < N; i++) {
            cin >> numList[i];	// 수열 입력
        }

        for(int i = 0; i < N; i++){
            cnt = 0;
            for(int j = 0; j < i; j++){
                if(numList[i] >= numList[j]){
                    cnt = cnt > dp[j] ? cnt : dp[j];
                }
            }

            dp[i] = cnt + 1;
        }

        for(int i = 0; i < N; i++){
            result = result > dp[i] ? result : dp[i];
        }

        cout << "#" << test_case << " " << result << endl;
	}
	return 0;
}