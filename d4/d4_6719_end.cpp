#include<iostream>
using namespace std;

#define MAX 10001

int N, K, i, j;
int M[MAX];
int temp;

int main(int argc, char** argv)
{
	int test_case;
	int T;

	cin>>T;
	for(test_case = 1; test_case <= T; ++test_case)
	{
        double result = 0;

        cin >> N >> K;

        for(i = 0; i < N; i++){
            cin >> M[i];
        }

        for(i = 0; i < N; i++){
            for(j = i; j < N; j++){
                if(M[i] < M[j]){
                    temp = M[i];
                    M[i] = M[j];
                    M[j] = temp;
                }
            }
        }

        for(i = K - 1; i >= 0; i--){
            result = (result + M[i]) / 2;
        }

        cout << "#" << test_case << " " << result << endl;

        for(i = 0; i < MAX; i++){
            M[i] = 0;
        }
    }
	return 0;
}