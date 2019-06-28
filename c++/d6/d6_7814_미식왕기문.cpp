#include<iostream>
using namespace std;

int n, ilv, elv, points, milv, melv;
int result;
bool can;

int main()
{
	int test_case;
	int T;

	cin >> T;

	for(test_case = 1; test_case <= T; ++test_case)
	{
        result = points = 0;
        ilv = elv = 1;
        milv = melv = 1;
        can = true;

        cin >> n;
        int jmt[n][3];
        bool check[n];

        for(int i = 0; i < n; i++){
            cin >> jmt[i][0] >> jmt[i][1] >> jmt[i][2];
            check[i] = false;
        }

        while(can){
            can = false;
            int temp = 0;

            for(int i = 0; i <= points; i++){
                int tilv = ilv + i;
                int telv = elv + points - i;
                int sumOfPoints = 0;

                for(int j = 0; j < n; j++){
                    if(!check[j] && (tilv >= jmt[j][0] || telv >= jmt[j][1])){
                        sumOfPoints += jmt[j][2];
                    }
                }

                if(temp < sumOfPoints){
                    milv = tilv;
                    melv = telv;
                    temp = sumOfPoints;
                    can = true;
                } else if(temp == sumOfPoints){
                    if(sumOfPoints != 0 && (i <= (points / 2))){
                        milv = tilv;
                        melv = telv;
                    }
                }
            }

            ilv = milv;
            elv = melv;
            points = temp;
            
            for(int i = 0; i < n; i++){
                if(!check[i] && (ilv >= jmt[i][0] || elv >= jmt[i][1])){
                    check[i] = true;
                }
            }
        }

        for(int i = 0; i < n; i++){
            if(check[i]){
                result++;
            }
        }

        cout << "#" << test_case << " " << result << endl;
	}
	return 0;
}