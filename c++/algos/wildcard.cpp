#include<iostream>
using namespace std;

int T, t, n;
string wild;
string *cards;
string *results;
int cnt;

int main(void){
    cin >> T;

    for(t = 0; t < T; ++t){
        cnt = 0;

        cin >> wild;
        cin >> n;
        cards = new string[n];
        results = new string[n];

        for(int i = 0; i < n; ++i){
            cin >> cards[i];
        }

        int len = wild.length();
        string *sub = new string[len];
        bool got = false;
        int subi = 0;
        for(int i = 0; i < len; i++){
            switch(wild[i]){
            case '?':
                if(got){
                    subi++;
                    got = false;
                }
                sub[subi] = '?';
                subi++;
                break;
            case '*':
                if(got){
                    subi++;
                    got = false;
                }
                sub[subi] = '*';
                subi++;
                break;
            default:
                sub[subi] += wild[i];
                got = true;
                break;
            }
        }
        // cout << sub[subi] <<" " << subi << endl;
        if(got){
            subi++;
            got = false;
        }

        for(int i = 0; i < n; ++i){
            int clen = cards[i].length();
            bool imPoint = false;

            for(int j = 0, k = 0; j < subi; ++j){
                if(sub[j][0] == '*'){
                    imPoint = true;
                } else if(sub[j][0] == '?'){
                    k++;
                    imPoint = false;
                } else {
                    if(imPoint){
                        int subLen = sub[j].length();

                        for(int l = 0; l < subLen; l++){
                            if(sub[j][l] != cards[i][k]){
                                k++;
                                l--;
                                continue;
                            }
                        }
                    }
                    imPoint = false;
                }
            }
        }

        for(int i = 0; i < subi; i++){
            cout << "i : " << sub[i] << endl;
        }

        delete sub;
        delete results;
        delete cards;
    }

    return 0;
}