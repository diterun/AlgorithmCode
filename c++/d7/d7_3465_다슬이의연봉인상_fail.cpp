#include<iostream>
using namespace std;

class PayNode{
private:
    int pay;
    int num;
    PayNode* next;
    PayNode* prev;
public:
    PayNode(int p, int n){
        pay = p;
        num = n;
        next = NULL;
        prev = NULL;
    }

    void setPay(int p){ pay = p; }
    void setNum(int n){ num = n; }
    void setNext(PayNode* n){ next = n; }
    void setPrev(PayNode* p){ prev = p; }

    int getPay(){ return pay; }
    int getNum(){ return num; }
    PayNode* getNext(){ return next; }
    PayNode* getPrev(){ return prev; }
};

class PayList{
private:
    PayNode* head;
    PayNode* tail;
    PayNode* now;
    int count;
    int subCount;
public:
    PayList(){
        head = NULL;
        tail = NULL;
        now = NULL;
        count = 0;
        subCount = 0;
    }

    int getCount(){ return count; }
    int getSubCount() { return count - subCount; }
    PayNode* getNow(){ return now; }
    PayNode* getNextNow(){
        now = now->getNext();
        subCount++;
        return now;
    }
    void clearNow(){
        now = head;
        subCount = 0;
    }

    PayNode* getTail(){ return tail; }

    void addFirst(int pay, int num){
        PayNode* nNode = new PayNode(pay, num);
        head = tail = nNode;
        count++;
    }

    // void printAll(){
    //     PayNode* temp = tail;
    //     while(temp != NULL){
    //         cout << temp->getPay() << " " << temp->getNum() << endl;
    //         temp = temp->getPrev();
    //     }
    // }

    void addList(PayList* subList){
        now = head;
        subList->clearNow();
        PayNode* subNow = subList->getNow();
        // cout << now->getNum() << ":" << now->getPay() << " vs " << subNow->getNum() << ":" << subNow->getPay() << endl;

        while(true){
            if(now->getPay() > subNow->getPay()){
                if(now->getNum() > subNow->getNum()){
                    addPrev(subNow->getPay(), subNow->getNum());
                    subNow = subList->getNextNow();
                } else {
                    subNow = subList->getNextNow();
                }
            } else if(now->getPay() < subNow->getPay()){
                if(now->getNum() > subNow->getNum()){
                    deleteNowAndNext();
                } else {
                    now = now->getNext();
                }
            } else {
                if(now->getNum() > subNow->getNum()){
                    now->setNum(subNow->getNum());
                    now = now->getNext();
                    subNow = subList->getNextNow();
                } else {
                    subNow = subList->getNextNow();
                }
            }

            if(now == NULL){
                if(subNow != NULL){
                    count += subList->getSubCount();

                    PayNode* pastTail = tail;
                    tail = subList->getTail();
                    subList->deleteConnection();
                    pastTail->setNext(subNow);
                    subNow->setPrev(pastTail);
                }
                break;
            } else if(subNow == NULL){
                break;
            }
        }
    }

    void deleteConnection(){
        if(now == head){
            head = tail = NULL;
        } else {
            tail = now->getPrev();
            tail->setNext(NULL);
        }
    }

    void addPrev(int pay, int num){
        PayNode* nNode = new PayNode(pay, num);
        PayNode* nowPrev = now->getPrev();

        nowPrev->setNext(nNode);
        now->setPrev(nNode);

        nNode->setNext(now);
        nNode->setPrev(nowPrev);

        count++;
    }

    void deleteNowAndNext(){
        if(now == head){
            if(head == tail){
                delete now;
                head = tail = now = NULL;
            } else {
                head = now->getNext();
                head->setPrev(NULL);
                delete now;
                now = head;
            }
        } else if(now == tail){
            tail = now->getPrev();
            tail->setNext(NULL);
            delete now;
            now = NULL;
        } else {
            PayNode* nowNext = now->getNext();
            PayNode* nowPrev = now->getPrev();

            nowPrev->setNext(nowNext);
            nowNext->setPrev(nowPrev);
            delete now;
            now = nowNext;
        }

        count--;
    }

    void deleteAll(){
        PayNode* deleteNode = head;

        while(deleteNode != NULL){
            deleteNode = deleteNode->getNext();
            delete head;
            head = deleteNode;
        }
        tail = now = NULL;
    }
};

class Employee{
private:
    int num;
    int bossNum;
    PayList* list;
public:
    Employee(int n, int p, int b){
        num = n;
        bossNum = b;
        list = new PayList();
        list->addFirst(p, n);
    }

    int getBoss(){ return bossNum; }
    PayList* getList(){ return list; }

    int goToBoss(Employee* boss){
        int changeCount = list->getCount() - 1;

        boss->getList()->addList(list);
        // boss->getList()->printAll();

        return changeCount;
    }

    void deleteAll(){
        list->deleteAll();
        delete list;
    }
};

void inputAndMakeStruct();
void processOne();
void initialize();
void deleteAll();

int n, inputPay, inputBoss, i;
Employee** empl;
long long result;

int main(int argc, char** argv)
{
	int t;
	int T;

	cin >> T;

	for(t = 1; t <= T; ++t){
        initialize();
        inputAndMakeStruct();
        processOne();

        cout << "#" << t << " " << result << endl;
        deleteAll();
	}

	return 0;
}

void processOne(){
    for(i = n; i >= 0; i--){
        // cout << i << " st : ";
        int bossNum = empl[i]->getBoss();

        if(bossNum != -1){
            Employee* boss = empl[bossNum];
            result += empl[i]->goToBoss(boss);
            empl[i]->deleteAll();
            delete empl[i];
        } else {
            // empl[i]->getList()->printAll();
            // cout << empl[i]->getList()->getCount() << endl;
            result += empl[i]->getList()->getCount() - 1;
        }
        // cout << result << " !!!" << endl << endl;
    }
}

void inputAndMakeStruct(){
    cin >> n;
    cin >> inputPay;

    empl = new Employee*[n + 1];
    empl[0] = new Employee(0, inputPay, -1);

    for(i = 1; i <= n; i++){
        scanf("%d", &inputPay);
        scanf("%d", &inputBoss);
        empl[i] = new Employee(i, inputPay, inputBoss);
    }
}

void initialize(){
    result = 0;
}

void deleteAll(){
    // cout<<"delete all~" << endl;
    delete empl[0];
    delete empl;
}
