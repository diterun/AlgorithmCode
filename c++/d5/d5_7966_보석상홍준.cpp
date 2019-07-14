#include<iostream>
using namespace std;

int T, t;
int n, x, k, money, result, i, j, myJewel;
int minAesth, maxAesth, sumAesth;
int minPrice, maxPrice, sumPrice;
int jewelry[32][2];

int getMin(int a, int b);
int getMax(int a, int b);

int main()
{
	cin >> T;
	for(t = 1; t <= T; ++t)
	{
        money = 0;
        sumPrice = sumAesth = maxPrice = maxAesth = 0;
        minPrice = minAesth = 30000001;
        result = 30000001 * 32;

        for(i = 0; i < 32; i++){
            jewelry[i][0] = 0;
            jewelry[i][1] = 0;
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
        }

        cin >> x;

        cin >> k;
        /* 내가 가진 보석이 있다면 바로 내가 가진 돈으로 환산한다. */
        for(i = 0; i < k; i++){
            cin >> myJewel;
            money += jewelry[myJewel - 1][0];
        }

        if(x >= sumAesth){
            if(x == sumAesth){
                cout << "#" << t << " " << (sumPrice - money) << endl;
            } else {
                cout << "#" << t << " -1" << endl;
            }

            continue;
        }

        if(x <= minAesth){
            if(minPrice < money){
                cout << "#" << t << " 0" << endl;
            } else {
                cout << "#" << t << " " << (minPrice - money) << endl;
            }

            continue;
        }

        for(i = 0; i < n; i++){
            for(j = i; j < n; j++){
                if(jewelry[i][1] >= jewelry[j][1]){
                    if(jewelry[i][0] < jewelry[j][0]){
                        int temp = jewelry[i][0];
                        jewelry[i][0] = jewelry[j][0];
                        jewelry[j][0] = temp;

                        temp = jewelry[i][1];
                        jewelry[i][1] = jewelry[j][1];
                        jewelry[j][1] = temp;
                    }
                }
            }
        }


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