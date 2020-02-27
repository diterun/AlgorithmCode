#include<iostream>
#include<queue>
using namespace std;

#define MAX 800

void init();
void input();
bool can_move(int x, int y, int cnt);
bool lost_home();

int T, t, n, s, i, j, k;
int result;
char origin_field[MAX][MAX];
char real_field[MAX][MAX];
queue<pair<int, int>> gomq;
int gom_trace[MAX][MAX];
int now_gom_cnt;
queue<pair<int, int>> beeq;
int dir[4][2] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
int homex;
int homey;

int process(){
    int honey_time = 0;
    while(true){
        bool cant = true;

        for(i = 0; i < honey_time; i++){
            // 움직이벌!
            int bees = beeq.size();
            for(j = 0; j < bees; j++){
                pair<int, int> nb = beeq.front();
                beeq.pop();
                int nx = nb.first;
                int ny = nb.second;
            
                for(k = 0; k < 4; k++){
                    int dx = nx + dir[k][0];
                    int dy = ny + dir[k][1];

                    if(dx >= 0 && dx < n && dy >= 0 && dy < n){
                        if(real_field[dx][dy] == 'G'){
                            real_field[dx][dy] = 'H';
                            beeq.push(make_pair(dx, dy));
                        }
                    }
                }
            }
        }
        // for(i = 0; i < n; i++){
        //     for(int l = 0; l < n; l++){
        //         cout << real_field[i][l] << " ";
        //     }
        //     cout << endl;
        // }

        while(true){
            // 움직이자곰!
            for(j = s + 1; j > 0; j--){
                int goms = gomq.size();
                for(i = 0; i < goms; i++){
                    pair<int, int> ng = gomq.front();
                    gomq.pop();
                    int nx = ng.first;
                    int ny = ng.second;

                    gom_trace[nx][ny] = j;
                
                    for(k = 0; k < 4; k++){
                        int dx = nx + dir[k][0];
                        int dy = ny + dir[k][1];

                        if(dx >= 0 && dx < n && dy >= 0 && dy < n){
                            if(can_move(dx, dy, j - 1)){
                                if(real_field[dx][dy] == 'D'){
                                    cant = false;
                                }
                                gom_trace[dx][dy] = j - 1;
                                gomq.push(make_pair(dx, dy));
                            }
                        }
                    }
                }
            }

            // 움직이벌!
            int bees = beeq.size();
            for(i = 0; i < bees; i++){
                pair<int, int> nb = beeq.front();
                beeq.pop();
                int nx = nb.first;
                int ny = nb.second;
            
                for(k = 0; k < 4; k++){
                    int dx = nx + dir[k][0];
                    int dy = ny + dir[k][1];

                    if(dx >= 0 && dx < n && dy >= 0 && dy < n){
                        if(real_field[dx][dy] == 'G'){
                            real_field[dx][dy] = 'H';
                            beeq.push(make_pair(dx, dy));
                        }
                    }
                }
            }
            // for(i = 0; i < n; i++){
            //     for(int l = 0; l < n; l++){
            //         cout << gom_trace[i][l] << " ";
            //     }
            //     cout << endl;
            // }
            // for(i = 0; i < n; i++){
            //     for(int l = 0; l < n; l++){
            //         cout << real_field[i][l] << " ";
            //     }
            //     cout << endl;
            // }

            if(lost_home()){
                break;
            }
            if(!cant){
                break;
            }
        }

        // cout << cant << endl;
        // cout << "result ??? " << honey_time << endl;

        if(cant){
            return honey_time - 1;
        }

        // 꿀먹는 시간을 늘리고
        honey_time++;
        // 원래 map으로 초기화를 해줍니다.
        while(!gomq.empty()){
            gomq.pop();
        }
        while(!beeq.empty()){
            beeq.pop();
        }
        for(i = 0; i < n; i++){
            for(j = 0; j < n; j++){
                real_field[i][j] = origin_field[i][j];
                if(real_field[i][j] == 'M'){
                    gomq.push(make_pair(i, j));
                    real_field[i][j] = 'G';
                } else if(real_field[i][j] == 'H'){
                    beeq.push(make_pair(i, j));
                }
                gom_trace[i][j] = -1;
            }
        }
    }
}

bool can_move(int x, int y, int cnt){
    if(real_field[x][y] == 'G' || real_field[x][y] == 'D'){
        if(gom_trace[x][y] < cnt){
            if(cnt == 0){
                if(x > 0){
                    if(real_field[x - 1][y] == 'H'){
                        return false;
                    }
                }
                if(x < MAX){
                    if(real_field[x + 1][y] == 'H'){
                        return false;
                    }
                }
                if(y > 0){
                    if(real_field[x][y - 1] == 'H'){
                        return false;
                    }
                }
                if(y < MAX){
                    if(real_field[x][y + 1] == 'H'){
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }
    return false;
}

bool lost_home(){
    if(homex > 0){
        if(real_field[homex - 1][homey] == 'G'){
            return false;
        }
    }
    if(homex < MAX){
        if(real_field[homex + 1][homey] == 'G'){
            return false;
        }
    }
    if(homey > 0){
        if(real_field[homex][homey - 1] == 'G'){
            return false;
        }
    }
    if(homey < MAX){
        if(real_field[homex][homey + 1] == 'G'){
            return false;
        }
    }
    return true;
}

int main(){
    n = MAX;
	cin >> T;

	for(t = 1; t <= T; t++){
        init();
        input();
        cout << "#" << t << " " << process() << endl;
	}
	return 0;
}

void input(){
    cin >> n >> s;
    for(i = 0; i < n; i++){
        cin >> origin_field[i];
    }

    for(i = 0; i < n; i++){
        for(j = 0; j < n; j++){
            real_field[i][j] = origin_field[i][j];
            if(real_field[i][j] == 'M'){
                gomq.push(make_pair(i, j));
                real_field[i][j] = 'G';
                gom_trace[i][j] = s;
            } else if(real_field[i][j] == 'H'){
                beeq.push(make_pair(i, j));
            } else if(real_field[i][j] == 'D'){
                homex = i;
                homey = j;
            }
        }
    }
}

void init(){
    for(i = 0; i < n; i++){
        for(j = 0; j < n; j++){
            origin_field[i][j] = 'T';
            gom_trace[i][j] = -1;
        }
    }
    while(!gomq.empty()){
        gomq.pop();
    }
    while(!beeq.empty()){
        beeq.pop();
    }
    n = s = 0;
    result = 0;
}
