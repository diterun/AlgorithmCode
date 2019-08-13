#include<iostream>
using namespace std;
/*
부하 연봉 -> 상사 연봉 증가
연봉이 증가 된 cnt 출력

다슬이는 기본
이후 직원 N명

연봉 (다슬)
연봉 상사
연봉 상사
...

1 <= N <= 300000
1 <= 연봉 <= 1,000,000,000

자신의 상사들을 기억하고 //<vector>처럼 해야겠다...
자신 보다 연봉이 높은 상사의 컷이 어딘지 기억해 놓는다.
만약 신입의 연봉이 자신보다 높다면,
자신의 상사 중에서 자신보다 높은 상사를 제외하고
모든 상사들을 돌며 연봉을 높이고 그 상사들의 숫자 만큼 결과를 높인다.
그 이후에는 자신보다 연봉이 높은 상사로 가거나 다슬이에게 간다.
*/

// 그냥 쌩으로 위랑 비교해가면서 찾아가면서 바꾸면 10개 중 2개 맞음

#define MAX 300001

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
public:
    PayList(){
        head = NULL;
        tail = NULL;
        now = NULL;
        count = 0;
    }

    int getCount(){ return count; }

    void addNext(int pay, int num){
        PayNode* nNode = new PayNode(pay, num);

        if(now == head){
            if(head == tail){
                head = tail = nNode;
            } else {
                now = now->getNext();

                nNode->setNext(now);
                nNode->setPrev(head);

                head->setNext(nNode);
                now->setPrev(nNode);
            }
        } else if(now == tail){
            nNode->setPrev(now);
            now->setNext(nNode);

            tail = nNode;
        } else {
            PayNode* nowNext = now->getNext();
            PayNode* nowPrev = now->getPrev();

            nowNext->setNext(nNode);
            nowPrev->setNext(nNode);
        }

        count++;
    }

    void deleteNow(){
        if(now == head){
            if(head == tail){
                head = tail = NULL;
                delete now;
            } else {
                head = now->getNext();
                now->getNext()->setPrev(NULL);
                delete now;
            }
        } else if(now == tail){
            tail = now->getPrev();
            now->getPrev()->setNext(NULL);
            delete now;
        } else {
            PayNode* nowNext = now->getNext();
            PayNode* nowPrev = now->getPrev();

            nowNext->setPrev(nowPrev);
            nowPrev->setNext(nowNext);
            delete now;
        }
        count--;
    }

    void clearNow(){
        now = head;
    }
};

class Employee{
private:
    int num;
    int bossNum;
    PayList list;
public:
    Employee(int n, int p, int b){
        num = n;
        bossNum = b;
        list.clearNow();
        list.addNode(p, n);
    }

    int getBoss(){ return bossNum;}

    int goToBoss(Employee* boss){
        int changeCount = 0;

        // 이 부분을 만들어야 한다.
        if(boss->getBoss() == -1){
            return list.getCount() - 1;
        }
        return changeCount;
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
        Employee* boss = empl[empl[i]->getBoss()];

        result += empl[i]->goToBoss(boss);
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

}
