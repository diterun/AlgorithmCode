#include <iostream>
#include <vector>
using namespace std;

int solution(int n);

int main(){
  cout << solution(15) << endl;

  return 0;
}

int solution(int n) {
  int answer = 0;
  int cnt = 22;
  bool binary[cnt];

  for(int i = 0; i < cnt; i++){
    binary[i] = n & (1 << i);
  }

  bool now = false, hasClock = false;
  int startIndex = 0, endIndex = 0;

  for(int i = 0; i < cnt; i++){
    if(binary[i] & !now & !hasClock){
      now = true;
      startIndex = i;
    } else if(!binary[i] & now & !hasClock){
      hasClock = true;
      endIndex = i;
    }
  }

  int count = endIndex - startIndex;
  if(count == 1){
    binary[endIndex] = true;
    binary[startIndex] = false;
  } else {
    for(int i = startIndex; i < endIndex; i++){
      binary[i] = false;
    }
    binary[endIndex] = true;
    for(int i = 0; i < count - 1; i++){
      binary[i] = true;
    }
  }

  for(int i = 0; i < cnt; i++){
    if(binary[i]){
      answer |= (1 << i);
    }
  }

  return answer;
}
