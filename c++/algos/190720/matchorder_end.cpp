#include<iostream>
using namespace std;

#define MAX 101

int T, t, n, i, j, result;
int russiaTeam[MAX];
int koreaTeam[MAX];

int main(void){
    cin >> T;

    for(t = 0; t < T; ++t){
        /* 입력 */
        cin >> n;
        for(i = 0; i < n; i++){
            cin >> russiaTeam[i];
        }
        for(i = 0; i < n; i++){
            cin >> koreaTeam[i];
        }

        /* 오름차순 정렬 */
        for(i = 0; i < n; i++){
            for(j = i + 1; j < n; j++){
                int temp = 0;

                if(russiaTeam[i] > russiaTeam[j]){
                    temp = russiaTeam[i];
                    russiaTeam[i] = russiaTeam[j];
                    russiaTeam[j] = temp;
                }
                if(koreaTeam[i] > koreaTeam[j]){
                    temp = koreaTeam[i];
                    koreaTeam[i] = koreaTeam[j];
                    koreaTeam[j] = temp;
                }
            }
        }

        /* 한 칸씩 옆으로 가면서 */
        for(i = 0; i < n; i++){
            int sub = 0;

            /* 전체를 비교해서 이기는 경우를 센다. */
            for(j = 0; j < n; j++){
                if(russiaTeam[j] <= koreaTeam[(j + i) % n]){
                    sub++;
                }
            }

            result = result > sub ? result : sub;
        }

        cout << result << endl;

        /* 초기화 */
        result = 0;
        for(i = 0; i < n; i++){
            russiaTeam[i] = 0;
            koreaTeam[i] = 0;
        }
    }

    return 0;
}