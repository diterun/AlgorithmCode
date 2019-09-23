#include<iostream>
using namespace std;
/*
가장 가까운 두 점 문제임
분할 정복~
혹은 line sweeper?
*/

#define MAX 200001
#define getMax(a, b) (a > b ? a : b)
#define getMin(a, b) (a < b ? a : b)

int n, k, mymin, mymax;
int W[MAX];
int S[MAX];

bool canSaveMemory(int stad){
    int j = 0;
    int nowCnt = 0;

    for(int i = 0; i < n; i++){
        if(W[i] > stad){
            nowCnt = 0;
        } else {
            nowCnt++;
            if(nowCnt >= S[j]){
                nowCnt = 0;
                j++;
                if(j == k){
                    return true;
                }
            }
        }
    }

    return false;
}

void processing(int t){
    if(canSaveMemory(mymin)){
        printf("#%d %d\n", t, mymin);
        return;
    }

    bool checker = false;
    

    while(mymin + 1 < mymax){
        int mymid = (mymin + mymax) / 2;

        if(canSaveMemory(mymid)){
            checker = true;
            mymax = mymid;
        } else {
            checker = false;
            mymin = mymid;
        }
    }

    if(checker){
        printf("#%d %d\n", t, mymax);
    } else {
        printf("#%d %d\n", t, mymin + 1);
    }
}

void inputData(){
    mymax = 0;
    mymin = MAX + 1;

    scanf("%d %d", &n, &k);
    for(int i = 0; i < n; i++){
        scanf("%d", &W[i]);
        mymax = getMax(mymax, W[i]);
        mymin = getMin(mymin, W[i]);
    }
    for(int i = 0; i < k; i++){
        scanf("%d", &S[i]);
    }
}

int main(){
	int T, t;
	cin >> T;

	for(t = 1; t <= T; ++t){
        inputData();
        processing(t);
	}

	return 0;
}