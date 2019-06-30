#include<iostream>
using namespace std;

int T, t, n, result;
int *numbers;
int *dp;

int main(void){
    cin >> T;

    for(t = 0; t < T; ++t){
        result = 0;

        cin >> n;
        numbers = new int[n];
        dp = new int[n];

        for(int i = 0; i < n; ++i){
            cin >> numbers[i];
            dp[i] = 0;
        }

        for(int i = 0; i < n; ++i){
            int sub = 0;

            for(int j = i; j >= 0; --j){
                if(numbers[i] > numbers[j]){
                    int s = dp[j] + 1;

                    sub = sub > s ? sub : s;
                }
            }

            if(sub == 0){
                dp[i] = 1;
            } else {
                dp[i] = sub;
            }
        }

        for(int i = 0; i < n; ++i){
            result = result > dp[i] ? result : dp[i];
        }

        cout << result << endl;

        delete numbers;
        delete dp;
    }

    return 0;
}