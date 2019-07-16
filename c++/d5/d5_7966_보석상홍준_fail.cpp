#include<iostream>
using namespace std;

// 23개 중에서 5개... 15개... 18개 순으로 나아짐
// 5개 : 별 조건 없이 for문으로 돌렸을 때, (그냥 방법론 자체가 틀렸던것 같기도 함)
// 15개 : 쓰고 안쓰고로 나뉘는데 안 쓰는 경우 남은 가치로 답을 내릴 수 없을 때는 포기
// 18개 : 쓸 때에 가격이 넘어 버리면 포기
// 20개 : result가 0이 되면 끝내기

int T, t;
int n, x, k, money, result, i, j, myJewel;
/* 가격 */
int minPrice, maxPrice, sumPrice;
/* 가치 */
int minAesth, maxAesth, sumAesth;
int jewelry[32][2];
double jewelryAP[32];

int getMin(int a, int b);
int getMax(int a, int b);
void myBubbleSort();

void getMinPrice(int index, int totalAesth, int totalPrice, int otherAesth){
    // cout << index << " : " << totalAesth << ", " << totalPrice << " and " << otherAesth << endl;
    if(totalAesth >= x){
        result = getMin(result, totalPrice - money);
        // cout << "END : " << result << ", " << totalPrice << " " << totalAesth << endl;
        return;
    }
    if(index == n || result == 0){
        return;
    }

    /* 현재 보석을 추가하면 총 가격이 이전의 result보다 큰 경우에는 추가하지 않는다. */
    if(totalPrice + jewelry[index][0] - money < result){
        getMinPrice(index + 1, totalAesth + jewelry[index][1], totalPrice + jewelry[index][0], otherAesth - jewelry[index][1]);
    }
    /* 현재 보석을 추가 안하면 총 가치와 남은 가치의 합이 기준치는 넘지 않으면 빼는 경우는 없다. */
    if(totalAesth + otherAesth - jewelry[index][1] >= x){
        getMinPrice(index + 1, totalAesth, totalPrice, otherAesth - jewelry[index][1]);
    }
}

int main(){
	cin >> T;
	for(t = 1; t <= T; ++t){
        money = 0;
        sumPrice = sumAesth = maxPrice = maxAesth = 0;
        minPrice = minAesth = 30000001;
        result = 0;

        for(i = 0; i < 32; i++){
            jewelry[i][0] = 0;
            jewelry[i][1] = 0;
            jewelryAP[i] = 0;
        }

        cin >> n;
        /* 가격 입력 */
        for(i = 0; i < n; i++){
            cin >> jewelry[i][0];

            minPrice = getMin(minPrice, jewelry[i][0]);
            maxPrice = getMax(maxPrice, jewelry[i][0]);
            sumPrice += jewelry[i][0];
        }
        /* 가치 입력 */
        for(i = 0; i < n; i++){
            cin >> jewelry[i][1];

            minAesth = getMin(minAesth, jewelry[i][1]);
            maxAesth = getMax(maxAesth, jewelry[i][1]);
            sumAesth += jewelry[i][1];

            jewelryAP[i] = (double)jewelry[i][1] / (double) jewelry[i][0];
        }

        cin >> x;

        cin >> k;
        /* 내가 가진 보석이 있다면 바로 내가 가진 돈으로 환산한다. */
        for(i = 0; i < k; i++){
            cin >> myJewel;
            money += jewelry[myJewel - 1][0];
        }

        /* 보석의 총 가치가 원하는 가치보다 낮거나 같은 경우 */
        if(x >= sumAesth){
            if(x == sumAesth){
                cout << "#" << t << " " << (sumPrice - money) << endl;
            } else {
                cout << "#" << t << " -1" << endl;
            }

            continue;
        }

        /* 원하는 가치가 보석의 최소 가치보다 낮은 경우 */
        if(x <= minAesth){
            if(minPrice < money){
                cout << "#" << t << " 0" << endl;
            } else {
                cout << "#" << t << " " << (minPrice - money) << endl;
            }

            continue;
        }

        myBubbleSort();
        for(i = 0; i < n; i++){
            cout <<"("<< jewelry[i][0] << ", " << jewelry[i][1] << ") ";
        }
        cout<<endl;

        int initAesth = 0;
        for(i = 0; i < n; i++){
            result += jewelry[i][0];
            initAesth += jewelry[i][1];
            if(initAesth >= x){
                break;
            }
        }

        cout << result << endl;

        /* (현재 인덱스, 사려는 보석, 총 가치, 총 가격, 남은 것들의 총 가치) */
        getMinPrice(0, 0, 0, sumAesth);

        cout << "#" << t << " " << result << endl;
	}
	return 0;
}

int getMin(int a, int b){
    if(b < 0){
        return 0;
    }

    return a < b ? a : b;
}

int getMax(int a, int b){
    return a > b ? a : b;
}

void myBubbleSort(){
    int temp;
    double temp2;

    for(i = 0; i < n; i++){
        for(j = i + 1; j < n; j++){
            if(jewelryAP[i] < jewelryAP[j]){
                temp = jewelry[i][0];
                jewelry[i][0] = jewelry[j][0];
                jewelry[j][0] = temp;

                temp = jewelry[i][1];
                jewelry[i][1] = jewelry[j][1];
                jewelry[j][1] = temp;

                temp2 = jewelryAP[i];
                jewelryAP[i] = jewelryAP[j];
                jewelryAP[j] = temp2;
            }
            // if(jewelry[i][1] < jewelry[j][1]){
            //     temp = jewelry[i][0];
            //     jewelry[i][0] = jewelry[j][0];
            //     jewelry[j][0] = temp;

            //     temp = jewelry[i][1];
            //     jewelry[i][1] = jewelry[j][1];
            //     jewelry[j][1] = temp;
            // } else if(jewelry[i][1] == jewelry[j][1]){
            //     if(jewelry[i][0] > jewelry[j][0]){
            //         temp = jewelry[i][0];
            //         jewelry[i][0] = jewelry[j][0];
            //         jewelry[j][0] = temp;

            //         temp = jewelry[i][1];
            //         jewelry[i][1] = jewelry[j][1];
            //         jewelry[j][1] = temp;
            //     }
            // }
        }
    }
}