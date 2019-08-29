#include <iostream>
#include <vector>
using namespace std;

#define MAX 1010
#define getMin(a, b)(a < b ? a : b)

int T, t, n, result, a, b, c ,d;
int mymap[MAX * 2][MAX * 2][2];
int mymove[4][2] = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

class ob{
public:
    int y;
    int x;
    int dir;
    int point;
    bool sv;

    void moveTo(){
        y = mymove[dir][0];
        x = mymove[dir][1];
    }
};

ob* obs;

void moveAndBoom();

int main(void){
    scanf("%d", &T);

    for(t = 1; t <= T; t++){
        result = 0;

        scanf("%d", &n);
        obs = new ob[n + 1];
        for(int i = 1; i <= n; i++){
            scanf("%d %d %d %d", &a, &b, &c, &d);

            obs[i].x = a + MAX;
            obs[i].y = b + MAX;
            obs[i].dir = c;
            obs[i].point = d;
            obs[i].sv = true;

            mymap[obs[i].y][obs[i].x][0] = i;
            mymap[obs[i].y][obs[i].x][1] = obs[i].point;
        }

        moveAndBoom();

        if(result == 10){
            printf("#%d -1\n", t);
        } else {
            printf("#%d %d\n", t, result);
        }

        delete obs;
    }

    return 0;
}

void moveAndBoom(){
    int time = 0;
    vector<int> q;

    for(time = 0; time < MAX * 2; time++){
        for(int i = 1; i <= n; i++){
            if(obs[i].sv){
                mymap[obs[i].y][obs[i].x][0] -= i;
                mymap[obs[i].y][obs[i].x][1] -= obs[i].point;

                obs[i].moveTo();

                if(mymap[obs[i].y][obs[i].x][0] == 0){
                    mymap[obs[i].y][obs[i].x][0] = i;
                    mymap[obs[i].y][obs[i].x][1] = obs[i].point;

                    continue;
                }

                if(i > mymap[obs[i].y][obs[i].x][0]){
                    mymap[obs[i].y][obs[i].x][1] += obs[i].point;
                } else {
                    mymap[obs[i].y][obs[i].x][0] += i;
                    mymap[obs[i].y][obs[i].x][1] += obs[i].point;
                }
            }
        }

        q.clear();
    }
}