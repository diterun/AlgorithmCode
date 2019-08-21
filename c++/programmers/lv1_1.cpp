#include <iostream>
using namespace std;

string str;
string solution(string s);

int main(){
  cin >> str;

  cout << solution(str) << endl;

  return 0;
}

string solution(string s) {
    int len = s.length();

    for(int i = 0; i < len - 1; i++){
      for(int j = i + 1; j < len; j++){
        if(s[i] < s[j]){
          char temp = s[i];
          s[i] = s[j];
          s[j] = temp;
        }
      }
    }

    return s;
}