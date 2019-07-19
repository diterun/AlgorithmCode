#include<iostream>
using namespace std;

#define MAX 100001

int T, t;
int n, k, i, j, moreLong, clearCnt;
int day[MAX][31];

int getMin(int a, int b);
int getMax(int a, int b);

int main()
{
	cin >> T;
	for(t = 1; t <= T; ++t)
	{
        moreLong = clearCnt = 0;

        cin >> n >> k;

        for(i = 0; i < n; i++){
            for(j = 0; j < k; j++){
                cin >> day[i][j];
            }
        }

        cout << "#" << t << " " << moreLong << " " << clearCnt << endl;
	}
	return 0;
}

int getMin(int a, int b){
    return a < b ? a : b;
}
int getMax(int a, int b){
    return a > b ? a : b;
}