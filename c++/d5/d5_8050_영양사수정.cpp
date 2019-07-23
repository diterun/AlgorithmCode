#include<iostream>
using namespace std;
#define MAX 100001

int T, t;
int n, k, i, j, l, moreLong, clearCnt;
int day[MAX][31];
int dp[MAX][31];
bool ok;

int getMax(int a, int b);

int main()
{
	cin >> T;
	for(t = 1; t <= T; ++t)
	{
        ok = true;
        moreLong = clearCnt = 0;
        for(i = 1; i < MAX; i++){
            for(j = 0; j < 31; j++){
                day[i][j] = 0;
                dp[i][j] = 0;
            }
        }

        cin >> n >> k;

        for(j = 0; j < k; j++){
            cin >> day[0][j];
            dp[0][j] = day[0][j];
            if(day[0][i] == 0){
                ok = false;
            }
        }
        if(ok){
            moreLong = 1;
            clearCnt++;
        }

        for(i = 1; i < n; i++){
            // ok = true;
            for(j = 0; j < k; j++){
                cin >> day[i][j];
                dp[i][j] = dp[i - 1][j] + day[i][j];
                // if(day[i][j] == 0){
                //     ok = false;
                // }
            }
            // if(ok){
            //     moreLong = getMax(moreLong, 1);
            //     clearCnt++;
            // }

            for(j = i - 1; j >= 0; j--){
                ok = true;
                int now = dp[i][0] - dp[j][0];

                for(l = 1; l < k; l++){
                    if(now != dp[i][l] - dp[j][l]){
                        ok = false;
                        break;
                    }
                }

                if(ok){
                    cout << i << "~" << j << endl;
                    moreLong = getMax(moreLong, i - j + 1);
                    clearCnt++;
                }
            }
        }

        cout << "#" << t << " " << moreLong << " " << clearCnt << endl;

        for(i = 0; i < n; i++){
            for(j = 0; j < k; j++){
                cout << dp[i][j] << " ";
            }
            cout << endl;
        }
	}
	return 0;
}

int getMax(int a, int b){
    return a > b ? a : b;
}