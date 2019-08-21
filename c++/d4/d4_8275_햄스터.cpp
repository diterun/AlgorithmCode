#include<iostream>
using namespace std;

int hamsters[7];
int T, t;
int n, x, m;
int checkPoint[61][3];
bool haveCheck[7];
int mymin, mymax;
bool killAll;

void process(int index);
bool check();
int getMin(int a, int b);
int getMax(int a, int b);

int main(){
  cin >> T;

  for(t = 1; t <= T; t++){
    for(int i = 0; i < 7; i++){
      hamsters[i] = 0;
      haveCheck[i] = false;
    }
    killAll = false;
    mymin = 0;
    mymax = 0;
    scanf("%d%d%d", &n, &x, &m);

    for(int i = 0; i < m; i++){
      scanf("%d%d%d", &checkPoint[i][0], &checkPoint[i][1], &checkPoint[i][2]);
      mymin = getMin(mymin, checkPoint[i][0]);
      mymax = getMax(mymax, checkPoint[i][1]);
    }

    for(int i = mymin; i <= mymax; i++){
      haveCheck[i] = true;
    }

    process(1);

    if(!killAll){
      printf("#%d -1\n", t);
    }
  }
  return 0;
}

void process(int index){
  if(killAll){
    return;
  }
  if(index == (n + 1)){
    if(check()){
      printf("#%d ", t);
      for(int i = 1; i <= n; i++){
        printf("%d ", hamsters[i]);
      }
      printf("\n");
      killAll = true;
    }
    return;
  }
  if(!haveCheck[index]){
    hamsters[index] = x;
    process(index + 1);
    return;
  }

  for(int i = 0; i <= x; i++){
    hamsters[index] = i;
    process(index + 1);
  }
}

bool check(){
  for(int i = 0; i < m; i++){
    int sum = 0;
    for(int j = checkPoint[i][0]; j <= checkPoint[i][1]; j++){
      sum += hamsters[j];
    }
    if(sum != checkPoint[i][2]){
      return false;
    }
  }

  return true;
}

int getMin(int a, int b){
  return a < b ? a : b;
}

int getMax(int a, int b){
  return a > b ? a : b;
}