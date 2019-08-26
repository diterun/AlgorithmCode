#include <iostream>
#include <algorithm>
using namespace std;

#define MAX 300001

int n, q, l, r;
int numbers[MAX];
int temp[MAX];
int dp[MAX];

void quickSort(int left, int right);
void swap(int a, int b);
void mergeSort(int left, int right);
void merge(int left, int mid, int right);

int main(void){
    scanf("%d%d", &n, &q);

    for(int i = 0; i < n; i++){
        scanf("%d", &numbers[i]);
    }

    // quickSort(0, n - 1);
    // sort(numbers, numbers + (n - 1));
    mergeSort(0, n - 1);

    dp[0] = 0;
    for(int i = 1; i <= n; i++){
        dp[i] = dp[i - 1] + numbers[i - 1];
    }

    for(int i = 0; i < q; i++){
        scanf("%d %d", &l, &r);
        printf("%d\n", dp[r] - dp[l - 1]);
    }

    return 0;
}

void mergeSort(int left, int right){
    if(left < right){
        int mid = (left + right) / 2;

        mergeSort(left, mid);
        mergeSort(mid + 1, right);
        merge(left, mid, right);
    }
}

void merge(int left, int mid, int right){
    int l = left;
    int r = mid + 1;
    int ti = left;

    while(l <= mid && r <= right){
        if(numbers[l] < numbers[r]){
            temp[ti++] =  numbers[l++];
        } else {
            temp[ti++] =  numbers[r++];
        }
    }

    for(;l <= mid;){
        temp[ti++] =  numbers[l++];
    }

    for(;r <= right;){
        temp[ti++] =  numbers[r++];
    }

    for(int i = left; i <= right; i++){
        numbers[i] = temp[i];
    }
}

void quickSort(int left, int right){
    int pivot = left;
    int j = pivot;
    int i = left + 1;

    if (left < right){
        for(; i <= right; i++){
            if(numbers[i] < numbers[pivot]){
                j++;
                swap(i, j);
            }
        }
        swap(left, j);
        pivot = j;

        quickSort(left, pivot - 1);
        quickSort(pivot + 1, right);
    }
}

void swap(int a, int b){
    int temp = numbers[a];
    numbers[a] = numbers[b];
    numbers[b] = temp;
}
