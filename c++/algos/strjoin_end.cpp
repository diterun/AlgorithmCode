#include<iostream>
using namespace std;

#define MAX 101
/*
입력을 받은 100개의 문자열(수)를 정렬한다.
제일 작은 애들부터 합친다. 근데... 합친 애들보다 큰 수가 나오면 우선 멈춘다.
그리고 다시 정렬한다.
제일 작은 애들부터 합치기...
정렬 -> 합치기 -> 정렬 ... 반복하다가
1개가 남았을 때 끝~
 */
int T, t, n, i, j, temp, mymin, result;
int strs[MAX];
int strTemp[MAX];

int main(void){
    cin >> T;

    for(t = 0; t < T; ++t){
        /* 초기화 */
        result = 0;
        for(i = 0; i < MAX; i++){
            strTemp[i] = 0;
            strs[i] = 0;
        }

        /* 입력 */
        cin >> n;
        for(i = 0; i < n; i++){
            cin >> strs[i];
        }

        for(i = 0; i < n; i++){
            for(j = i + 1; j < n; j++){
                if(strs[i] > strs[j]){
                    temp = strs[i];
                    strs[i] = strs[j];
                    strs[j] = temp;
                }
            }
        }

        for(i = 0; i < n - 1; i++){
            strs[i + 1] += strs[i];
            result += strs[i + 1];

            for(j = i + 1; j < n - 1; j++){
                if(strs[j] > strs[j + 1]){
                    temp = strs[j];
                    strs[j] = strs[j + 1];
                    strs[j + 1] = temp;
                } else {
                    break;
                }
            }
        }

        cout << result << endl;
    }

    return 0;
}