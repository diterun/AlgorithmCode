#include<iostream>
using namespace std;
/*
2이상의 어떤 정수 N

if(루트(n)){
    n = 루트(n);
} else {
    n = n + 1;
}

n 이 2가 될 때 까지 걸리는 횟수 출력
*/
#define MAX 1000000

int i;
long long n;
long long result;
bool isEqual;
long long jegob[MAX];
int myMin, myMax, mid;

int main(int argc, char** argv)
{
	int test_case;
	int T;

    for(i = 0; i < MAX; i++){
        jegob[i] = (long long)i * (long long)i;
    }

	cin>>T;

	for(test_case = 1; test_case <= T; ++test_case)
	{
        result = 0;
        cin >> n;

        while(true){
            isEqual = false;

            if(n == 2){
                break;
            }

            myMin = 0;
            myMax = MAX - 1;
            while(myMin < myMax - 1){
                mid = (myMin + myMax) / 2;

                if(n < jegob[mid]){
                    myMax = mid;
                } else if (n > jegob[mid]){
                    myMin = mid;
                } else {
                    isEqual = true;
                    break;
                }
            }

            if(isEqual){
                result++;
                n = (long long)mid;
            } else {
                result += (jegob[myMax] - n);
                n = jegob[myMax];
            }
        }

        cout << "#" << test_case << " " << result << endl;
	}
	return 0;
}