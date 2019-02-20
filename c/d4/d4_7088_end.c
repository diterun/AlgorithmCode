#include<stdio.h>

#define MAX 100001

int n, q, l, r, a, i;
int left[MAX][4];

int main()
{
	int test_case;
	int T;

    left[0][1] = 0;
    left[0][2] = 0;
    left[0][3] = 0;

    scanf("%d", &T);
	for(test_case = 1; test_case <= T; ++test_case)
	{
        scanf("%d %d", &n, &q);
			
        for (i = 1; i <= n; i++) {
            scanf("%d", &a);

            left[i][1] = left[i - 1][1];
            left[i][2] = left[i - 1][2];
            left[i][3] = left[i - 1][3];
            
            left[i][a]++;
        }
		printf("#%d\n", test_case);

        for (i = 0; i < q; i++) {
            scanf("%d %d", &l, &r);
            printf("%d %d %d\n", left[r][1] - left[l - 1][1], left[r][2] - left[l - 1][2], left[r][3] - left[l - 1][3]);
        }
    }
	return 0;
}