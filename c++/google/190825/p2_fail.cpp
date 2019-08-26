#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

class CE{
public:
  int c;
  int e;
  double bi;
  CE(int c, int e, double bi):c(c),e(e),bi(bi){}
};

int t, T;
int d, s, c, e, a, b;
int maxc, maxe;
vector<CE> ce;
string result;

bool compare(CE a, CE b){
  return a.bi > b.bi;
}
bool process(int a, int b, vector<CE> ce);

int main(){
  cin >> T;

  for(t = 1; t <= T; t++){
    result = "";
    maxc = maxe = 0;
    cin >> d >> s;
    for(int i = 0; i < s; i++){
      cin >> c >> e;
      maxc += c;
      maxe += e;

      ce.push_back(CE(c, e, e / c));
    }

    sort(ce.begin(), ce.end(), compare);

    for(int i = 0; i < d; i++){
      cin >> a >> b;

      if(process(a, b, ce)){
        result += "Y";
      } else {
        result += "N";
      }
    }

    cout << "Case #" << t << ": " << result <<endl;
  }

  return 0;
}

bool process(int a, int b, vector<CE> ce){
  if(maxc < a){
    return false;
  }
  if(maxe < b){
    return false;
  }

  for(int i = 0; i < s; i++){
    if(b > 0){
      if(b >= ce[i].e){
        b -= ce[i].e;
      } else {
        ce[i].c = ce[i].c * b / ce[i].e;
        b = 0;
        a -= ce[i].c;
      }
    } else {
      a -= ce[i].c;
    }
  }

  if(a > 0){
    return false;
  } else {
    return true;
  }
}
