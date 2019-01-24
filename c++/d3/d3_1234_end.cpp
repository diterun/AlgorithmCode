#include <iostream>
using namespace std;

#define MAX 101

int T, test_case;
int n, i, index;
char numbers[MAX];
char result[MAX];

int main(void){
    T = 10;

    for(test_case = 1; test_case <= T; test_case++){
        for(i = 0; i < MAX; i++){
            numbers[i] = ' ';
            result[i] = 0;
        }
        index = 0;
        cin >> n;
        for(i = 0; i < n; i++){
            cin >> numbers[i];

            if(index == 0){
                result[index++] = numbers[i];
            } else {
                if(result[index - 1] == numbers[i]){
                    index--;
                } else {
                    result[index++] = numbers[i];
                }
            }
        }
        
        cout << "#" << test_case << " ";
        for(i = 0; i < index; i++){
            cout << result[i];
        }
        cout << endl;
    }
    
    return 0;
}