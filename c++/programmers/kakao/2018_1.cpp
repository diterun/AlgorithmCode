#include <iostream>
#include <string>
#include <vector>
#include <map>
using namespace std;

vector<string> solution(vector<string> record);
void tokenizer(string str, vector<string>& token, string delim);

int main(){
    vector<string> a = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};

    vector<string> result = solution(a);

    for(int i = 0; i < result.size(); i++){
        printf("%s\n", result[i].c_str());
    }

    return 0;
}

map<string, string> users;

vector<string> solution(vector<string> record) {
    vector<string> answer;
    vector<vector<string>> tokens;
    int recordSize = record.size();

    for(int i = 0; i < recordSize; i++){
        vector<string> token;

        tokenizer(record[i], token, " ");
        tokens.push_back(token);

        if(token[0] == "Enter"){
            users[token[1]] = token[2];
        } else if(token[0] == "Change"){
            users[token[1]] = token[2];
        }
    }

    for(int i = 0; i < recordSize; i++){
        if(tokens[i][0] == "Enter"){
            string str = users[tokens[i][1]] + "님이 들어왔습니다.";
            answer.push_back(str);
        } else if(tokens[i][0] == "Leave"){
            string str = users[tokens[i][1]] + "님이 나갔습니다.";
            answer.push_back(str);
        }
    }

    return answer;
}

void tokenizer(string str, vector<string>& token, string delim){
    size_t s = str.find_first_not_of(delim, 0);
    size_t e = str.find_first_of(delim, s);
    
    while(string::npos != s || string::npos != e){
        token.push_back(str.substr(s, e - s));
        s = str.find_first_not_of(delim, e);
        e = str.find_first_of(delim, s);
    }
}
