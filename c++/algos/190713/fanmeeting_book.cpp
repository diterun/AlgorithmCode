#include<iostream>
using namespace std;

int T, t, result;
string member;
string fan;

int* karatsuba(int* mMen, int* fMen, int mlen, int flen){
    int subresult[flen];

    for(int i = 0; i < mlen; ++i){
        for(int j = 0; j < flen; ++j){
            subresult[i + j] += mMen[i] * fMen[j];
        }
    }

    return subresult;
}

int main(void){
    cin >> T;

    for(t = 0; t < T; ++t){
        result = 0;

        cin >> member;
        cin >> fan;

        int mlen = member.length();
        int flen = fan.length();

        int mMen[mlen];
        int fMen[flen];
        for(int i = 0; i < mlen; ++i){
            mMen[i] = (member[i] == 'M');
        }

        for(int i = 0; i < flen; ++i){
            fMen[flen - i - 1] = (fan[i] == 'M');
        }

        int* re = karatsuba(mMen, fMen, mlen, flen);

        cout << result << endl;
    }

    return 0;
}