#include <iostream>
#include <vector>
using namespace std;

vector<int> solution(int N, vector<int> stages);

int main(){
    vector<int> a = {2, 1, 2, 6, 2, 4, 3, 3};

    vector<int> result = solution(5, a);

    for(int i = 0; i < result.size(); i++){
        printf("%d\n", result[i]);
    }

    return 0;
}

#define MAX 502

int stageFailCnt[MAX];
int stageUserCnt[MAX];
double failer[MAX][2];

vector<int> solution(int N, vector<int> stages) {
    vector<int> answer;
    int ssLen = stages.size();

    for(int i = 0; i < MAX; i++){
        stageFailCnt[i] = 0;
        stageUserCnt[i] = 0;
    }

    for(int i = 0; i < ssLen; i++){
        stageFailCnt[stages[i]]++;
    }

    stageUserCnt[N + 1] = stageFailCnt[N + 1];

    for(int i = N; i > 0; i--){
        stageUserCnt[i] = stageUserCnt[i + 1] + stageFailCnt[i];
    }

    for(int i = 1; i <= N; i++){
        failer[i][0] = (double)stageFailCnt[i] / (double)stageUserCnt[i];
        failer[i][1] = i;
    }

    for(int i = 1; i < N; i++){
        for(int j = i + 1; j <= N; j++){
            if(failer[i][0] < failer[j][0]){
                double temp = failer[i][0];
                failer[i][0] = failer[j][0];
                failer[j][0] = temp;

                temp = failer[i][1];
                failer[i][1] = failer[j][1];
                failer[j][1] = temp;
            } else if(failer[i][0] == failer[j][0]){
                if(failer[i][1] > failer[j][1]){
                    double temp = failer[i][0];
                    failer[i][0] = failer[j][0];
                    failer[j][0] = temp;

                    temp = failer[i][1];
                    failer[i][1] = failer[j][1];
                    failer[j][1] = temp;
                }
            }
        }
    }

    for(int i = 1; i <= N; i++){
        answer.push_back((int)failer[i][1]);
    }

    return answer;
}