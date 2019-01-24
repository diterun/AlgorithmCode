#include <iostream>
using namespace std;

int n, zero, cycle, point, i, t;
int num[8];

int main(void){
    for(t = 1; t <= 10; t++){
        cin >> n;
        cycle = 1;
        point = 0;

        for(i = 0; i < 8; i++){
            cin >> num[i];
        }

        do{
            zero = num[point];
            zero -= cycle;
            num[point] = zero > 0 ? zero : 0;
            cycle++;
            if(cycle > 5){
                cycle = 1;
            }
            point++;
            if(point > 7){
                point = 0;
            }
        } while(zero > 0);

        cout << "#" << t << " ";
        for(i = point; i < 8; i++){
            cout << num[i] << " ";
        }
        for(i = 0; i < point; i++){
            cout << num[i] << " ";
        }
        cout << endl;
    }
}