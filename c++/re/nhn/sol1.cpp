#include <iostream>
#include <map>
using namespace std;

int n;
map<string, int> bugs;
map<int, int> checker;
int bugCnt;

int main() {
    cin >> n;

    for(int i = 0; i < n; i++){
        string bug;
        cin >> bug;

        if(bugs.find(bug) == bugs.end()){
            bugs[bug] = 0;
        } else {
            bugs[bug]++;
        }
    }
    bugCnt = bugs.size();

    for(map<string, int>::iterator iter = bugs.begin(); iter != bugs.end(); iter++){
        checker[iter->second] = 1;
    }

    if(checker.size() <= 2){
        if(n % bugCnt == 0){
            cout << "Y" << endl;
            cout << n << endl;
            cout << bugCnt << endl;
        } else if(n % bugCnt == bugCnt - 1){
            cout << "Y" << endl;
            cout << n + 1 << endl;
            cout << bugCnt << endl;
        } else {
            cout << "N" << endl;
            cout << n << endl;
            cout << bugCnt << endl;
        }
    } else {
        cout << "N" << endl;
        cout << n << endl;
        cout << bugCnt << endl;
    }

	return 0;
}