#include<iostream>
using namespace std;

#define MAX 200001
#define getMax(a, b) (a > b ? a : b)

int A[MAX], n;

int processing(){
    int sum = 0;

    for(int i = 0; i < n; i++){
        sum += A[i];
        sum = getMax(sum, 0);
    }

    return sum;
}

// 데이터 입력
void inputData(){
    cin >> n;
    for(int i = 0; i < n; i++){
        cin >> A[i];
    }
}

int main(){
	int T, t;
	cin >> T;

	for(t = 1; t <= T; ++t){
        inputData();
        cout <<"#" << t << " " << processing() << endl;
	}

	return 0;
}