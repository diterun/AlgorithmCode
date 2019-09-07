#include <iostream>
#include <vector>
using namespace std;

vector<int> solution(vector<string> words, vector<string> queries);

int main(){
    vector<string> w = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
    vector<string> q = {"fro??", "????o", "fr???", "fro???", "pro?"};

    vector<int> a = solution(w, q);

    return 0;
}

vector<int> solution(vector<string> words, vector<string> queries) {
    vector<int> answer;
    return answer;
}