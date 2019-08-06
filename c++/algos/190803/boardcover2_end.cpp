#include<iostream>
#include<vector>
using namespace std;

#define MAX 10

int T, t, h, w, r, c, i, j, result;
int emptyArea, blockArea, sameBlock;
char map[MAX][MAX];
char block[MAX][MAX];
vector<pair<int, int>> blocks[4];

void initial();
void inputNmakeblock();
void progress(int ny, int nx, int useCnt, int emptyArea);
int getMax(int a, int b);
bool canDrop(int ny, int nx, int type);
void dropBlock(int ny, int nx, int type, char b);

int main(void){
    cin >> T;

    for(t = 0; t < T; ++t){
        initial();
        inputNmakeblock();

        progress(0, 0, 0, emptyArea);

        cout << result << endl;
    }

    return 0;
}

void progress(int ny, int nx, int useCnt, int emptyArea){
    /* 맨 끝에 도달하면 result를 구하고 끝낸다. */
    if(ny == h - 1 && nx == w - 1){
        result = getMax(result, useCnt);
        return;
    }
    /* 내가 둘 수 있는 영역에 모두 두더라도 result 보다 크지 않다면 끝낸다. */
    if(((emptyArea / blockArea) + useCnt) <= result){
        return;
    }
    /* 둘 수 없는 곳은 바로 다음 칸으로 넘어간다. */
    if(map[ny][nx] == '#'){
        if(nx == w - 1){
            progress(ny + 1, 0, useCnt, emptyArea);
        } else {
            progress(ny, nx + 1, useCnt, emptyArea);
        }
        return;
    }

    for(int type = 0; type < sameBlock; type++){
        if(canDrop(ny, nx, type)){
            dropBlock(ny, nx, type, '#');
            if(nx == w - 1){
                progress(ny + 1, 0, useCnt + 1, emptyArea - blockArea);
            } else {
                progress(ny, nx + 1, useCnt + 1, emptyArea - blockArea);
            }
            dropBlock(ny, nx, type, '.');
        }
    }

    if(nx == w - 1){
        progress(ny + 1, 0, useCnt, emptyArea - 1);
    } else {
        progress(ny, nx + 1, useCnt, emptyArea - 1);
    }
}

/*
block을 그린다.
 */
void dropBlock(int ny, int nx, int type, char b){
    for(int i = 0; i < blockArea; i++){
        int dy = ny + blocks[type][i].first;
        int dx = nx + blocks[type][i].second;

        map[dy][dx] = b;
    }
}

/*
(nx, ny) 좌표를 기준으로 block을 놓을 수 있는지 확인한다.
 */
bool canDrop(int ny, int nx, int type){
    for(int i = 0; i < blockArea; i++){
        int dy = ny + blocks[type][i].first;
        int dx = nx + blocks[type][i].second;

        if(dy >= 0 && dy < h && dx >= 0 && dx < w){
            if(map[dy][dx] == '#'){
                return false;
            }
        } else {
            return false;
        }
    }
    return true;
}

void inputNmakeblock(){
    cin >> h >> w >> r >> c;
    for(i = 0; i < h; i++){
        cin >> map[i];
    }
    for(i = 0; i < r; i++){
        cin >> block[i];
    }
    for(i = 0; i < h; i++){
        for(j = 0; j < w; j++){
            if(map[i][j] == '.'){
                emptyArea++;
            }
        }
    }

    /* 정방향 */
    bool first = true;
    int base = 0;
    for(j = 0; j < c; j++){
        if(block[0][j] == '#'){
            if(first){
                first = false;
                base = j;
                blocks[0].push_back(make_pair(0, 0));
            } else {
                blocks[0].push_back(make_pair(0, j - base));
            }
        }
    }
    for(i = 1; i < r; i++){
        for(j = 0; j < c; j++){
            if(block[i][j] == '#'){
                blocks[0].push_back(make_pair(i, j - base));
            }
        }
    }

    /* 90도 회전 */
    first = true;
    base = 0;
    for(i = 0; i < r; i++){
        if(block[i][c - 1] == '#'){
            if(first){
                first = false;
                base = i;
                blocks[1].push_back(make_pair(0, 0));
            } else {
                blocks[1].push_back(make_pair(0, i - base));
            }
        }
    }
    for(j = c - 2; j >= 0; j--){
        for(i = 0; i < r; i++){
            if(block[i][j] == '#'){
                blocks[1].push_back(make_pair(c - j - 1, i - base));
            }
        }
    }

    /* 180도 회전 */
    first = true;
    base = 0;
    for(j = c - 1; j >= 0; j--){
        if(block[r - 1][j] == '#'){
            if(first){
                first = false;
                base = j;
                blocks[2].push_back(make_pair(0, 0));
            } else {
                blocks[2].push_back(make_pair(0, base - j));
            }
        }
    }
    for(i = r - 2; i >= 0; i--){
        for(j = c - 1; j >= 0; j--){
            if(block[i][j] == '#'){
                blocks[2].push_back(make_pair(r - i - 1, base - j));
            }
        }
    }

    /* 270도 회전 */
    first = true;
    base = 0;
    for(i = r - 1; i >= 0; i--){
        if(block[i][0] == '#'){
            if(first){
                first = false;
                base = i;
                blocks[3].push_back(make_pair(0, 0));
            } else {
                blocks[3].push_back(make_pair(0, base - i));
            }
        }
    }
    for(j = 1; j < c; j++){
        for(i = r - 1; i >= 0; i--){
            if(block[i][j] == '#'){
                blocks[3].push_back(make_pair(j, base - i));
            }
        }
    }

    blockArea = blocks[0].size();

    /*
    0도 block과 180도 회전 block이 같다면,
    0, 1 번 block과 2, 3 번 block은 서로 똑같다.
     */
    int sameCount = 0;
    for(i = 0; i < blockArea; i++){
        for(j = 0; j < blockArea; j++){
            if(blocks[0][i].first == blocks[2][j].first &&
               blocks[0][i].second == blocks[2][j].second){
                sameCount++;
            }
        }
    }
    if(sameCount == blockArea){
        sameBlock = 2;
    }

    /*
    0도 block과 90도 회전 block이 같다면,
    모든 block은 서로 똑같다.
     */
    sameCount = 0;
    for(i = 0; i < blockArea; i++){
        for(j = 0; j < blockArea; j++){
            if(blocks[0][i].first == blocks[1][j].first &&
               blocks[0][i].second == blocks[1][j].second){
                sameCount++;
            }
        }
    }
    if(sameCount == blockArea){
        sameBlock = 1;
    }
}

void initial(){
    result = 0;
    emptyArea = blockArea = 0;
    sameBlock = 4;
    for(i = 0; i < MAX; i++){
        for(j = 0; j < MAX; j++){
            map[i][j] = '#';
            block[i][j] = '.';
        }
    }
    blocks[0].clear();
    blocks[1].clear();
    blocks[2].clear();
    blocks[3].clear();
}

int getMax(int a, int b){
    return a > b ? a : b;
}
