#include<iostream>
using namespace std;

#define MAX 100001
#define getMax(a, b) (a > b ? a : b)

int n, k;
int result;
int mymin, mymax;
int A[MAX];
int reflica[MAX];

bool canCuttingTree(int diff){
    int cuttingSum = 0;
    
    for(int i = 0; i < n; i++){
        reflica[i] = A[i];
    }

    for(int i = 1; i < n; i++){
        if(reflica[i] > reflica[i - 1] + diff){
            cuttingSum += reflica[i] - reflica[i - 1] - diff;
            reflica[i] = reflica[i - 1] + diff;
        }
    }

    for(int i = n - 2; i >= 0; i--){
        if(reflica[i] > reflica[i + 1] + diff){
            cuttingSum += reflica[i] - reflica[i + 1] - diff;
            reflica[i] = reflica[i + 1] + diff;
        }
    }

    if(cuttingSum > k){
        return false;
    } else {
        return true;
    }
}

void processing(int t){
    if(canCuttingTree(mymin)){
        printf("#%d %d\n", t, mymin);
        return;
    }
    bool checker = false;

    while(mymin + 1 < mymax){
        int mymid = (mymin + mymax) / 2;

        if(canCuttingTree(mymid)){
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
    mymin = mymax = 0;
    scanf("%d %d", &n, &k);
    for(int i = 0; i < n; i++){
        scanf("%d", &A[i]);
        mymax = getMax(mymax, A[i]);
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