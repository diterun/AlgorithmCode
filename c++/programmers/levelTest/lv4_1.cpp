#include <iostream>
#include <vector>
using namespace std;

#define getMax(a, b) (a > b ? a : b)

int solution(int n, vector<vector<int>> triangle, vector<vector<int>> v);

int main(){
  vector<vector<int>> tri;
  vector<vector<int>> b;

  cout << solution(5, tri, b) << endl;

  return 0;
}

int solution(int n, vector<vector<int>> triangle, vector<vector<int>> v) {
    int answer = 0;

    cout << getMax(5, 6) << endl;
    return answer;
}