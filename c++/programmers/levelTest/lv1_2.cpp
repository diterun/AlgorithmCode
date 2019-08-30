#include <iostream>
using namespace std;

string str;
string solution(string s);

int main(){
  cin >> str;

  cout << solution(str) << endl;

  return 0;
}

string solution(string phone_number) {
  int len = phone_number.length();

  for(int i = 0; i < len - 4; i++){
    phone_number[i] = '*';
  }

  return phone_number;
}