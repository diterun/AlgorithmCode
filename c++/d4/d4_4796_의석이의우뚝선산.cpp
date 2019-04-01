#include <iostream>
using namespace std;

int T, t, n, result, pre, now, s, e, i;

int main(void){
    scanf("%d", &T);

    for(t = 1; t <= T; t++){
        result = s = e = 0;

        scanf("%d", &n);
        scanf("%d", &pre);

        for(i = 1; i < n; i++)
        {
            scanf("%d", &now);

            if(pre < now){
                if (e == -1) {
                    s++;
				} else {
					result += s * e;
					s = 1;
					e = -1;
				}
			} else if (pre > now) {
				if (e == -1) {
					e = 1;
				} else {
					e++;
				}
			}
			pre = now;
        }
        if(e > 0){
            result += s * e;
        }

        printf("#%d %d\n", t, result);
    }

    return 0;
}