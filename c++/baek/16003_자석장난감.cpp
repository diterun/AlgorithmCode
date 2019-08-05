#include <iostream>
using namespace std;

#define MAX 100001

class Node {
private:
    int magnetID;
    Node* next;
public:
    Node(int m){
        magnetID = m;
        next = NULL;
    }

    void setMagnetID(int m) { magnetID = m; }
    void setNext(Node* n) { next = n; }

    int getMagnetID() { return magnetID; }
    Node* getNext() { return next; }
};

class Magnet {
private:
    Node* head;
    Node* now;
    int me;
    int count;
    string fix;
public:
    Magnet(int magnetID){
        me = magnetID;
        Node* nNode = new Node(magnetID);
        head = nNode;
        count = 1;
    }

    bool compareTo(Magnet* com){
        int comCount = com->getCount();
        if(count > comCount){
            return true;
        }

        if(com->getFix().find(fix) == string::npos){
            return true;
        }

        return false;
    }

    void clearNow(){ now = head; }
    int getCount(){ return count; }
    string getFix(){ return fix; }

    int nowMagnetID(){
        if(now == NULL){
            return -1;
        }
        int mid = now->getMagnetID();
        now = now->getNext();
        return mid;
    }

    void addNode(int magnetID){
        Node* nNode = new Node(magnetID);

        Node* tPre = head;
        Node* temp = head;

        while(temp != NULL){
            if(temp->getMagnetID() > magnetID){
                break;
            }

            tPre = temp;
            temp = temp->getNext();
        }

        if(temp == tPre) {
            nNode->setNext(head);
            head = nNode;
        } else {
            tPre->setNext(nNode);
            nNode->setNext(temp);
        }

        count++;
    }

    void removeNode(int magnetID){
        if(me == magnetID){
            deleteAll();
            return;
        }

        Node* tPre = head;
        Node* temp = head;

        while(temp != NULL){
            if(temp->getMagnetID() == magnetID){
                break;
            }

            tPre = temp;
            temp = temp->getNext();
        }

        if(temp == tPre) {
            head = temp->getNext();
            delete temp;
        } else {
            tPre->setNext(temp->getNext());
            delete temp;
        }

        count--;
    }

    void setFix(){
        string strTemp = "";
        Node* temp = head;

        while(temp != NULL){
            strTemp += to_string(temp->getMagnetID()) + ",";
            temp = temp->getNext();
        }

        fix = strTemp;
    }

    void deleteAll(){
        Node* temp = head;

        while(head != NULL){
            head = temp->getNext();
            delete temp;
            temp = head;
        }
    }
};

int n, m, i, a, b;
Magnet** magnet;
string result;
bool check[MAX];

void inputData();
void initial();
void progress();
void deleteAll();

int main(void){
    cin >> n >> m;

    initial();
    inputData();
    progress();
    deleteAll();

    return 0;
}

void progress(){
    bool canRemove = true;

    while(canRemove){
        canRemove = false;

        for(i = 1; i <= n; i++){
            if(check[i]){
                continue;
            }

            bool can = true;
            magnet[i]->clearNow();
            int now = magnet[i]->nowMagnetID();

            while(now != -1){
                if(now == i){
                    now = magnet[i]->nowMagnetID();
                    continue;
                }

                if(magnet[i]->compareTo(magnet[now])){
                    can = false;
                    break;
                }
                now = magnet[i]->nowMagnetID();
            }

            if(can){
                magnet[i]->clearNow();
                now = magnet[i]->nowMagnetID();

                while(now != -1){
                    if(now == i){
                        now = magnet[i]->nowMagnetID();
                        continue;
                    }

                    magnet[now]->removeNode(i);
                    magnet[now]->setFix();
                    now = magnet[i]->nowMagnetID();
                }
                magnet[i]->removeNode(i);
                check[i] = true;
                result += to_string(i) + " ";
                canRemove = true;
            }
        }
    }

    for(i = 1; i <= n; i++){
        if(!check[i]){
            cout << 0 << endl;
            return;
        }
    }

    cout << 1 << endl;
    cout << result << endl;
}

void inputData(){
    for(i = 0; i < m; i++){
        cin >> a >> b;

        magnet[a]->addNode(b);
        magnet[b]->addNode(a);
    }

    for(i = 1; i <= n; i++){
        magnet[i]->setFix();
    }
}

void initial(){
    result = "";
    magnet = new Magnet*[n + 1];
    for(i = 1; i <= n; i++){
        magnet[i] = new Magnet(i);
        check[i] = false;
    }
}

void deleteAll(){
    for(i = 1; i <= n; i++){
        magnet[i]->deleteAll();

        delete magnet[i];
    }
    delete magnet;
}