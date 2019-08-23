#include <iostream>
#include <vector>
using namespace std;

vector<int> solution(int n, int s);

int main(){
  vector<int> result = solution(2, 9);
  for(int i = 0; i < result.size(); i++){
    cout << result[i] << " ";
  }
  cout << endl;

  result = solution(3, 10);
  for(int i = 0; i < result.size(); i++){
    cout << result[i] << " ";
  }
  cout << endl;

  return 0;
}

vector<int> solution(int n, int s) {
    vector<int> answer;

    if(n > s){
      answer.push_back(-1);
      return answer;
    } else if(s % n == 0){
      int num = s / n;
      for(int i = 0; i < n; i++){
        answer.push_back(num);
      }
      return answer;
    }

    int minNumber = s / n;
    int otherCnt = s % n;

    for(int i = 0; i < n - otherCnt; i++){
        answer.push_back(minNumber);
    }
    for(int i = n - otherCnt; i < n; i++){
        answer.push_back(minNumber + 1);
    }

    return answer;
}