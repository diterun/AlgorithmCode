#include <iostream>
using namespace std;

#define MAX 500001

int top[MAX];
int result[MAX];
int n, i, j, cur;

int main(void){
    scanf("%d", &n);
    cur = -1;
    for(i = 0; i < MAX; i++){
        top[i] = 0;
        result[i] = 0;
    }

    for(i = 0, j = 0; i < n; i++, j++){
        scanf("%d", &top[i]);

        while(cur != -1){
            int num = top[cur];

            if(num < top[i]){
                i--;
                n--;
                cur--;
            } else {
                result[j] = cur + 2;
            }
        }
        if(cur == -1){
            result[j] = 0;
            cur = 0;
        }
    }
}