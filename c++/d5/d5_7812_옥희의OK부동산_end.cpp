#include<iostream>
using namespace std;

int n, m, a, now;
int result;

int main()
{
	int test_case;
	int T;

	cin >> T;

	for(test_case = 1; test_case <= T; ++test_case)
	{
        result = a = now = 0;

        cin >> n >> m;
        int arr[n];
        for(int i = 0; i < n; i++){
            cin >> arr[i];

            now += arr[i];
            if(now == m){
                result++;
                now -= arr[a];
                a++;
            } else if(now > m){
                while(now > m){
                    now -= arr[a];
                    a++;
                }
                if(now == m){
                    result++;
                    now -= arr[a];
                    a++;
                }
            }
        }

        cout << "#" << test_case << " " << result << endl;
	}
	return 0;
}