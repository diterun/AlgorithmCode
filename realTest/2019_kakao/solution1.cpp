#include <iostream>
#include <vector>
#include <map>
using namespace std;

int solution(string s);

int main(){

    printf("%d\n", solution("aabbaccc"));
    cout << endl;
    printf("%d\n", solution("abcabcdede"));
    
    return 0;
}

int getMin(int a, int b);

int solution(string s) {
    string astr = "";
    int answer = 1001;
    int strLen = s.size();

    for(int i = 1; i <= strLen / 2; i++){
        string strs;
        int cnt = 1;

        for(int k = 0; k < i; k++){
            strs += s[k];
        }

        for(int j = i; j < strLen; j += i){
            bool check = true;

            for(int k = j; k < j + i && k < strLen; k++){
                if(strs[k - j] != s[k]){
                    check = false;
                    break;
                }
            }

            if(check){
                cnt++;
            } else {
                if(cnt != 1){
                    astr += to_string(cnt);
                }
                astr += strs;
                strs = "";
                for(int k = 0; k < i && k + j < strLen; k++){
                    strs += s[k + j];
                }
                cnt = 1;
            }
        }
        if(cnt != 1){
            astr += to_string(cnt);
        }
        astr += strs;

        answer = getMin(answer, astr.size());
        astr = "";
    }

    return answer;
}

int getMin(int a, int b){
    return a < b ? a : b;
}