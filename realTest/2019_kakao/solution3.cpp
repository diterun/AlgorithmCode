#include <iostream>
#include <vector>
#include <map>
using namespace std;

bool solution(vector<vector<int>> key, vector<vector<int>> lock);

int main(){
    vector<vector<int>> k = {{0,0,0}, {1,0,0}, {0,1,1}};
    vector<vector<int>> l = {{1,1,1}, {1,1,0}, {1,0,1}};

    cout << solution(k, l);
    return 0;
}

vector<pair<int, int>> maps;
vector<pair<int, int>> keys[4];
map<pair<int, int>, int> keymap[4];
int n, m;
int gy, gx;

void makeKeys(vector<vector<int>> key);

bool solution(vector<vector<int>> key, vector<vector<int>> lock) {
    bool answer = false;
    m = key.size();
    n = lock.size();

    makeKeys(key);

    // for(int i = 0; i < 4; i++){
    //     for(int j = 0; j < keys[i].size(); j++){
    //         cout << keys[i][j].first << " " << keys[i][j].second<<endl;
    //     }
    //     cout << endl;
    // }

    gy = -1, gx = -1;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            if(lock[i][j] == 0){
                if(gy == -1){
                    gy = i;
                    gx = j;
                    maps.push_back(make_pair(0, 0));
                } else {
                    maps.push_back(make_pair(i - gy, j - gx));
                }
            }
        }
    }


    int keyLen = key.size();

    for(int i = 0; i < 4; i++){
        bool can = true;
        bool can2 = true;

        for(int j = 0; j < keyLen; j++){
            int dy = gy + keys[i][j].first;
            int dx = gx + keys[i][j].second;

            if(dy >= 0 && dy < n && dx >= 0 && dx < n){
                if(lock[dy][dx] == 1){
                    can = false;
                    break;
                }
            }
        }

        if(can){
            for(int j = 0; j < maps.size(); j++){
                if(keymap[i].find(maps[j]) == keymap[i].end()){
                    can2 = false;
                }
            }
            if(can2){
                answer = true;
                break;
            }
        }
    }

    return answer;
}

void makeKeys(vector<vector<int>> key){
    gy = -1, gx = -1;
    for(int i = 0; i < m; i++){
        for(int j = 0; j < m; j++){
            if(key[i][j] == 1){
                if(gy == -1){
                    gy = i;
                    gx = j;
                    keys[0].push_back(make_pair(0, 0));
                    keymap[0][make_pair(0, 0)] = 1;
                } else {
                    keys[0].push_back(make_pair(i - gy, j - gx));
                    keymap[0][make_pair(i - gy, j - gx)] = 1;
                }
            }
        }
    }

    gy = -1, gx = -1;
    for(int j = m - 1; j >= 0; j--){
        for(int i = 0; i < m; i++){
            if(key[i][j] == 1){
                if(gy == -1){
                    gy = i;
                    gx = j;
                    keys[1].push_back(make_pair(0, 0));
                    keymap[1][make_pair(0, 0)] = 1;
                } else {
                    keys[1].push_back(make_pair(gy - j, i - gx));
                    keymap[1][make_pair(gy - j, i - gx)] = 1;
                }
            }
        }
    }

    gy = -1, gx = -1;
    for(int i = m - 1; i >= 0; i--){
        for(int j = m - 1; j >= 0; j--){
            if(key[i][j] == 1){
                if(gy == -1){
                    gy = i;
                    gx = j;
                    keys[2].push_back(make_pair(0, 0));
                    keymap[2][make_pair(0, 0)] = 1;
                } else {
                    keys[2].push_back(make_pair(gy - i, gx - j));
                    keymap[2][make_pair(gy - i, gx - j)] = 1;
                }
            }
        }
    }

    gy = -1, gx = -1;
    for(int j = 0; j < m; j++){
        for(int i = m - 1; i >= 0; i--){
            if(key[i][j] == 1){
                if(gy == -1){
                    gy = i;
                    gx = j;
                    keys[3].push_back(make_pair(0, 0));
                    keymap[3][make_pair(0, 0)] = 1;
                } else {
                    keys[3].push_back(make_pair(j - gx, gy - i));
                    keymap[3][make_pair(j - gx, gy - i)] = 1;
                }
            }
        }
    }
}