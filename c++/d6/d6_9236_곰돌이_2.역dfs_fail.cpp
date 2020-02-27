#include<iostream>
#include<queue>
using namespace std;

#define MAX 800
#define getMax(a, b) (a > b ? a : b)
#define getMin(a, b) (a < b ? a : b)

void init();
void input();
void draw_bee_footpoint();
void print_bt();
void move_gom(int x, int y, int moves, int move_cnt, int path_num);

int T, t, n, s, i, j;
int result;
char field[MAX][MAX];
int bee_trace[MAX][MAX];
bool gom_visit[MAX][MAX];
int gomx, gomy, homex, homey;
queue<pair<int, int>> beeq;
int dir[4][2] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

int process(){
    draw_bee_footpoint();
    print_bt();
    
    move_gom(gomx, gomy, 0, s, 10000);
}

void move_gom(int x, int y, int moves, int move_cnt, int path_num){
    // cout << x << ", " << y << " path : " << path_num << ", result : " << result << endl;
    // 집을 찾았으면 result 갱신하기~
    if(x == homex && y == homey){
        result = getMax(result, path_num);
        return;
    }
    // 지금까지의 결과보다 path 효율이 안 좋으면 끝내기...
    if(path_num <= result){
        return;
    }
    // 갱신 할 수 없으면 그대로 죽기 ㅠㅠ
    if(path_num == -1){
        return;
    }

    for(int k = 0; k < 4; k++){
        int dx = x + dir[k][0];
        int dy = y + dir[k][1];

        if(dx >= 0 && dx < n && dy >= 0 && dy < n && (field[dx][dy] == 'G' || field[dx][dy] == 'D') && !gom_visit[dx][dy]){
            if(move_cnt == 0){
                int new_path_num = getMin(path_num, bee_trace[dx][dy] - moves);
                // s의 마지막 발자국에서는 4방향에 벌이 있는지도 검사해야한다!!
                if(dx > 0 && bee_trace[dx - 1][dy] != -2){
                    new_path_num = getMin(path_num, bee_trace[dx - 1][dy] - moves);
                }
                if(dx < n && bee_trace[dx + 1][dy] != -2){
                    new_path_num = getMin(path_num, bee_trace[dx + 1][dy] - moves);
                }
                if(dy > 0 && bee_trace[dx][dy - 1] != -2){
                    new_path_num = getMin(path_num, bee_trace[dx][dy - 1] - moves);
                }
                if(dy < n && bee_trace[dx][dy + 1] != -2){
                    new_path_num = getMin(path_num, bee_trace[dx][dy + 1] - moves);
                }
                // 재귀함수를 들어갈 때는 밟은 것으로 치지만 역으로 나올 때는 아직 가지 않은 곳이라고 생각합니다.
                gom_visit[dx][dy] = true;
                move_gom(dx, dy, moves + 1, s, new_path_num);
                gom_visit[dx][dy] = false;
            } else {
                int new_path_num = getMin(path_num, bee_trace[dx][dy] - moves);
                gom_visit[dx][dy] = true;
                move_gom(dx, dy, moves, move_cnt - 1, new_path_num);
                gom_visit[dx][dy] = false;
            }
        }
    }
}

void draw_bee_footpoint(){
    // 벌을 먼저 움직여서 벌의 자취를 그려줍니다.
    int bee_point = 0;
    while(!beeq.empty()){
        int bees = beeq.size();
        for(i = 0; i < bees; i++){
            pair<int, int> nb = beeq.front();
            beeq.pop();
            int nx = nb.first;
            int ny = nb.second;

            for(j = 0; j < 4; j++){
                int dx = nx + dir[j][0];
                int dy = ny + dir[j][1];

                if(dx >= 0 && dx < n && dy >= 0 && dy < n &&
                (field[dx][dy] == 'G' || field[dx][dy] == 'D') && bee_trace[dx][dy] == -2){
                    // 벌이 n분에 출발했을 때의 자취를 그려줍니다.
                    bee_trace[dx][dy] = bee_point;
                    beeq.push(make_pair(dx, dy));
                }
            }
        }

        bee_point++;
    }
}

int main(){
    n = MAX;
	cin >> T;

	for(t = 1; t <= T; t++){
        init();
        input();
        process();
        cout << "#" << t << " " << result << endl;
	}
	return 0;
}

void print_bt(){
    for(int aa = 0; aa < n; aa++){
        for(int bb = 0; bb < n; bb++){
            cout << bee_trace[aa][bb] << " ";
        }
        cout << endl;
    }
}

void input(){
    cin >> n >> s;
    s--;
    for(i = 0; i < n; i++){
        cin >> field[i];
    }

    for(i = 0; i < n; i++){
        for(j = 0; j < n; j++){
            if(field[i][j] == 'M'){
                field[i][j] = 'G';
                gomx = i;
                gomy = j;
            } else if(field[i][j] == 'H'){
                bee_trace[i][j] = -1;
                beeq.push(make_pair(i, j));
            } else if(field[i][j] == 'D'){
                homex = i;
                homey = j;
            }
        }
    }
}

void init(){
    for(i = 0; i < n; i++){
        for(j = 0; j < n; j++){
            bee_trace[i][j] = -2;
            gom_visit[i][j] = false;
        }
    }
    while(!beeq.empty()){
        beeq.pop();
    }
    n = s = 0;
    result = -1;
}
