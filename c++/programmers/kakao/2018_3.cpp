#include <iostream>
#include <vector>
#include <map>
using namespace std;

int solution(vector<vector<string>> relation) ;

int main(){
    vector<vector<string>> a = {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};

    printf("%d\n", solution(a));

    return 0;
}

int result, attCnt, tupCnt;
vector<vector<int>> combs;
map<string, int> keys;
vector<vector<string>> relations;

void combination(int start, int cnt, int flag, int n);
bool isMinimal(vector<int> nums);

int solution(vector<vector<string>> relation) {
    result = 0;
    relations = relation;
    attCnt = relation[0].size();
    tupCnt = relation.size();

    for(int i = 1; i <= attCnt; i++){
        combination(0, 0, 0, i);
    }

    return result;
}

void combination(int start, int cnt, int flag, int n){
    if(cnt == n){
        vector<int> numbers;

        for(int i = 0; i < attCnt; i++){
            if((flag & (1 << i))){
                numbers.push_back(i);
            }
        }

        if(isMinimal(numbers)){
            keys.clear();

            for(int i = 0; i < tupCnt; i++){
                string key = "";

                for(int j = 0; j < n; j++){
                    key += relations[i][numbers[j]];
                }

                keys[key] = 1;
            }

            if(keys.size() == tupCnt){
                result++;
                combs.push_back(numbers);
            }
        }
    }

    for(int i = start; i < attCnt; i++){
        if((flag & (1 << i)) == 0){
            combination(i, cnt + 1, flag | (1 << i), n);
        }
    }
}

bool isMinimal(vector<int> nums){
    int len = combs.size();

    for(int i = 0; i < len; i++){
        int comSize = combs[i].size();
        int cnt = 0;

        if(comSize == nums.size()){
            continue;
        }

        for(int j = 0; j < comSize; j++){
            bool ok = false;

            for(int k = 0; k < nums.size(); k++){
                if(combs[i][j] == nums[k]){
                    ok = true;
                    break;
                }
            }

            if(ok){
                cnt++;
            }
        }

        if(cnt == comSize){
            return false;
        }
    }

    return true;
}
