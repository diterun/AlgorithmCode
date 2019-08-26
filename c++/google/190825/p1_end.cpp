#include <iostream>
using namespace std;

#define MAX 100002

int t, T;
int result, n, m, a, b, nSize;
int p[MAX];

int findSet(int a){
  if(p[a] == a){
    return a;
  }

  return p[a] = findSet(p[a]);
}

void unionSet(int a, int b){
  a = findSet(a);
  b = findSet(b);

  if(a == b){
    return;
  }
  result++;
  nSize--;
  if(a > b){
    p[a] = b;
  } else {
    p[b] = a;
  }
}

int main(){
  cin >> T;

  for(t = 1; t <= T; t++){
    result = 0;
    cin >> n >> m;
    nSize = n - 1;
    for(int i = 0; i <= n; i++){
      p[i] = i;
    }

    for(int i = 0; i < m; i++){
      cin >> a >> b;

      unionSet(a, b);
    }

    result += (nSize * 2);

    cout << "Case #" << t << ": " << result << endl;
  }

}
