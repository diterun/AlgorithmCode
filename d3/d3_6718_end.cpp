#include<iostream>
#include<stdio.h>

// 정답
using namespace std;

int num;

int main(int argc, char** argv)
{
	int test_case;
	int T;
    
	cin>>T;
    
	for(test_case = 1; test_case <= T; ++test_case)
	{
        scanf("%d", &num);
        int result = 5;
        
        if (num < 100) {
            result = 0;
        } else if (num < 1000) {
            result = 1;
        } else if (num < 10000) {
            result = 2;
        } else if (num < 100000) {
            result = 3;
        } else if (num < 1000000) {
            result = 4;
        }

        printf("#%d %d\n", test_case, result);

	}
	return 0;//정상종료시 반드시 0을 리턴해야합니다.
}