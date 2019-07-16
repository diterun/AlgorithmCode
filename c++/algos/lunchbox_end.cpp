#include<iostream>
using namespace std;

#define MAX 10001

int T, t, n, i, j, temp, result, nowMicTime;
int lunchbox[MAX][2];

void merge(int left, int mid, int right);
void mergeSort(int left, int right);

int main(void){
    cin >> T;

    for(t = 0; t < T; ++t){
        /* 입력 */
        cin >> n;
        for(i = 0; i < n; i++){
            cin >> lunchbox[i][0];  // 데우는 시간
        }
        for(i = 0; i < n; i++){
            cin >> lunchbox[i][1];  // 먹는 시간
        }

        /* 먹는 시간으로 내림차순 정렬 */
        mergeSort(0, n - 1);    // merge sort 하면 84ms 나옴
        // sort 대충 하면 1436ms 나옴
        // for(i = 0; i < n; i++){
        //     for(j = i + 1; j < n; j++){
        //         if(lunchbox[i][1] < lunchbox[j][1]){
        //             temp = lunchbox[i][0];
        //             lunchbox[i][0] = lunchbox[j][0];
        //             lunchbox[j][0] = temp;
        //             temp = lunchbox[i][1];
        //             lunchbox[i][1] = lunchbox[j][1];
        //             lunchbox[j][1] = temp;
        //         }
        //     }
        // }

        /* 차례로 도시락을 데우고 먹는다. */
        for(i = 0; i < n; i++){
            /* 현재까지 전자레인지가 가동 된 시간 */
            nowMicTime += lunchbox[i][0];
            /* i번째 사람이 데우고 나서 다 먹기까지 걸리는 시간. */
            int ithTime = nowMicTime + lunchbox[i][1];

            result = result > ithTime ? result : ithTime;
        }

        cout << result << endl;

        /* 초기화 */
        result = nowMicTime = 0;
        for(i = 0; i < n; i++){
            lunchbox[i][0] = 0;
            lunchbox[i][1] = 0;
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
    int* temp0 = new int[right - left + 1];
    int* temp1 = new int[right - left + 1];

    while(l <= mid && r <= right){
        if(lunchbox[l][1] < lunchbox[r][1]){
            temp0[now] = lunchbox[r][0];
            temp1[now] = lunchbox[r][1];
            r++;
        } else {
            temp0[now] = lunchbox[l][0];
            temp1[now] = lunchbox[l][1];
            l++;
        }
        now++;
    }

    for(;l <= mid;l++){
        temp0[now] = lunchbox[l][0];
        temp1[now] = lunchbox[l][1];
        now++;
    }
    for(;r <= right;r++){
        temp0[now] = lunchbox[r][0];
        temp1[now] = lunchbox[r][1];
        now++;
    }

    for(int i = 0; i < now; i++){
        lunchbox[left + i][0] = temp0[i];
        lunchbox[left + i][1] = temp1[i];
    }

    delete temp0;
    delete temp1;
}