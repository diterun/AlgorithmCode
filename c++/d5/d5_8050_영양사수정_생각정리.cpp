#include<iostream>
using namespace std;
/*
0 000  000  0
1 111  111  7
2 001  110  6
3 100  010  2
4 111  101  5
5 010  111  7
6 111  000  1
7 111  111  6
8 111  000  1
누적 xor을 하면 이렇게 된다.
구간 별로 xor해서 0 혹은 7이 되는 구간은 clear한 곳이다.

각 숫자에 맞는 pair를 정한다.
0-7, 1-6, 2-5, 3-4
각 숫자의 index를 모두 구한다.

0 - 0, 6, 8
1 - 
2 - 3
3 - 
4 - 
5 - 4
6 - 2
7 - 1, 5, 7

pair에 대해서 같은 열로 만든다. 몇 개가 있는지도 함께...
0, 7 => 6개 [0, 1, 5, 6, 7, 8]
1, 6 => 1개 [2]
2, 5 => 2개 [3, 4]
3, 4 => 0개 []

갯수에 대해서 계산은 시그마(n - 1) 같은 식이다.
그래서
0, 7은 5+4+3+2+1 로 15개
1, 6은 0
2, 5는 1 로 1개

총 올바른 구간은 16개
최대 길이는 8 - 0인 8이다


6번째 인덱스를 110으로 바꾸니까 안된다....
4 4 2 이런식으로 3번째 영양소가 부족해도 같은거로 나온다.... 폐기처분!!!!
 */
#define MAX 100001

int T, t;
int n, k, i, j, in, moreLong, clearCnt;
int zero, full;
int day[MAX];

int getMax(int a, int b);

int main()
{
	cin >> T;
	for(t = 1; t <= T; ++t)
	{
        moreLong = clearCnt = 0;
        for(i = 0; i < MAX; i++){
            day[i] = 0;
        }

        cin >> n >> k;
        zero = 0;
        full = (1 << k) - 1;

        for(j = 0; j < k; j++){
            cin >> in;
            day[0] |= (in << j);
        }

        if(day[0] == zero || day[0] == full){
            moreLong = 1;
            clearCnt++;
        }

        for(i = 1; i < n; i++){
            for(j = 0; j < k; j++){
                cin >> in;
                day[i] |= (in << j);
            }

            int now = day[i];

            if(now == zero || now == full){
                moreLong = getMax(moreLong, 1);
                clearCnt++;
            }

            for(j = i - 1; j >= 0; j--){
                now ^= day[j];
                if(now == zero || now == full){
                    moreLong = getMax(moreLong, i - j + 1);
                    clearCnt++;
                }
            }
        }

        cout << "#" << t << " " << moreLong << " " << clearCnt << endl;
	}
	return 0;
}

int getMax(int a, int b){
    return a > b ? a : b;
}