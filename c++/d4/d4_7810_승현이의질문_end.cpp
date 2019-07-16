#include<iostream>
using namespace std;

#define MAX 1000001

int T, t, n, a, result, mymax;
int numbers[MAX];

int main(void){
	cin>>T;
	for(t = 1; t <= T; ++t){
        mymax = result = 0;
        cin >> n;

        for(int i = 0; i < n; i++){
            cin >> a;
            mymax = mymax > a ? mymax : a;
            numbers[a]++;
        }

        for(int i = mymax; i > 0; i--){
            if(numbers[i] >= i){
                result = i;
                break;
            }
            numbers[i - 1] += numbers[i];
        }

        cout << "#" << t << " " << result << endl;

        for(int i = 0; i <= mymax; i++){
            numbers[i] = 0;
        }
    }
	return 0;
}