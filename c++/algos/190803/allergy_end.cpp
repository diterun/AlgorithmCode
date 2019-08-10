#include<iostream>
using namespace std;

/*
조합...
50개 중에 30개 어떤 음식을 먹느냐에 따라서 다르지
근데
이미 글렀지? 조합은 안돼
 */
#define MAX 51

int T, t, n, m, l, result, i, j, k;
long long foods[MAX], possible;
string friends[MAX];
string temp;

void makeOrNot(int index, int count, long long makeFood);

int main(void){
    cin >> T;

    for(t = 0; t < T; ++t){
        result = 50;
        for(i = 0; i < MAX; i++){
            friends[i] = "";
            foods[i] = 0;
            possible = 0;
        }

        cin >> n >> m;
        for(i = 0; i < n; i++){
            cin >> friends[i];
            possible |= 1 << i;
        }
        for(i = 0; i < m; i++){
            cin >> l;

            for(j = 0; j < l; j++){
                cin >> temp;

                for(k = 0; k < n; k++){
                    if(friends[k] == temp){
                        foods[i] |= (1 << k);
                        break;
                    }
                }
            }
        }

        makeOrNot(0, 0, 0);

        cout << result << endl;
    }

    return 0;
}

void makeOrNot(int index, int count, long long makeFood){
    if(count >= result){
        return;
    }
    if(index == m){
        long long itIsPossible = 0;
        int sub = 0;

        for(int i = 0; i < m; i++){
            if(makeFood & 1 << i){
                sub++;
                itIsPossible |= foods[i];
            }
        }

        if(itIsPossible == possible){
            result = result < sub ? result : sub;
        }
        return;
    }

    makeOrNot(index + 1, count + 1, makeFood | (1 << index));
    makeOrNot(index + 1, count, makeFood);
}
