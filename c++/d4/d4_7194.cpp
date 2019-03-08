#include <iostream>
using namespace std;

#define MAX 1000000000
int T, t;
int s, e, a, b, result, sub, temp, cnt, gaji, s1, e1;

void dfs(int s, int cnnt);

int main(){
    scanf("%d", &T);

    for(t = 1; t <= T; t++)
    {
        gaji = MAX;
        result = MAX;
        cnt = 0;

        scanf("%d %d %d %d", &s, &e, &a, &b);
        s1 = s;
        e1 = e;

        if(b == 1){
            temp = e - s;
            if(temp % a){
                printf("#%d -1\n", t);
            } else {
                printf("#%d %d\n", t, (temp / a));
            }
        } else {
            while(true){
                temp = e1 - s1;

                if(temp % a == 0){
                    sub = cnt + (temp / a);
                    gaji = gaji < sub ? gaji : sub;
                }

                s1 *= b;
                cnt++;

                if(s1 == e1){
                    gaji = gaji < cnt ? gaji : cnt;
                } else if(s1 > e1){
                    break;
                }
            }

            if(gaji == MAX){
                printf("#%d -1\n", t);
            } else {
                dfs(s, 0);
                printf("#%d %d\n", t, result);
            }
        }
    }

    return 0;
}

void dfs(int s, int cnnt){
    if(cnnt > gaji || cnnt > result){
        result = result < cnnt ? result : cnnt;
        return;
    }
    if(s == e){
        result = result < cnnt ? result : cnnt;
        return;
    }

    dfs(s * b, cnnt + 1);
    dfs(s + a, cnnt + 1);
}