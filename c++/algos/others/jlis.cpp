#include<iostream>
using namespace std;

int T, t, n, m, result;
int *a, *b;
int *numbers;
int *dp;

int main(void){
    cin >> T;

    for(t = 0; t < T; ++t){
        result = 0;

        cin >> n >> m;
        a = new int[n];
        b = new int[m];

        numbers = new int[n + m];
        dp = new int[n + m];

        for(int i = 0; i < n; ++i){
            cin >> a[i];
        }
        for(int i = 0; i < m; ++i){
            cin >> b[i];
        }
        for(int i = 0; i < n + m; ++i){
            dp[i] = 0;
        }
        
        int ii = 0, jj = 0, kk = 0;
        while(ii < n && jj < m){
            if(a[ii] == b[jj]){
                numbers[kk++] = a[ii++];
                numbers[kk++] = b[jj++];
            } else if(a[ii] > b[jj]){
                numbers[kk++] = a[ii++];
            } else {
                numbers[kk++] = b[jj++];
            }
        }

        for(; ii < n;){
            numbers[kk++] = a[ii++];
        }
        for(; jj < m;){
            numbers[kk++] = b[jj++];
        }

        for(int i = 0; i < n + m; ++i){
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

        for(int i = 0; i < n + m; ++i){
            result = result > dp[i] ? result : dp[i];
        }

        cout << result << endl;

        delete numbers;
        delete dp;
    }

    return 0;
}