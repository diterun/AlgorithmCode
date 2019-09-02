#include <iostream>
#include <vector>
#include <map>
using namespace std;

int solution(vector<int> food_times, long long k);

int main(){
    vector<int> a = {3, 4, 1, 2, 5, 1};

    printf("%d\n", solution(a, 9));

    return 0;
}

#define MAX 200002

int foods[MAX][2];
int temp[MAX][2];

void mergeSort(int left, int right);
void merge(int left, int mid, int right);
void mergeSort2(int left, int right);
void merge2(int left, int mid, int right);

int solution(vector<int> food_times, long long k) {
    int answer = -1;
    int fSize = food_times.size();

    for(int i = 0; i < fSize; i++){
        foods[i][0] = food_times[i];
        foods[i][1] = i + 1;
    }

    mergeSort(0, fSize - 1);

    long long nowTime = 0;
    long long eaten = 0;

    for(int i = 0; i < fSize; i++){
        if(foods[i][0] == nowTime){
            continue;
        }

        long long eating = eaten + (fSize - i) * (foods[i][0] - nowTime);

        if(eating <= k){
            k -= eating;
        } else {
            int indexDiff = k % (fSize - i);

            for(int j = i; j < fSize; j++){
                foods[j][0] = 0;
            }

            mergeSort(i, fSize - 1);

            answer = foods[i + indexDiff][1];
            break;
        }

        nowTime = foods[i][0];
    }

    return answer;
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
    int tt = left;

    while(l <= mid && r <= right){
        if(foods[l][0] < foods[r][0]){
            temp[tt][0] = foods[l][0];
            temp[tt][1] = foods[l][1];
            tt++;
            l++;
        } else if(foods[l][0] == foods[r][0]){
            if(foods[l][1] < foods[r][1]){
                temp[tt][0] = foods[l][0];
                temp[tt][1] = foods[l][1];
                tt++;
                l++;
            } else {
                temp[tt][0] = foods[r][0];
                temp[tt][1] = foods[r][1];
                tt++;
                r++;
            }
        } else {
            temp[tt][0] = foods[r][0];
            temp[tt][1] = foods[r][1];
            tt++;
            r++;
        }
    }

    for(; l <= mid; l++){
        temp[tt][0] = foods[l][0];
        temp[tt][1] = foods[l][1];
        tt++;
    }

    for(; r <= right; r++){
        temp[tt][0] = foods[r][0];
        temp[tt][1] = foods[r][1];
        tt++;
    }

    for(int i = left; i <= right; i++){
        foods[i][0] = temp[i][0];
        foods[i][1] = temp[i][1];
    }
}
