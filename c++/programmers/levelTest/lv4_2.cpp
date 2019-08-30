#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int solution(int N, vector<vector<int> > road, int K);
void goToDelivery(int end, int spentTime, int N, int K);

int main(){
  vector<vector<int>> a = {{1, 2, 1},{2, 3, 3},{5, 2 ,2},{1, 4, 2},{5, 3, 1},{5, 4, 2}};
  vector<vector<int>> b = {{1, 2, 1},{1, 3, 2},{2, 3 ,2},{3, 4, 3},{3, 5, 2},{3, 5, 3},{5, 6, 1}};

  cout << solution(5, a, 3) << endl;
  cout << solution(6, b, 4) << endl;

  return 0;
}

int canMove[51][51];
bool check[51];

void goToDelivery(int end, int spentTime, int N, int K){
  for(int i = 0; i < N; i++){
    if(i == end){
      continue;
    }
    if(check[i]){
      if(canMove[end][i] + spentTime < canMove[0][i]){
        canMove[0][i] = canMove[end][i] + spentTime;
        goToDelivery(i, canMove[end][i] + spentTime, N, K);
      }
    } else {
      if(canMove[end][i] + spentTime < canMove[0][i] && canMove[end][i] + spentTime <= K){
        check[i] = true;
        canMove[0][i] = canMove[end][i] + spentTime;
        goToDelivery(i, canMove[end][i] + spentTime, N, K);
      }
    }
  }
}

int solution(int N, vector<vector<int> > road, int K) {
  for(int i = 0; i < 51; i++){
    for(int j = 0; j < 51; j++){
      canMove[i][j] = 500001;
    }
    check[i] = false;
  }
  int answer = 1;

  for(int i = 0; i < road.size(); i++){
    if(canMove[road[i][0] - 1][road[i][1] - 1] > road[i][2]){
      canMove[road[i][0] - 1][road[i][1] - 1] = road[i][2];
      canMove[road[i][1] - 1][road[i][0] - 1] = road[i][2];
    }
  }

  check[0] = true;
  for(int i = 1; i < N; i++){
    if(!check[i] && canMove[0][i] <= K){
      check[i] = true;
      goToDelivery(i, canMove[0][i], N, K);
    }
  }

  for(int i = 1; i < N; i++){
    if(canMove[0][i] <= K){
      answer++;
    }
  }

  return answer;
}