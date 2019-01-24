#include <iostream>
using namespace std;

int t, test_case;
int n, c, i, j;
int numbers[7];
int maxIndexList[7];

bool hasNotEquals(int num){
    for(i = 0; i < num; i++){
        for(j = 0; j < num; j++){
            if(i != j && numbers[i] == numbers[j]){
                return false;
            }
        }
    }

    return true;
}

int changeIndex(){
    cin >> n >> c;
    int index = 0;
    
    while(n/10){
        numbers[index++] = n % 10;
        n = n / 10;
    }
    numbers[index] = n;
    
    for(i = index; i > 0; i--){
        int max = 0;
        int l = 0;
        int moreLess = 0;

        for(j = 0; j < i; j++){
            if(max < numbers[j]){
                max = numbers[j];
                l = 0;
                maxIndexList[l] = j;
            } else if (max == numbers[j]){
                maxIndexList[++l] = j;
            }
        }

        for(j = i - 1; j >= 0 && moreLess < c - 1 && moreLess < l; j--){
            if(numbers[i] > numbers[j]){
                moreLess++;
            }
        }

        if(numbers[i] < numbers[maxIndexList[moreLess]]){
            int temp = numbers[i];
            numbers[i] = numbers[maxIndexList[moreLess]];
            numbers[maxIndexList[moreLess]] = temp;
            
            c--;
        }
        
        if(c == 0){
            break;
        }
    }
    
    if(hasNotEquals(index)){
        while(c){
            int temp = numbers[0];
            numbers[0] = numbers[1];
            numbers[1] = temp;
            c--;
        }
    }
    
    int returnResult = 0;
    
    for(i = index; i >= 0; i--){
        returnResult *= 10;
        returnResult += numbers[i];
    }
    
    return returnResult;
}

void initialize(){
    for(i = 0; i < 7; i++){
        numbers[i] = 0;
    }
}

int main(void){
    cin >> test_case;
    
    t = 0;
    while(test_case != t){
        int result = changeIndex();
        
        cout << "#" << ++t << " " << result << endl;
        
        initialize();
    }
    
    return 0;
}