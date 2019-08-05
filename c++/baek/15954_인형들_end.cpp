#include <iostream>
#include <cmath>
using namespace std;

#define MAX 501

int n, k, i, j, l;
double dolls[MAX];
double result;

double binomial(double a);
double getMin(double a, double b);
void inputData();
void initial();

int main(void){
    initial();
    inputData();

    for(i = 0; i < n - k + 1; i++){
        for(l = n - i; l >= k; l--){
            double avg = 0;
            double variance = 0;
            
            for(j = i; j < i + l; j++){
                avg += dolls[j];
            }
            avg /= l;

            for(j = i; j < i + l; j++){
                variance += binomial(dolls[j] - avg);
            }
            variance /= l;

            result = getMin(result, sqrt(variance));
        }
    }

    cout.precision(11);
    cout << fixed << result << endl;
    return 0;
}

double binomial(double a){
    return a * a;
}

double getMin(double a, double b){
    return a < b ? a : b;
}

void inputData(){
    cin >> n >> k;

    for(i = 0; i < n; i++){
        cin >> dolls[i];
    }
}

void initial(){
    result = 10000000000000000;
    for(i = 0; i < MAX; i++){
        dolls[i] = 0;
    }
}