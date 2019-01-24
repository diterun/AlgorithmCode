#include<iostream>
using namespace std;

/*
50개 중에 36개 통과
H * W 크기의 웨이퍼에서
2 * 2 크기의 칩을 최대 몇 개 생산 가능한가?

5 <= H <= 10
5 <= W <= 25

0 가공 가능
1 가공 불가능
*/

int H, W;


    /*
    4가지 경우의 수에 따라서 움직인다.
    가능하면 1로 채우고 그 다음으로 넘어가고
    거기서 막히면 돌아온다.
    */
int maximumChipCnt2(int y, int x, int weiper[][27]){
    int cnt = 0;
    if(x >= W){
        if (y >= H){
            return cnt;
        } else {
            cnt += maximumChipCnt2(y + 2, 0, weiper);
            return cnt;
        }
    }

    if(weiper[y][x] == 0 && weiper[y][x + 1] == 0 && 
    weiper[y + 1][x] == 0 && weiper[y + 1][x + 1] == 0){
        weiper[y][x] = 1;
        weiper[y][x + 1] = 1;
        weiper[y + 1][x] = 1;
        weiper[y + 1][x + 1] = 1;

        cnt++;
    }
    else if(weiper[y][x + 1] == 0 && weiper[y][x + 2] == 0 && 
    weiper[y + 1][x + 1] == 0 && weiper[y + 1][x + 2] == 0){
        weiper[y][x + 1] = 1;
        weiper[y][x + 2] = 1;
        weiper[y + 1][x + 1] = 1;
        weiper[y + 1][x + 2] = 1;

        cnt++;
    }
    else if(weiper[y + 1][x] == 0 && weiper[y + 1][x + 1] == 0 && 
    weiper[y + 2][x] == 0 && weiper[y + 2][x + 1] == 0){
        weiper[y + 1][x] = 1;
        weiper[y + 1][x + 1] = 1;
        weiper[y + 2][x] = 1;
        weiper[y + 2][x + 1] = 1;

        cnt++;
    }
    else if(weiper[y + 1][x + 1] == 0 && weiper[y + 1][x + 2] == 0 && 
    weiper[y + 2][x + 1] == 0 && weiper[y + 2][x + 2] == 0){
        weiper[y + 1][x + 1] = 1;
        weiper[y + 1][x + 2] = 1;
        weiper[y + 2][x + 1] = 1;
        weiper[y + 2][x + 2] = 1;

        cnt++;
    }

    cnt += maximumChipCnt2(y, x + 2, weiper);

    return cnt;
}

int maximumChipCnt(int y, int x, int weiper[][27]){
    int cnt = 0;
    if(x >= W){
        if (y >= H){
            return cnt;
        } else {
            cnt += maximumChipCnt(y + 2, 0, weiper);
            return cnt;
        }
    }

    if(weiper[y][x] == 0 && weiper[y][x + 1] == 0 && 
    weiper[y + 1][x] == 0 && weiper[y + 1][x + 1] == 0){
        weiper[y][x] = 1;
        weiper[y][x + 1] = 1;
        weiper[y + 1][x] = 1;
        weiper[y + 1][x + 1] = 1;

        cnt++;
    }
    else if(weiper[y + 1][x] == 0 && weiper[y + 1][x + 1] == 0 && 
    weiper[y + 2][x] == 0 && weiper[y + 2][x + 1] == 0){
        weiper[y + 1][x] = 1;
        weiper[y + 1][x + 1] = 1;
        weiper[y + 2][x] = 1;
        weiper[y + 2][x + 1] = 1;

        cnt++;
    }
    else if(weiper[y][x + 1] == 0 && weiper[y][x + 2] == 0 && 
    weiper[y + 1][x + 1] == 0 && weiper[y + 1][x + 2] == 0){
        weiper[y][x + 1] = 1;
        weiper[y][x + 2] = 1;
        weiper[y + 1][x + 1] = 1;
        weiper[y + 1][x + 2] = 1;

        cnt++;
    }
    else if(weiper[y + 1][x + 1] == 0 && weiper[y + 1][x + 2] == 0 && 
    weiper[y + 2][x + 1] == 0 && weiper[y + 2][x + 2] == 0){
        weiper[y + 1][x + 1] = 1;
        weiper[y + 1][x + 2] = 1;
        weiper[y + 2][x + 1] = 1;
        weiper[y + 2][x + 2] = 1;

        cnt++;
    }

    cnt += maximumChipCnt(y, x + 2, weiper);

    return cnt;
}

void initialize(int weiper[][27]){
    for(int i = 0; i < 12; i++){
        for(int j = 0; j < 27; j++){
            weiper[i][j] = 1;
        }
    }
}

int main(int argc, char** argv)
{
	int test_case;
	int T;
    int weiper[12][27];

	cin>>T;

	for(test_case = 1; test_case <= T; ++test_case)
	{
        initialize(weiper);

        cin >> H >> W;

        for(int i = 0; i < H; i++){
            for(int j = 0; j < W; j++){
                cin >> weiper[i][j];
            }
        }

        int result = maximumChipCnt(0, 0, weiper);
        initialize(weiper);
        int sub_result = maximumChipCnt2(0, 0, weiper);

        result = result > sub_result ? result : sub_result;

        cout << "#" << test_case << " " << result << endl;
	}
	return 0;
}

/*
고민의 흔적스...

110 011 000 000
110 011 110 011
000 000 110 011

이런 식으로 0, 0에서 옆으로 두칸 아래로 두칸을 포함한
3*3의 크기 내에 총 4개의 경우가 있다. 물론 없는 경우도 있다.

이런 i, j에 대해서 각각 2씩 증가하면서 전부 다 돌아본다.
여기서 백트래킹을 쓴다...??


*/