#include <iostream>
#include <vector>
using namespace std;

vector<vector<int>> solution(vector<vector<int>> nodeinfo);

int main(){
    vector<vector<int>> a = {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};
    vector<vector<int>> b = solution(a);

    for(int i = 0; i < b.size(); i++){
        for(int j = 0; j < b[i].size(); j++){
            printf("%d ", b[i][j]);
        }
        printf("\n");
    }

    return 0;
}

#define MAX 10002

vector<vector<int>> answer;
vector<int> front;
vector<int> post;

class MyNode{
public:
    int number;
    int x;
    int y;
    MyNode* left;
    MyNode* right;

    MyNode(){
        left = NULL;
        right = NULL;
    }
};

class MyTree{
public:
    MyNode* root;

    MyTree(){
        root = NULL;
    }

    void addNode(int x, int y, int number){
        if(root == NULL){
            MyNode* nNode = new MyNode();
            nNode->x = x;
            nNode->y = y;
            nNode->number = number;

            root = nNode;
        } else {
            MyNode* nNode = new MyNode();
            nNode->x = x;
            nNode->y = y;
            nNode->number = number;

            MyNode* temp = root;

            while(true){
                if(temp->y > y){
                    if(temp->x > x){
                        if(temp->left != NULL){
                            temp = temp->left;
                        } else {
                            temp->left = nNode;
                            break;
                        }
                    } else {
                        if(temp->right != NULL){
                            temp = temp->right;
                        } else {
                            temp->right = nNode;
                            break;
                        }
                    }
                }
            }
        }
    }

    void frontPrior(MyNode* now){
        front.push_back(now->number);
        if(now->left != NULL){
            frontPrior(now->left);
        }
        if(now->right != NULL){
            frontPrior(now->right);
        }
    }

    void postPrior(MyNode* now){
        if(now->left != NULL){
            postPrior(now->left);
        }
        if(now->right != NULL){
            postPrior(now->right);
        }
        post.push_back(now->number);
    }

    void clear(MyNode* now){
        if(now->left != NULL){
            postPrior(now->left);
        }
        if(now->right != NULL){
            postPrior(now->right);
        }
        delete now;
    }
};

int node[MAX][3];
int temp[MAX][3];
int nodeCnt;
MyTree tr;

void mergeSort(int left, int right);
void merge(int left, int mid, int right);

vector<vector<int>> solution(vector<vector<int>> nodeinfo) {
    nodeCnt = nodeinfo.size();

    for(int i = 0; i < nodeCnt; i++){
        node[i][0] = nodeinfo[i][0];
        node[i][1] = nodeinfo[i][1];
        node[i][2] = i + 1;
    }

    mergeSort(0, nodeCnt - 1);

    for(int i = 0; i < nodeCnt; i++){
        tr.addNode(node[i][0], node[i][1], node[i][2]);
    }

    tr.frontPrior(tr.root);
    tr.postPrior(tr.root);
    answer.push_back(front);
    answer.push_back(post);

    tr.clear(tr.root);

    return answer;
}

void mergeSort(int left, int right){
    if(left < right){
        int mid = (left + right) / 2;

        mergeSort(left, mid);
        mergeSort(mid + 1, right);
        merge(left, mid, right);
    }
}

void merge(int left, int mid, int right){
    int l = left;
    int r = mid + 1;
    int tt = left;

    while(l <= mid && r <= right){
        if(node[l][1] > node[r][1]){
            temp[tt][0] = node[l][0];
            temp[tt][1] = node[l][1];
            temp[tt][2] = node[l][2];
            tt++;
            l++;
        } else if(node[l][1] == node[r][1]) {
            if(node[l][0] < node[r][0]){
                temp[tt][0] = node[l][0];
                temp[tt][1] = node[l][1];
                temp[tt][2] = node[l][2];
                tt++;
                l++;
            } else {
                temp[tt][0] = node[r][0];
                temp[tt][1] = node[r][1];
                temp[tt][2] = node[r][2];
                tt++;
                r++;
            }
        } else {
            temp[tt][0] = node[r][0];
            temp[tt][1] = node[r][1];
            temp[tt][2] = node[r][2];
            tt++;
            r++;
        }
    }

    for(; l <= mid; l++){
        temp[tt][0] = node[l][0];
        temp[tt][1] = node[l][1];
        temp[tt][2] = node[l][2];
        tt++;
    }

    for(; r <= right; r++){
        temp[tt][0] = node[r][0];
        temp[tt][1] = node[r][1];
        temp[tt][2] = node[r][2];
        tt++;
    }

    for(int i = left; i <= right; i++){
        node[i][0] = temp[i][0];
        node[i][1] = temp[i][1];
        node[i][2] = temp[i][2];
    }
}