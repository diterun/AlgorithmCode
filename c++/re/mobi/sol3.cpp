#include <iostream>
#include <vector>
#include <map>
using namespace std;

#define getMax(a, b) (a > b ? a : b)
#define getMin(a, b) (a < b ? a : b)

int solution(vector<string> board);

int main() {
	vector<string> a = {"ABCBA","DABAG","EBABH","FAJAI","AKLMA"};

	printf("%d\n", solution(a));

	return 0;
}

bool canX(char c, char rd, char lr, char ru, char lu){
	return c == rd && c == lr && c == ru && c == lu;
}

int solution(vector<string> board) {
    int answer = 0;
	int row = board.size();
	int col = board[0].length();

	for(int i = 0; i < row; i++){
		for(int j = 0; j < col; j++){
			char now = board[i][j];
			int nowMax = 1000;
			nowMax = getMin(nowMax, i);
			nowMax = getMin(nowMax, j);
			nowMax = getMin(nowMax, row - i - 1);
			nowMax = getMin(nowMax, col - j - 1);

			if((nowMax * 2) + 1 <= answer){
				continue;
			}

			for(int k = 1; k <= nowMax; k++){
				if(canX(now, board[i + k][j + k], board[i + k][j - k], board[i - k][j + k], board[i - k][j - k])){
					answer = getMax(answer, (k * 2) + 1);
				} else {
					break;
				}
			}
		}
	}

    return answer;
}