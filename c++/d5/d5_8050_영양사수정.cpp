#include<iostream>
using namespace std;

#define MAX 100001

int T, t;
int n, k, i, j, mLong, pCnt, inNum;
int dp[MAX][31];

int getMax(int a, int b);
void initialize();
void inputNcal();

class Node {
private:
    string diff;
    int minIndex;
    int maxIndex;
    int cnt;
    Node* left;
    Node* right;
public:
    Node(string d, int index){
        diff = d;
        minIndex = maxIndex = index;
        cnt = 1;
        left = NULL;
        right = NULL;
    }

    string getDiff(){ return diff; }
    int getMinIndex(){ return minIndex; }
    int getMaxIndex(){ return maxIndex; }
    int getCnt(){ return cnt; }
    Node* getLeft(){ return left; }
    Node* getRight(){ return right; }
    void setLeft(Node* l){ left = l; }
    void setRight(Node *r){ right = r; }

    void putInOther(int index){
        maxIndex = index;
        cnt++;
    }
};

Node* nNode;

class RBTree {
private:
    Node* top;
public:
    RBTree(){
        top = NULL;
    }

    void push(string diff, int index){
        if(top == NULL){
            nNode = new Node(diff, index);
            top = nNode;
        } else {
            bool ok = false;

            Node* temp = top;
            while(temp != NULL){
                string a = temp->getDiff();

                if(a == diff){
                    ok = true;
                    
                    temp->putInOther(index);
                    break;
                }

                temp = temp->getRight();
            }

            if(!ok){
                nNode = new Node(diff, index);
                nNode->setRight(top);
                top = nNode;
            }
        }
        // input node to RB tree
    }

    int popWithResult(){
        // In top node...
        // getMax(mLong, maxIndex - minIndex)
        // in to mLong.
        // and get count of top node
        // lastly delete top node
        // return result of calculated count.
        // if top node is empty.
        // than return -1
        int cnt = top->getCnt();
        int sub = top->getMaxIndex() - top->getMinIndex();

        mLong = getMax(mLong, sub);

        Node* temp = top->getRight();
        delete top;
        top = temp;

        return (cnt * (cnt - 1)) / 2;
    }

    void pop(){
        // just delete node.
    }

    void clearWithResult(){
        while(top != NULL){
            pCnt += popWithResult();
        }
    }

    void clear(){
        // just pop all node.
    }
};

string dailyDiff;
RBTree tree;

int main(){
	cin >> T;

	for(t = 1; t <= T; ++t){
        initialize();

        inputNcal();

        cout << "#" << t << " ";
        cout << mLong << " " << pCnt << endl;
	}

	return 0;
}

int getMax(int a, int b){
    return a > b ? a : b;
}

void initialize(){
    mLong = pCnt = 0;
    for(i = 0; i < MAX; i++){
        for(j = 0; j < 31; j++){
            dp[i][j] = 0;
        }
    }
    tree.clear();
}

void inputNcal(){
    cin >> n >> k;
    
    dailyDiff = "";
    for(j = 1; j < k; j++){
        dailyDiff += "0";
    }

    tree.push(dailyDiff, 0);

    dailyDiff = "";
    cin >> dp[0][0];
    for(j = 1; j < k; j++){
        cin >> dp[0][j];
        dailyDiff += to_string(dp[0][j] - dp[0][j -1]);
    }
    cout << "1-day : " << dailyDiff << endl;

    tree.push(dailyDiff, 1);

    for(i = 1; i < n; i++){
        dailyDiff = "";

        cin >> inNum;
        dp[i][0] += dp[i - 1][0] + inNum;

        for(j = 1; j < k; j++){
            cin >> inNum;
            dp[i][j] += dp[i - 1][j] + inNum;
            dailyDiff += to_string(dp[i][j] - dp[i][j -1]);
        }
        cout << i + 1 << "-day : " << dailyDiff << endl;

        tree.push(dailyDiff, i + 1);
    }

    tree.clearWithResult();
}