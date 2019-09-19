#include<iostream>
using namespace std;

/*
inputString 길이는 최대 20만

string에서 두 번 이상 등장하는 문자열 중에서
제일 긴 문자열의 길이는?

ababa
aba가 제일 긴 문자열이여서 3이 정답!
sabcabcfabc
abc가 제일 긴 문자열이여서 3이 정답!
*/

int strLen;
string inputString;
int result;

void processing(int t){
    //
    printf("#%d %d\n", t, result);
}

void inputData(){
    result = 0;
    scanf("%d", &strLen);
    cin >> inputString;
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