#include<iostream>
using namespace std;

int T, t, result, n, mymax;

int hap(int* fence, int left, int mid, int right){
    int l = mid;
    int r = mid + 1;
    int temp = fence[l] < fence[r] ? fence[l] : fence[r];
    int len = 2;
    int num = temp * len;
    l--; r++;

    while(l >= left && r <= right){
        len++;
        if(fence[l] < fence[r]){
            if(fence[r] < temp){
                temp = fence[r];
            }
            int sub = temp * len;
            num = num > sub ? num : sub;
            r++;
        } else {
            if(fence[l] < temp){
                temp = fence[l];
            }
            int sub = temp * len;
            num = num > sub ? num : sub;
            l--;
        }
    }

    for(; l >= left; --l){
        len++;
        if(fence[l] < temp){
            temp = fence[l];
        }
        int sub = temp * len;
        num = num > sub ? num : sub;
    }

    for(; r <= right; ++r){
        len++;
        if(fence[r] < temp){
            temp = fence[r];
        }
        int sub = temp * len;
        num = num > sub ? num : sub;
    }

    return num;
}

int getMax(int* fence, int left, int right){
    int subMax = 0;
    int mid;

    if(left < right){
        mid = (left + right) / 2;
        int a = getMax(fence, left, mid);
        int b = getMax(fence, mid + 1, right);
        int c = hap(fence, left, mid, right);

        subMax = subMax > a ? subMax : a;
        subMax = subMax > b ? subMax : b;
        subMax = subMax > c ? subMax : c;
    } else {
        subMax = fence[left];
    }

    return subMax;
}

int main(void){
    cin >> T;

    for(t = 0; t < T; ++t){
        result = mymax = 0;

        cin >> n;
        int* fence = new int[n];

        for(int i = 0; i < n; ++i){
            cin >> fence[i];
        }

        cout << getMax(fence, 0, n - 1) << endl;

        delete fence;
    }

    return 0;
}