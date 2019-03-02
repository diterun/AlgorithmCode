#include<stdio.h>

#define MAX 30003

int n, one, twoM, i, j, nam1, nam2, max, maxi;
int fails[3], two[3];
char a, b, c;
char m[MAX];
char jj[MAX];
char g[MAX];
 
int main(int argc, char** argv)
{
    int test_case;
    int T;

    scanf("%d", &T);
 
    for(test_case = 1; test_case <= T; ++test_case)
    {
        scanf("%d", &n);
        scanf("%s", &m);
        scanf("%s", &jj);
        scanf("%s", &g);
        for (i = 0; i < 3; i++) {
            fails[i] = n;
            two[i] = 0;
        }
        one = 0;

        for (i = 0; i < n; i++) {
            a = m[i];
            b = jj[i];
            c = g[i];

            if (a == b && a == c) {
                fails[0]--;
                fails[1]--;
                fails[2]--;
            } else if (a == b && !(a == c)) {
                two[2]++;
            } else if (!(a == b) && a == c) {
                two[1]++;
            } else if (!(a == b) && b == c) {
                two[0]++;
            } else {
                one++;
            }
        }

        twoM = two[0] < two[1] ? two[0] : two[1];
        twoM = twoM < two[2] ? twoM : two[2];

        for (i = 0; i < 3; i++) {
            fails[i] -= twoM * 2;
            two[i] -= twoM;
        }

        twoM = 0;
        for (i = 0; i < 3; i++) {
            if (two[i] == 0) {
                nam1 = (i + 1) % 3;
                nam2 = (i + 2) % 3;
                if (two[nam1] != 0 && two[nam2] != 0) {
                    twoM = two[nam1] < two[nam2] ? two[nam1] : two[nam2];
                    
                    fails[i] -= twoM * 2;
                    fails[nam1] -= twoM;
                    fails[nam2] -= twoM;
                    two[nam1] -= twoM;
                    two[nam2] -= twoM;
                }
            }
        }

        twoM = 0;
        for (i = 0; i < 3; i++) {
            if (two[i] > 0) {
                if(two[i] < one) {
                    one -= two[i];
                    for (j = 0; j < 3; j++) {
                        fails[j] -= two[i];
                    }
                } else {
                    twoM = one;
                    two[i] -= one;
                    one = 0;
                    
                    twoM += two[i] / 2;
                    two[i] %= 2;
                    
                    for (j = 0; j < 3; j++) {
                        fails[j] -= twoM;
                    }
                    fails[(i + 1) % 3] -= two[i];
                    fails[(i + 2) % 3] -= two[i];
                }
            }
        }

        if(one != 0) {
            for (i = 0; i < one; i++) {
                max = 0;
                maxi = 0;
                for (j = 0; j < 3; j++) {
                    if(max < fails[j]) {
                        max = fails[j];
                        maxi = j;
                    }
                }
                fails[maxi]--;
            }
        }
 
        max = 0;
        maxi = 0;
        for (j = 0; j < 3; j++) {
            if(max < fails[j]) {
                max = fails[j];
                maxi = j;
            }
        }

        printf("#%d %d\n", test_case, n - fails[maxi]);
    }
    return 0;
}