#include<stdio.h>

#define MAX 1000001

int l, r, i, j;
long sum[MAX];

int main()
{
	int test_case;
	int T;

    for(i = 1; i < MAX; i++)
    {
        sum[i] += sum[i - 1];
        if(i % 2 == 0){
            continue;
        }
        for(j = i; j < MAX; j += i){
            sum[j] += i;
        }
    }

    scanf("%d", &T);
	for(test_case = 1; test_case <= T; ++test_case)
	{
        scanf("%d %d", &l, &r);

		printf("#%d %ld\n", test_case, sum[r] - sum[l -1]);
    }
	return 0;
}