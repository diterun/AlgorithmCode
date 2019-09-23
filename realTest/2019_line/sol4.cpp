#include <iostream>
using namespace std;

#define MAX 20001
#define getMax(a, b) (a > b ? a : b)

int n, now, s, e, more;
int arr[MAX];

int main(void){
    more = 0;
    now = s = e = -1;

    cin >> n;
    for(int i = 0; i < n; i++){
        cin >> arr[i];
    }

    for(int i = 0; i < n; i++){
        if(arr[i] == 1){
            if(s == -1){
                s = e = now = i;
            } else {
                more = getMax(more, i - now);
                now = e = i;
            }
        }
    }

    more /= 2;

    if(s != 0){
        more = getMax(more, s);
    }
    if(e != n - 1){
        more = getMax(more, n - e - 1);
    }

    cout << more << endl;

    return 0;
}