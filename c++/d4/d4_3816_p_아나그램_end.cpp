#include<iostream>
using namespace std;

string s1, s2;
int s1len, s2len;
int s1arr[26], s2arr[26];

int isEqual(){
    for(int i = 0; i < 26; i++){
        if(s1arr[i] != s2arr[i]){
            return 0;
        }
    }
    return 1;
}

int processing(){
    int result = 0;

    for(int i = 0; i < s1len; i++){
        s1arr[s1[i] - 'a']++;
    }

    for(int i = 0; i < s1len; i++){
        s2arr[s2[i] - 'a']++;
    }
    result += isEqual();

    for(int i = s1len; i < s2len; i++){
        s2arr[s2[i - s1len] - 'a']--;
        s2arr[s2[i] - 'a']++;
        result += isEqual();
    }

    return result;
}

// 데이터 입력
void inputData(){
    cin >> s1 >> s2;
    s1len = s1.size();
    s2len = s2.size();
}

void inittest(){
    for(int i = 0; i < 26; i++){
        s1arr[i] = 0;
        s2arr[i] = 0;
    }
}

int main(){
	int T, t;
	cin >> T;

	for(t = 1; t <= T; ++t){
        inittest();
        inputData();
        cout <<"#" << t << " " << processing() << endl;
	}

	return 0;
}