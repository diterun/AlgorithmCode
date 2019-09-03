#include <iostream>
#include <vector>
using namespace std;

vector<int> solution(int m, int n, vector<vector<int>> picture);

int main(){
    vector<vector<int>> a = {{1,1,1,0},{1,2,2,0},{1,0,0,1},{0,0,0,1},{0,0,0,3},{0,0,0,3}};

    vector<int> result = solution(6, 4, a);

    for(int i = 0; i < result.size(); i++){
        printf("%d\n", result[i]);
    }

    return 0;
}

vector<int> solution(int m, int n, vector<vector<int>> picture) {
    int number_of_area = 0;
    int max_size_of_one_area = 0;
    
    bool check[m][n];
    for(int i = 0; i < m; i++){
        for(int j = 0; j < n; j++){
            check[i][j] = false;
        }
    }
    
    vector<int> answer(2);
    answer[0] = number_of_area;
    answer[1] = max_size_of_one_area;
    return answer;
}