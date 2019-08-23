#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int solution(vector<vector<int>> jobs);

int main(){
  vector<vector<int>> a = {{0, 3},{1, 9},{2,6}};
  cout<< a[0][0] << " " << a[0][1] << endl;
  cout<< a[1][0] << " " << a[1][1] << endl;
  cout<< a[2][0] << " " << a[2][1] << endl;
  cout << solution(a) << endl;

  return 0;
}

int solution(vector<vector<int>> jobs) {
  int answer = 0, diskTime = 0;
  int jobLen = jobs.size();
  int jobNum = 0, qStart = 0, qEnd = 0;
  int jobQueue[500][2];
  bool isEnd = false;

  for(int i = 0; i < jobLen - 1; i++){
    for(int j = i + 1; j < jobLen; j++){
      if(jobs[i][0] > jobs[j][0]){
        int temp = jobs[i][0];
        jobs[i][0] = jobs[j][0];
        jobs[j][0] = temp;
        
        temp = jobs[i][1];
        jobs[i][1] = jobs[j][1];
        jobs[j][1] = temp;
      }
    }
  }

  while(!isEnd){
    bool hasPush = false;
    int minTime = 1001;

    for(int i = jobNum; i < jobLen; i++){
      if(jobs[i][0] <= diskTime){
        jobQueue[qEnd][0] = jobs[i][0];
        jobQueue[qEnd][1] = jobs[i][1];
        hasPush = true;
        jobNum = i + 1;
        qEnd++;
      } else {
        minTime = minTime > jobs[i][0] ? minTime : jobs[i][0];
        break;
      }
    }

    if(hasPush){
      for(int i = qStart; i < qEnd - 1; i++){
        for(int j = i + 1; j < qEnd; j++){
          if(jobQueue[i][1] > jobQueue[j][1]){
            int temp = jobQueue[i][0];
            jobQueue[i][0] = jobQueue[j][0];
            jobQueue[j][0] = temp;
            
            temp = jobQueue[i][1];
            jobQueue[i][1] = jobQueue[j][1];
            jobQueue[j][1] = temp;
          }
        }
      }
    }

    if(qStart == qEnd){
      if(jobNum >= jobLen - 1){
        isEnd = true;
      } else {
        diskTime = minTime;
      }
    } else {
      diskTime += jobQueue[qStart][1]; 
      answer += diskTime - jobQueue[qStart][0];
      qStart++;
    }
  }

  return answer / jobLen;
}
