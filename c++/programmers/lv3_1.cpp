#include <iostream>
#include <vector>
using namespace std;

int solution(string s);
int getMax(int a, int b);

int main(){
  cout << solution("abbcde") << endl;
  cout << solution("abcdcba") << endl;
  cout << solution("abacde") << endl;
  cout << solution("cdeaba") << endl;
  cout << solution("cdecaa") << endl;

  return 0;
}

int getMax(int a, int b){
  return a > b ? a : b;
}

int solution(string s)
{
  int answer=0;
  int strLen = s.length();

  for(int i = 0; i < strLen; i++){
    int count = 1;
    int count2 = 0;

    for(int j = 1;;j++){
      if(i - j < 0 || i + j >= strLen){
        break;
      }
      if(s[i - j] == s[i + j]){
        count += 2;
      } else {
        break;
      }
    }

    for(int j = 0;;j++){
      if(i - j < 0 || i + j + 1>= strLen){
        break;
      }
      if(s[i - j] == s[i + j + 1]){
        count2 += 2;
      } else {
        break;
      }
    }

    count = getMax(count, count2);
    answer = getMax(answer, count);
  }

  return answer;
}