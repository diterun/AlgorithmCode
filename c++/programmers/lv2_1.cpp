#include <iostream>
#include <vector>
using namespace std;

int solution(vector<int> nums);

int main(){
  vector<int> human = {1, 2, 3, 4};

  cout << solution(human) << endl;

  return 0;
}

int solution(vector<int> nums) {
  vector<int> prime;
  prime.push_back(2);

  for (int i = 3; i <= 3000; i++) {
    for (int j = 0; j < prime.size(); j++) {
      if(i % prime[j] == 0){
        break;
      }

      if(j + 1 == prime.size()){
        prime.push_back(i);
      }
    }
  }

  int result = 0;
  int len = nums.size();

  for(int i = 0; i < len - 2; i++){
    for(int j = i + 1; j < len - 1; j++){
      for(int k = j + 1; k < len; k++){
        int sum = nums[i] + nums[j] + nums[k];

        for(int l = 0; l < prime.size(); l++){
          if(prime[l] == sum){
            result++;
            break;
          }
        }
      }
    }
  }

  return result;
}