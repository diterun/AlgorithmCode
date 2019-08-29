#include <iostream>
using namespace std;

#define MAX 14
#define getMin(a, b)(a < b ? a : b)

int T, t, n, result;
int iNum[MAX];

void shuflling(int cnt, int type, int nums[]);
bool checker(int nums[]);

int main(void){
    scanf("%d", &T);

    for(t = 1; t <= T; t++){
        result = 10;
        for(int i = 0; i < MAX; i++){
            iNum[i] = 0;
        }

        scanf("%d", & n);
        for(int i = 0; i < n; i++){
            scanf("%d", &iNum[i]);
        }

        if(checker(iNum)){
            printf("#%d 0\n", t);
            continue;
        }

        for(int i = 1; i < n; i++){
            shuflling(0, i, iNum);
        }

        if(result == 10){
            printf("#%d -1\n", t);
        } else {
            printf("#%d %d\n", t, result);
        }
    }

    return 0;
}

void shuflling(int cnt, int type, int nums[]){
    if(checker(nums)){
        result = getMin(result, cnt);
        return;
    }

    int temp[MAX];

    //swap이 어렵네
    // if(type < n / 2){
    //     for(int i = n / 2 - type; i < n / 2 + type; i++){
    //         if(i < n / 2){
    //             temp[i] = temp[i + type];
    //         } else {
    //             temp[i] = temp[i - type];
    //         }
    //     }
    // } else {
    //     for(int i = 0; i < n; i++){
    //         int num = 0;
    //         if(i < n / 2){
    //             num = temp[i + type];
    //         } else {

    //         }
    //         temp[i] = num;
    //     }
    // }

    for(int i = 1; i < n; i++){
        shuflling(cnt + 1, i, nums);
    }
}

bool checker(int nums[]){
    if(nums[0] == 1){
        for(int i = 0; i < n - 1; i++){
            if(nums[i] + 1 != nums[i + 1]){
                return false;
            }
        }
        return true;
    } else if(nums[0] == n){
        for(int i = 0; i < n - 1; i++){
            if(nums[i] - 1 == nums[i + 1]){
                return false;
            }
        }
        return true;
    }

    return false;
}