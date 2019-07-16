#include<iostream>
using namespace std;

#define MAX 11

int T, t, n, i, j, a, result;
int numbers[MAX];

int main(void)
{
	cin>>T;
	for(t = 1; t <= T; ++t)
	{
        result = 0;
        for(i = 0; i < MAX; i++){
            numbers[i] = 0;
        }
        cin >> n;

        for(i = 0; i < n; i++){
            cin >> a;
            numbers[a]++;
        }

        for(i = MAX - 1; i > 0; i--){
            if(numbers[i] == i){
                result = i;
                break;
            }
            numbers[i - 1] += numbers[i];
        }

        cout << "#" << t << " " << result << endl;
    }
	return 0;
}