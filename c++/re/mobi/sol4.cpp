#include <iostream>
#include <vector>
#include <map>
using namespace std;

int solution(int T);

int main() {
	printf("%d\n", solution(2));
	printf("%d\n", solution(4));
	printf("%d\n", solution(1));
	printf("%d\n", solution(100000));
	return 0;
}

long long alpha[3][10];
long long modp = 1000000007;

int solution(int T) {
	for(int i = 0; i < 3; i++){
		for(int j = 0; j < 10; j++){
			alpha[i][j] = 0;
		}
	}
	alpha[1][6] = 1;

	for(int i = 0; i < T; i++){
		if(i % 2 == 0){
			alpha[0][0] = alpha[0][1] + alpha[1][0];
			alpha[2][0] = alpha[2][1] + alpha[1][0];
			alpha[1][1] = alpha[1][0] + alpha[0][1] + alpha[2][1] + alpha[1][2];
			alpha[0][2] = alpha[0][1] + alpha[0][3] + alpha[1][2];
			alpha[2][2] = alpha[2][1] + alpha[2][3] + alpha[1][2];
			alpha[1][3] = alpha[1][2] + alpha[1][4] + alpha[0][3] + alpha[2][3];
			alpha[0][4] = alpha[0][3] + alpha[0][5] + alpha[1][4];
			alpha[2][4] = alpha[2][3] + alpha[2][5] + alpha[1][4];
			alpha[1][5] = alpha[1][4] + alpha[1][6] + alpha[0][5] + alpha[2][5];
			alpha[0][6] = alpha[0][5] + alpha[0][7] + alpha[1][6];
			alpha[2][6] = alpha[2][5] + alpha[1][6];
			alpha[1][7] = alpha[1][6] + alpha[1][8] + alpha[0][7];
			alpha[0][8] = alpha[0][7] + alpha[0][9] + alpha[1][8];
			alpha[1][0] = 0;
			alpha[0][1] = 0;
			alpha[2][1] = 0;
			alpha[1][2] = 0;
			alpha[0][3] = 0;
			alpha[2][3] = 0;
			alpha[1][4] = 0;
			alpha[0][5] = 0;
			alpha[2][5] = 0;
			alpha[1][6] = 0;
			alpha[0][7] = 0;
			alpha[1][8] = 0;
			alpha[0][9] = 0;
		} else {
			alpha[1][0] = alpha[0][0] + alpha[1][1] + alpha[2][0];
			alpha[0][1] = alpha[0][0] + alpha[0][2] + alpha[1][1];
			alpha[2][1] = alpha[2][0] + alpha[2][2] + alpha[1][1];
			alpha[1][2] = alpha[1][1] + alpha[1][3] + alpha[0][2] + alpha[2][2];
			alpha[0][3] = alpha[0][2] + alpha[0][4] + alpha[1][3];
			alpha[2][3] = alpha[2][2] + alpha[2][4] + alpha[1][3];
			alpha[1][4] = alpha[1][3] + alpha[1][5] + alpha[0][4] + alpha[2][4];
			alpha[0][5] = alpha[0][4] + alpha[0][6] + alpha[1][5];
			alpha[2][5] = alpha[2][4] + alpha[2][6] + alpha[1][5];
			alpha[1][6] = alpha[1][5] + alpha[1][7] + alpha[0][6] + alpha[2][6];
			alpha[0][7] = alpha[0][6] + alpha[0][8] + alpha[1][7];
			alpha[1][8] = alpha[1][7] + alpha[0][8];
			alpha[0][9] = alpha[0][8];
			alpha[0][0] = 0;
			alpha[2][0] = 0;
			alpha[1][1] = 0;
			alpha[0][2] = 0;
			alpha[2][2] = 0;
			alpha[1][3] = 0;
			alpha[0][4] = 0;
			alpha[2][4] = 0;
			alpha[1][5] = 0;
			alpha[0][6] = 0;
			alpha[2][6] = 0;
			alpha[1][7] = 0;
			alpha[0][8] = 0;
		}

		for(int ii = 0; ii < 3; ii++){
			for(int j = 0; j < 10; j++){
				if(alpha[ii][j] >= modp){
					alpha[ii][j] %= modp;
				}
			}
		}
	}

    return alpha[1][6];
}