#include<iostream>
#include<vector>
#include<map>
using namespace std;

#define getMax(a, b) (a > b ? a : b)

vector<int> solution(vector<int> cook_times, vector<vector<int>> order, int k);

class cook{
public:
    int cookNumber;
    int cookTime;
    int cookEndTime;
    map<int, int> dependencys;
    vector<int> dependency;
};

int main(void){
    vector<int> a = {5, 30, 15, 30, 35, 20, 4};
    vector<vector<int>> b = {{2,4},{2,5},{3,4},{3,5},{1,6},{4,6},{5,6},{6,7}};
    vector<int> result;

    result = solution(a, b, 6);

    for(int i = 0; i < result.size(); i++){
        cout << result[i] << endl;
    }

    return 0;
}

vector<int> solution(vector<int> cook_times, vector<vector<int>> order, int k){
    vector<int> answer;
    int cookCnt = cook_times.size();
    int orderSize = order.size();
    cook cooks[cookCnt];

    for(int i = 0; i < cookCnt; i++){
        cooks[i].cookNumber = i + 1;
        cooks[i].cookTime = cook_times[i];
        cooks[i].cookEndTime = -1;
    }

    for(int i = 0; i < orderSize; i++){
        cooks[order[i][1] - 1].dependency.push_back(order[i][0] - 1);
        cooks[order[i][1] - 1].dependencys[order[i][0] - 1] = 1;
    }

    for(int i = 0; i < cookCnt; i++){
        int dependTime = 0;
        int dependCnt = cooks[i].dependency.size();

        for(int j = 0; j < dependCnt; j++){
            for(auto it = cooks[cooks[i].dependency[j]].dependencys.begin(); it != cooks[cooks[i].dependency[j]].dependencys.end(); it++){
                cooks[i].dependencys[it->first] = 1;
            }
            dependTime = getMax(dependTime, cooks[cooks[i].dependency[j]].cookEndTime);
        }

        cooks[i].cookEndTime = cooks[i].cookTime + dependTime;
    }

    answer.push_back(cooks[k - 1].dependencys.size());
    answer.push_back(cooks[k - 1].cookEndTime);

    return answer;
}
