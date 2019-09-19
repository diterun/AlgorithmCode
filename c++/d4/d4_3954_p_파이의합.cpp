#include<iostream>
using namespace std;

/*
에라토스테네스의 체!!!!
*/
#define MAX 1000001

int a, b;
int phi[MAX];
int memo[MAX];
bool check[MAX];

void processing(int t){
}

void inputData(){
    scanf("%d %d", &a, &b);
}

void prepare(){
    for(int i = 0; i < MAX; i++){
        phi[i] = i;
        memo[i] = 0;
        check[i] = false;
    }
}

int main(){
	int T, t;
	cin >> T;

    prepare();

	for(t = 1; t <= T; ++t){
        inputData();
        processing(t);
	}

	return 0;
}