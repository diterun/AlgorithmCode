#include<iostream>
using namespace std;

/*
inputString 길이는 최대 50만
inputWord 길이는 최대 10만

string 안에 word가 몇 번 들어갈까염??

ababa
aba
라면, 2번 들어간 것이다~
*/

string inputString;
string inputWord;
int result;

void processing(int t){
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