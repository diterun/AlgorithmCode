#include<iostream>
using namespace std;

/*
조합...
50개 중에 30개 어떤 음식을 먹느냐에 따라서 다르지
근데
이미 글렀지? 조합은 안돼
 */
#define MAX 51

int T, t, n, m, l, result, i, j, k;
string friends[MAX];
string temp;
int foods[MAX][MAX + 1];
bool check[MAX];

class CanEat{
private:
    int num;
    CanEat* next;
public:
    CanEat(int n){
        num = n;
        next = NULL;
    }

    void setNext(CanEat* n){ next = n; }
    CanEat* getNext(){ return next; }

    int getNum(){ return num; }
};

class Food{
private:
    int count;
    CanEat* head;
    CanEat* tail;
public:
    Food(){
        count = 0;
        head = NULL;
        tail = NULL;
    }

    void setCount(int c){ count = c; }
    int getCount(){ return count; }

    void addFriendNumber(int fnum){
        CanEat* nNode = new CanEat(fnum);

        if(head == NULL){
            head = tail = nNode;
        } else {
            tail->setNext(nNode);
            tail = nNode;
        }
    }

    void setTrue(){
        CanEat* tem = head;

        while(tem != NULL){
            check[tem->getNum()] = true;
            tem = tem->getNext();
        }
    }

    void setFalse(){
        CanEat* tem = head;

        while(tem != NULL){
            check[tem->getNum()] = false;
            tem = tem->getNext();
        }
    }

    void clear(){
        CanEat* tem = head;

        while(tem != NULL){
            tem = tem->getNext();
            delete head;
            head = tem;
        }
    }
};

int main(void){
    cin >> T;

    for(t = 0; t < T; ++t){
        result = 0;
        for(i = 0; i < MAX; i++){
            friends[i] = "";
            check[i] = false;
        }
        Food foods[MAX];

        cin >> n >> m;
        for(i = 0; i < n; i++){
            cin >> friends[i];
        }
        for(i = 0; i < m; i++){
            cin >> l;

            foods[i].setCount(l);
            for(j = 0; j < l; j++){
                cin >> temp;

                for(k = 0; k < n; k++){
                    if(friends[k] == temp){
                        foods[i].addFriendNumber(k);
                        break;
                    }
                }
            }
        }

        for(i = 0; i < m; i++){
            foods[i].setTrue();
            for(j = 0; j < n; j++){
                cout << check[j] << " ";
            }
            cout << endl;
        }

        cout << result << endl;

        for(i = 0; i < MAX; i++){
            foods[i].clear();
        }
    }

    return 0;
}