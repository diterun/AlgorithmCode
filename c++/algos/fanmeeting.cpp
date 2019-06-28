#include<iostream>
using namespace std;

int T, t, result;
string member;
string fan;

int main(void){
    cin >> T;

    for(t = 0; t < T; ++t){
        cin >> member;
        cin >> fan;

        int mlen = member.length();
        int flen = fan.length();
        result = flen - mlen + 1;

        int *whereMan = new int[mlen];
        int men = 0;
        for(int i = 0; i < mlen; ++i){
            if(member[i] == 'M'){
                whereMan[men++] = i;
            }
        }

        for(int i = 0; i <= flen - mlen; ++i){
            for(int j = 0; j < men; ++j){
                if(fan[i + whereMan[j]] == 'M'){
                    result--;
                    break;
                }
            }
        }

        cout << result << endl;

        delete whereMan;
    }

    return 0;
}