#include <iostream>
using namespace std;

#define getMax(a, b) (a > b ? a : b)
#define MAX 16

int n;
int p[MAX];
bool arrTree[MAX][MAX];
int result;

void backdfs(int now, int pay){
    result = getMax(result, pay);

    for(int i = now; i < n; i++){
        if(arrTree[now][i]){
            backdfs(i, pay + p[i]);
        }
    }
}

void process(){
    for(int i = 0; i < n; i++){
        if(!arrTree[0][i]){
            backdfs(i, p[i]);
        }
    }
}

void input(){
    cin >> n;
    for(int i = 0; i < n; i++){
        int ti, pi;

        cin >> ti >> pi;

        if(n - i >= ti){
            p[i] = pi;
        }

        for(int j = i + ti; j < n; j++){
            arrTree[i][j] = true;
        }
    }
}

void init(){
    n = result = 0;
    for(int i = 0; i < MAX; i++){
        for(int j = 0; j < MAX; j++){
            arrTree[i][j] = false;
        }
        p[i] = 0;
    }
}

int main(void){
    init();
    input();
    process();
    cout << result << endl;

    return 0;
}