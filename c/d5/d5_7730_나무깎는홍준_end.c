#include<stdio.h>

#define MAX 1000001

int n, m, i, mymax, mymin;
int trees[MAX];
int result;
 
int main(int argc, char** argv)
{
    int test_case;
    int T;

    scanf("%d", &T);
 
    for(test_case = 1; test_case <= T; ++test_case)
    {
        result = n = m = mymin = 0;
        mymax = 1000000001;
        scanf("%d %d", &n, &m);
        for(i = 0; i < n; ++i){
            scanf("%d", &trees[i]);
        }

        while(mymin < mymax - 1){
            int mymid = (mymin + mymax) / 2;
            printf("min=%d, max=%d : %d\n", mymin, mymax, mymid);
            long sum = 0;

            for(i = 0; i < n; ++i){
                if(trees[i] > mymid){
                    sum += (trees[i] - mymid);
                }
            }

            if(sum == m){
                mymin = mymid;
                break;
            } else if(sum > m){
                mymin = mymid;
            } else {
                mymax = mymid - 1;
            }
        }

        printf("#%d %ld\n", test_case, mymin);
        for(i = 0; i < n; ++i){
            trees[i] = 0;
        }
    }
    return 0;
}