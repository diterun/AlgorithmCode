#include <iostream>
using namespace std;

#define MAX 100001

int n, a;
int box[MAX];

int process(){
    int result = 0;
    int in = 50000, out = 100000;

    while(in > 0){
        for(int i = out, end = in * 2; i >= end; i--){
            if(box[i] > box[in]){
                result += box[in];
                box[i] -= box[in];
                box[in] = 0;
                break;
            } else if(box[i] < box[in]){
                result += box[i];
                box[in] -= box[i];
                box[i] = 0;
                out--;
            } else {
                result += box[in];
                box[i] = box[in] = 0;
                out--;
                break;
            }
        }
        in--;
    }

    for(int i = 0; i < MAX; i++){
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