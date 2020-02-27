#include <iostream>
using namespace std;

#define MAX 100001

int n, a;
int box[MAX];

int process(){
    int result = 0;

    for(int i = 1; i < 50000; i++){
        if(box[i] != 0){
            for(int j = i * 2; j < MAX; j++){
                if(box[j] != 0){
                    if(box[i] == 0){
                        break;
                    }
                    if(box[i] > box[j]){
                        box[i] -= box[j];
                        result += box[j];
                        box[j] = 0;
                    } else if(box[i] < box[j]){
                        box[j] -= box[i];
                        result += box[i];
                        box[i] = 0;
                        break;
                    } else {
                        result += box[i];
                        box[j] = box[i] = 0;
                        break;
                    }
                }
            }
        }
    }

    for(int i = 1; i < MAX; i++){
        result += box[i];
    }

    return result;
}

void initNinput(){
    for(int i = 0; i < MAX; i++){
        box[i] = 0;
    }
    cin >> n;
    for(int i = 0; i < n; i++){
        cin >> a;
        box[a]++;
    }
}

int main(void){
    initNinput();
    cout << process() << endl;

    return 0;
}