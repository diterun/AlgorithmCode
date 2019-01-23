#include <iostream>
using namespace std;

#define MAX 101

int T, test_case;
int n, i, j;
char numbers[MAX];

int main(void){
    T = 10;

    for(test_case = 1; test_case <= T; test_case++){
        for(i = 0; i < MAX; i++){
            numbers[i] = ' ';
        }
        cin >> n;
        for(i = 0; i < n; i++){
            cin >> numbers[i];

            if(i != 0){
                if(numbers[i - 1] == numbers[i]){
                    i -= 2;
                    n -= 2;
                }
            }
        }
        
        cout << "#" << test_case << " ";
        for(j = 0; j < i; j++){
            cout << numbers[j];
        }
        cout << endl;
    }
    
    return 0;
}