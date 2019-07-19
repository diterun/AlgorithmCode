#include<iostream>
using namespace std;

int T, t, n, i;
long long sumArea, sumValue;
long long area[31][2];
long long d, result;

long long getMin(long long a, long long b);
void areaDistribute(int index
                    , long long hoArea
                    , long long hoValue
                    , long long daArea
                    , long long daValue
                    , long long otherArea
                    , long long otherValue){
    if(index == n){
        if(hoArea - d <= daArea && daArea <= hoArea + d){
            // cout << hoArea << ", " << hoValue << " vs " << daArea <<", " << daValue << endl;
            result = getMin(result, hoValue - daValue);
        }
        return;
    }

    otherArea -= area[index][0];
    otherValue -= area[index][1];

    if(hoArea + area[index][0] - d <= daArea + otherArea){
        areaDistribute(index + 1
                    , hoArea + area[index][0]
                    , hoValue + area[index][1]
                    , daArea
                    , daValue
                    , otherArea
                    , otherValue);
    }

    if(hoValue + otherValue - result > daValue + area[index][1]){
        areaDistribute(index + 1
                    , hoArea
                    , hoValue
                    , daArea + area[index][0]
                    , daValue + area[index][1]
                    , otherArea
                    , otherValue);
    }

    if((hoArea - d <= daArea + otherArea) && (hoValue + otherValue - result > daValue)){
        areaDistribute(index + 1
                    , hoArea
                    , hoValue
                    , daArea
                    , daValue
                    , otherArea
                    , otherValue);
    }
}

int main(){
	cin >> T;

	for(t = 1; t <= T; ++t){
        for(i = 0; i < 31; i++){
            area[i][0] = 0;
            area[i][1] = 0;
        }
        sumArea = sumValue = 0;
        result = 0;
        cin >> n >> d;

        for(i = 0; i < n; i++){
            cin >> area[i][0] >> area[i][1];
            sumArea += area[i][0];
            sumValue += area[i][1];
        }

        areaDistribute(0, 0, 0, 0, 0, sumArea, sumValue);

        cout << "#" << t << " " << result << endl;
	}
	return 0;
}

long long getMin(long long a, long long b){
    return a > b ? a : b;
}