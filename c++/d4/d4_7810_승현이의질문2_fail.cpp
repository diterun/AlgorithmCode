#include<iostream>
using namespace std;

#define MAX 500001

int T, t, n, pre;
int numbers[MAX];
int temp[MAX];
int more[MAX];

void mergeSort(int left, int right);
void merge(int left, int mid, int right);

int main(void){
	cin>>T;
	for(t = 1; t <= T; ++t){
        pre = -1;
        cin >> n;

        for(int i = 0; i < n; i++){
            cin >> numbers[i];
        }

        mergeSort(0, n - 1);

        for(int i = 0; i < n; i++){
            if(numbers[i] != pre){
                int temp = n - i;

                if(numbers[i] <= n){
                    for(int j = numbers[i]; j >= 0; j--){
                        if(more[j] != 0){
                            break;
                        }

                        more[j] = temp;
                    }
                } else {
                    for(int j = numbers[i]; j >= 0; j--){
                        if(more[j] != 0){
                            break;
                        }

                        more[j] = temp;
                    }
                    break;
                }
            }

            pre = numbers[i];
        }

        for(int i = n; i >= 0; i--){
            if(more[i] >= i){
                cout << "#" << t << " " << i << endl;
                break;
            }
        }
        
        for(int i = 0; i <= n; i++){
            numbers[i] = 0;
            more[i] = 0;
        }
    }
	return 0;
}

void mergeSort(int left, int right){
    if(left >= right){
        return;
    }

    int mid = (left + right) / 2;

    mergeSort(left, mid);
    mergeSort(mid + 1, right);
    merge(left, mid, right);
}
void merge(int left, int mid, int right){
    int l = left;
    int r = mid + 1;
    int now = 0;

    while(l <= mid && r <= right){
        if(numbers[l] > numbers[r]){
            temp[now++] = numbers[r++];
        } else {
            temp[now++] = numbers[l++];
        }
    }

    for(; l <= mid; l++){
        temp[now++] = numbers[l];
    }
    for(; r <= right; r++){
        temp[now++] = numbers[r];
    }

    for(int i = 0; i < now; i++){
        numbers[left + i] = temp[i];
    }
}