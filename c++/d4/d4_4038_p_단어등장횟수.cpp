#include<iostream>
#include<limits.h>
using namespace std;

/*
inputString 길이는 최대 50만
inputWord 길이는 최대 10만

string 안에 word가 몇 번 들어갈까염??

ababa
aba
라면, 2번 들어간 것이다~
*/
typedef unsigned long long ull;

string inputString;
string inputWord;
int result;
ull mod = ULLONG_MAX;
int d = 259;

void processing(int t){
    int wordLen = inputWord.length();
    cout << wordLen << endl;
    // 
    printf("#%d %d\n", t, result);
}

void inputData(){
    result = 0;
    cin >> inputString >> inputWord;
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