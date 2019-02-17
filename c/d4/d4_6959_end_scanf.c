#include<stdio.h>

int size, sum, dNine, a;
char input[2002];

int main(int argc, char** argv)
{
	int test_case;
	int T;

    scanf("%d", &T);
	for(test_case = 1; test_case <= T; ++test_case)
	{
        sum = 0;
        size = 0;
        
        scanf("%s", &input);
        for(int i = 0; i < 2002; i++)
        {
            a = input[i] - '0';
            if(0 <= a && a <= 9){
                sum += a;
                size++;
            } else {
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