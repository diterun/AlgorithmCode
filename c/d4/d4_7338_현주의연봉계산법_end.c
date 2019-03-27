#include<stdio.h>

int main()
{
	int t, T;
    long long y, m, ry, rm;

    scanf("%d", &T);
	for(t = 1; t <= T; ++t)
	{
        scanf("%ld %ld", &y, &m);

        y = 2016 * 13 + (y - 2016) * 12 + m;
        ry = y / 13;
        rm = y % 13;
        if(rm == 0){
	    	printf("#%d %ld 13\n", t, ry - 1);
        } else {
	    	printf("#%d %ld %ld\n", t, ry, rm);
        }
    }
	return 0;
}