#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

vector<int> solution(vector<string> genres, vector<int> plays);

int main(){
  vector<string> gen = {"classic", "prp", "classic", "classic", "pop"};
  vector<int> num = {500, 600, 150, 800, 2500};

  vector<int> result = solution(gen, num);

  for(int i = 0; i < result.size(); i++){
    cout << result[i] << endl;
  }

  return 0;
}

bool cmp(const pair<int, int> &a, const pair<int, int> &b){
    return a.second > b.second;
}

vector<int> solution(vector<string> genres, vector<int> plays) {
  vector<int> answer;
  string genre[100];
  int genreCnt = 0;
  vector<pair<int, int>> track[100];
  int trackPlays[100][2];

  for(int i = 0; i < 100; i++){
    genre[i] = "";
  }

  int inputSize = genres.size();

  for(int i = 0; i < inputSize; i++){
    cout << genres[i] << " " << plays[i] << endl;
    bool isExist = false;
    for(int j = 0; j < genreCnt; j++){
      if(genre[j] == genres[i]){
        trackPlays[j][1] += plays[i];
        track[j].push_back(make_pair(i, plays[i]));
        genreCnt++;

        isExist = true;
      }
    }

    if(!isExist){
      genre[genreCnt] = genres[i];
      trackPlays[genreCnt][0] = genreCnt;
      trackPlays[genreCnt][1] = plays[i];
      track[genreCnt].push_back(make_pair(i, plays[i]));
      genreCnt++;
    }
  }

  for(int i = 0; i < genreCnt - 1; i++){
    for(int j = 0; j < genreCnt; j++){
      if(trackPlays[i][1] < trackPlays[j][1]){
        int temp = trackPlays[i][1];
        trackPlays[i][1] = trackPlays[j][1];
        trackPlays[j][1] = temp;

        temp = trackPlays[i][0];
        trackPlays[i][0] = trackPlays[j][0];
        trackPlays[j][0] = temp;
      }
    }
  }

  // for(int i = 0; i < genreCnt; i++){
  //   sort(track[i].begin(), track[i].end(), cmp);
  // }

  for(int i = 0; i < genreCnt; i++){
    int genreSize = track[i].size();
    int firstCnt = 0, secondCnt = 0;
    int firstIndex = 0, secondIndex = 0;

    for(int j = 0; j < genreSize; j++){
      if(secondCnt < track[i][j].second){
        if(firstCnt < track[i][j].second){
          secondCnt = firstCnt;
          secondIndex = firstIndex;
          firstCnt = track[i][j].second;
          firstIndex = j;
        } else if(firstCnt == track[i][j].second){
          track[i][firstIndex].first
        } else {
          secondCnt = track[i][j].second;
          secondIndex = j;
        }
      } else if(secondCnt == track[i][j].second){

      }
    }
    for(int j = 0; j < 2 && j < track[i].size(); j++){
      answer.push_back(track[trackPlays[i][0]][j].first);
    }
  }

  return answer;
}
