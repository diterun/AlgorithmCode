#include<iostream>
using namespace std;

#define MAX 1000001
#define p 1000000007

int T, t;
int n, result, i;
int powi[MAX];

int calPow(long long a, int pow){
    if(pow == 1){
        return a;
    }

    if(pow % 2 == 0){
        long long sub = a * a;

        if(sub >= p){
            sub = sub % p;
        }

        return calPow(sub, pow / 2);
    } else {
        int even = pow - 1;
        long long sub = a * a;

        if(sub >= p){
            sub = sub % p;
        }

        sub = calPow(sub, even / 2) * a;
        if(sub >= p){
            sub = sub % p;
        }

        return sub;
    }
}

int main(int argc, char** argv)
{
    for(i = 1; i < MAX; i++){
        powi[i] = calPow(i, i);
    }

	cin>>T;
	for(t = 1; t <= T; ++t)
	{
        result = 0;

        cin >> n;

        for(i = 1; i <= n; i++){
            result += powi[i];
            if(result >= p){
                result %= p;
            }
        }

        cout << "#" << t << " " << result << endl;
    }
	return 0;
}