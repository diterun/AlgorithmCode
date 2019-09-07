#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int solution(int n, vector<int> weak, vector<int> dist);

int main(){
    vector<int> w1 = {1,5,6,10};
    vector<int> w2 = {1,3,4,9,10};
    vector<int> d1 = {1,2,3,4};
    vector<int> d2 = {3,5,7};

    cout << solution(12, w1, d1) << endl;
    cout << solution(12, w2, d2) << endl;

    return 0;
}

int getMin(int a, int b);

int solution(int n, vector<int> weak, vector<int> dist) {
    int answer = 100;
    int weaklen = weak.size();
    vector<int> diff;
    int distsum = 0;
    for(int i = 0; i < dist.size(); i++){
        distsum += dist[i];
    }

    diff.push_back(n - weak[weaklen - 1] + weak[0]);

    for(int i = 1; i < weaklen; i++){
        diff.push_back(weak[i] - weak[i - 1]);
    }

    vector<vector<int>> diffs(diff.size());
    vector<int> diffsum(diff.size());

    for(int i = 0; i < diffs.size(); i++){
        for(int j = i; j < diff.size(); j++){
            diffs[i].push_back(diff[j]);
        }
        for(int j = 0; j < i; j++){
            diffs[i].push_back(diff[j]);
        }
    }

    sort(dist.begin(), dist.end());

    for(int i = 0; i < diffsum.size(); i++){
        diffsum[i] = 0;
    }

    bool can = false;
    
    for(int i = 0; i < diffs.size(); i++){
        for(int j = 0; j < diffs[i].size() - 1; j++){
            diffsum[i] += diffs[i][j];
        }

        if(distsum > diffsum[i]){
            can = true;
        }
    }

    if(!can){
        return -1;
    }

    for(int i = 0; i < diffs.size(); i++){
        int j = 0;
        int k = dist.size() - 1;

        for(; k >= 0; k--){
            int now = dist[k];

            for(; j < diffs[i].size() - 1; j++){
                if(now >= diffs[i][j]){
                    now -= diffs[i][j];
                } else {
                    j++;
                    break;
                }
            }
            if(j == diffs[i].size() - 1){
                break;
            }
        }

        if(j == diffs[i].size() - 1){
            answer = getMin(answer, dist.size() - k);
        }
    }
    
    return answer;
}

int getMin(int a, int b){
    return a < b ? a : b;
}