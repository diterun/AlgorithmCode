#include <iostream>
#include <vector>
using namespace std;

string solution(string p);
bool checker(string s);

int main(){
    cout << solution("(()())()") << endl;
    cout << endl;
    cout << solution(")(") << endl;
    cout << endl;
    cout << solution("()))((()") << endl;
    cout << endl;
    cout << solution("()())()()()()()(") << endl;
    cout << endl;
    cout << solution(")()()(") << endl;
    return 0;
}

string solution(string p) {
    if(p == ""){
        return p;
    }
    if(checker(p)){
        return p;
    }

    string answer = "";
    int plen = p.size();
    int onum = 0, cnum = 0;
    int i;
    string u = "", v = "";

    for(i = 0; i < plen; i++){
        if(p[i] == '('){
            u += p[i];
            onum++;
        } else {
            u += p[i];
            cnum++;
        }

        if(onum == cnum){
            i++;
            break;
        }
    }

    for(; i < plen; i++){
        v += p[i];
    }

    v = solution(v);

    if(checker(u)){
        answer = u + v;
    } else {
        int ulen = u.size();

        answer += '(';
        answer += v;
        answer += ')';

        for(int i = 1; i < ulen - 1; i++){
            if(u[i] == '('){
                answer += ')';
            } else {
                answer += '(';
            }
        }
    }

    return answer;
}

bool checker(string s){
    int slen = s.size();
    int snum = 0;

    for(int i = 0; i < slen; i++){
        if(s[i] == '('){
            snum++;
        } else {
            if(snum == 0){
                return false;
            } else {
                snum--;
            }
        }
    }

    if(snum == 0){
        return true;
    } else {
        return false;
    }
}