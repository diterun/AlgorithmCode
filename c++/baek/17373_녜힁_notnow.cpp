#include <iostream>
using namespace std;

#define MAX 100001
typedef long long ll;

int n, m, q;
int novel[MAX];
ll inputQ;


int main(void){
    scanf("%d %d %d", &n, &m, &q);
    for(int i = 0; i < n; i++){
        scanf("%d", &novel[i]);
    }
    return 0;
}