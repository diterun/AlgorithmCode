#include <iostream>
using namespace std;

int t, T, l, r;
int result;
int arr[1000];

int main(){
  arr[0] = 1;
  for(int i = 1; i < 1000; i++){
    int jjack = 0, hol = 0;
    for(int j = 1; j <= i; j++){
      if(i % j == 0){
        if(j % 2 == 0){
          jjack++;
        } else {
          hol++;
        }
      }
    }

    int chai = jjack - hol;

    cout << hol << " " << jjack << endl;

    if(chai <= 2 && -2 <= chai){
      arr[i] = 1;
    } else {
      arr[i] = 0;
    }
  }
  // for(int i = 0; i < 100; i++){
  //   cout << "arr[" << i << "] = " << arr[i] <<";" << endl;
  // }
  

  cin >> T;

  for(t = 1; t <= T; t++){
    result = 0;
    cin >> l >> r;

    for(int i = l; i <= r; i++){
      result += arr[i];
    }

    cout << "Case #" << t << ": " << result << endl;
  }
}
