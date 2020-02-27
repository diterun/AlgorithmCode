#include <iostream>
#include <vector>
using namespace std;

#define MAX 1000000000L
#define STACK_MAX 1001
#define INPUT_MAX 20
/*
NUM X: X를 스택의 가장 위에 저장한다. (0 ≤ X ≤ 109)
POP: 스택 가장 위의 숫자를 제거한다.
INV: 첫 번째 수의 부호를 바꾼다. (42 -> -42)
DUP: 첫 번째 숫자를 하나 더 스택의 가장 위에 저장한다.
SWP: 첫 번째 숫자와 두 번째 숫자의 위치를 서로 바꾼다.
ADD: 첫 번째 숫자와 두 번째 숫자를 더한다.
SUB: 첫 번째 숫자와 두 번째 숫자를 뺀다. (두 번째 - 첫 번째)
MUL: 첫 번째 숫자와 두 번째 숫자를 곱한다.
DIV: 첫 번째 숫자로 두 번째 숫자를 나눈 몫을 저장한다. 두 번째 숫자가 피제수, 첫 번째 숫자가 제수이다.
MOD: 첫 번째 숫자로 두 번째 숫자를 나눈 나머지를 저장한다. 두 번째 숫자가 피제수, 첫 번째 숫자가 제수이다.

1. 숫자가 부족해서 연산을 수행할 수 없을 때,
2. 0으로 나눴을 때 (DIV, MOD),
3. 연산 결과의 절댓값이 109를 넘어갈 때는 모두 프로그램 에러이다.
*/
char commands[10][10] = {"SWP", "DIV", "MOD", "SUB", "ADD","MUL","NUM", "POP"};

// 0, 1, 0, 2, 4, 3 

// 0~1 1
// 0~5 2


vector<pair<string, long long>> comms;    // 기계의 command set
long long mstack[STACK_MAX];  // 현재의 스택 상황
int sindex = 0;         // 스택의 index
int n = 0;              // 기계를 몇 번 반복 할 것인가?
char inputLine[INPUT_MAX];

void init(){
    comms.clear();
    sindex = 0;
    n = 0;
}

int operation(long long number){
    mstack[sindex] = number;
    int comLen = comms.size();

    for(int i = 0; i < comLen; i++){
        string com = comms[i].first;
        switch (com[0]){
        case 'N':
            sindex++;
            mstack[sindex] = comms[i].second;
            break;
        case 'P':
            if(sindex == 0){
                return -1;
                // i = comLen;
                // error = true;
                // break;
            }
            sindex--;
            break;
        case 'I':
            mstack[sindex] = -mstack[sindex];
            break;
        case 'D':
            if(com[1] == 'U'){
                sindex++;
                mstack[sindex] = mstack[sindex - 1];
            } else {
                if(sindex < 1){
                    return -1;
                }
                if(mstack[sindex] == 0){
                    return -1;
                }
                int moreLessZero = 0;

                if(mstack[sindex] < 0){
                    mstack[sindex] = -mstack[sindex];
                    moreLessZero++;
                }
                if(mstack[sindex - 1] < 0){
                    mstack[sindex - 1] = -mstack[sindex - 1];
                    moreLessZero++;
                }
                mstack[sindex - 1] = mstack[sindex - 1] / mstack[sindex];
                sindex--;
                if(moreLessZero % 2 == 1){
                    mstack[sindex] = -mstack[sindex];
                }
            }
            break;
        case 'S':
            if(sindex < 1){
                return -1;
            }
            if(com[1] == 'U'){
                mstack[sindex - 1] = mstack[sindex - 1] - mstack[sindex];
                sindex--;
                if(mstack[sindex] > MAX || mstack[sindex] < -MAX){
                    return -1;
                }
            } else {
                long long temp = mstack[sindex - 1];
                mstack[sindex - 1] = mstack[sindex];
                mstack[sindex] = temp;
            }
            break;
        case 'A':
            if(sindex < 1){
                return -1;
            }
            mstack[sindex - 1] = mstack[sindex - 1] + mstack[sindex];
            sindex--;
            if(mstack[sindex] > MAX || mstack[sindex] < -MAX){
                return -1;
            }
            break;
        case 'M':
            if(sindex < 1){
                return -1;
            }
            if(com[1] == 'U'){
                mstack[sindex - 1] = mstack[sindex - 1] * mstack[sindex];
                sindex--;
                if(mstack[sindex] > MAX || mstack[sindex] < -MAX){
                    return -1;
                }
            } else {
                if(mstack[sindex] == 0){
                    return -1;
                }
                int moreLessZero = 0;

                if(mstack[sindex] < 0){
                    mstack[sindex] = -mstack[sindex];
                    moreLessZero++;
                }
                if(mstack[sindex - 1] < 0){
                    mstack[sindex - 1] = -mstack[sindex - 1];
                    moreLessZero++;
                }
                mstack[sindex - 1] = mstack[sindex - 1] % mstack[sindex];
                sindex--;
                if(moreLessZero % 2 == 1){
                    mstack[sindex] = -mstack[sindex];
                }
            }
            break;
        case 'E':
            i = comLen;
            break;
        default:
            break;
        }
    }

    if (sindex == 0){
        return mstack[0];
    } else {
        return -1;
    }
}

void process(){
    while(true){
        cin.getline(inputLine, INPUT_MAX);
        if(inputLine[0] == 'Q'){    // QUIT 명령어이기 때문에 process 종료
            break;
        } else if('A' <= inputLine[0] && inputLine[0] <= 'Z'){
            if(inputLine[0] == 'N'){    // NUM 명령어만이 뒤에 숫자를 가짐
                char com[5]; 
                char num[11];
                for(int i = 0; i < 3; i++){
                    com[i] = inputLine[i];
                }
                for(int i = 0; i < 11; i++){
                    num[i] = inputLine[i + 4];
                }
                long long number = atoi(num);
                comms.push_back(make_pair(com, number));
            } else {
                comms.push_back(make_pair(inputLine, 0));
            }
        } else if('0' <= inputLine[0] && inputLine[0] <= '9'){  // 숫자가 들어오면 몇 번을 시행하고 출력해야 할지 입력
            long long number = atoi(inputLine);
            if(n == 0){
                n = number;
            } else {
                int result = operation(number);

                if(result == -1){
                    cout << "ERROR" << endl;
                } else {
                    cout << result << endl;
                }
                sindex = 0;
            }
        } else {    // 행간이기 때문에 하나의 기계 종료
            init();
        }
    }
}

int main(void){
    process();
    return 0;
}