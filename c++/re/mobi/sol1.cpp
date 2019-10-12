#include <iostream>
#include <vector>
#include <map>
using namespace std;

long long solution(int n, vector<int> P);

int main() {
	vector<int> a = {5,7,8,2,4,6,1,8,9,10};

	printf("%d\n", solution(10, a));

	return 0;
}

long long solution(int n, vector<int> P) {
    long long answer = 0;
	int nowMin = 10000001;
	int nowCnt = 0;

	for(int i = 0; i < n; i++){
		if(nowMin > P[i]){
			answer += nowCnt * nowMin;
			nowMin = P[i];
			nowCnt = 1;
		} else {
			nowCnt++;
		}
	}

	answer += nowCnt * nowMin;

    return answer;
}