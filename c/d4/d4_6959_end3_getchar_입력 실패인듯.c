#include<stdio.h>

int size, sum, dNine;
char input;

int main(int argc, char** argv)
{
	int test_case;
	int T;

    T = getchar() - '0';
    getchar();
    getchar();
	for(test_case = 1; test_case <= T; ++test_case)
	{
        sum = 0;
        size = 0;
        
        input = getchar();
        while(input != '\n'){
            sum += input - '0';
            size++;

            input = getchar();
            if(input == 13 || input == -1){
                getchar();  // 테스트 케이스 3개 통과...
                break;
            }
        }

        dNine = sum / 9;
        if (sum % 9 == 0) {
            if(size % 2 == 0 && dNine % 2 != 0) {
                printf("#%d A\n", test_case);
            } else if(size % 2 != 0 && dNine % 2 == 0) {
                printf("#%d A\n", test_case);
            } else {
                printf("#%d B\n", test_case);
            }
        } else {
            if(size % 2 == 0 && dNine % 2 == 0) {
                printf("#%d A\n", test_case);
            } else if(size % 2 != 0 && dNine % 2 != 0) {
                printf("#%d A\n", test_case);
            } else {
                printf("#%d B\n", test_case);
            }
        }
    }
	return 0;
}