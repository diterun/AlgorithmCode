#include<iostream>
using namespace std;

#define MAX 100001

int lefts[MAX][4];

int main()
{
	int test_case;
	int T;
    register int n, q, l, r, a, i;

    lefts[0][1] = 0;
    lefts[0][2] = 0;
    lefts[0][3] = 0;

    scanf("%d", &T);
	for(test_case = 1; test_case <= T; ++test_case)
	{
        scanf("%d %d", &n, &q);
			
        for (i = 1; i <= n; i++) {
            scanf("%d", &a);

            lefts[i][1] = lefts[i - 1][1];
            lefts[i][2] = lefts[i - 1][2];
            lefts[i][3] = lefts[i - 1][3];
            
            lefts[i][a]++;
        }
		printf("#%d\n", test_case);

        for (i = 0; i < q; i++) {
            scanf("%d %d", &l, &r);
            printf("%d %d %d\n", lefts[r][1] - lefts[l - 1][1], lefts[r][2] - lefts[l - 1][2], lefts[r][3] - lefts[l - 1][3]);
        }
    }
	return 0;
}