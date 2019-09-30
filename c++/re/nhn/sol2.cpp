#include <iostream>
using namespace std;

#define MAX 102
#define getMax(a, b) (a > b ? a : b)

class MFQ{ // My FQ
private:
    int numbers[MAX];
    int cnts[MAX];
    int index;
public:
    MFQ(){
        for(int i = 0; i < MAX; i++){
            numbers[i] = 0;
            cnts[i] = 0;
        }
        index = 0;
    }

    void enqueue(int number){
        numbers[index] = number;
        cnts[number]++;
        index++;
    }

    int dequeue(){
        if(index == 0){
            return -1;
        }

        int mymax = 0;
        int maxindex = 0;

        for(int i = 0; i < index; i++){
            if(mymax < cnts[numbers[i]]){
                mymax = cnts[numbers[i]];
                maxindex = i;
            }
        }

        int result = numbers[maxindex];
        cnts[result]--;

        for(int i = maxindex; i < index; i++){
            numbers[i] = numbers[i + 1];
        }
        index--;

        return result;
    }
};

int n;
MFQ mfq;
string command;
int num;

int main() {
    string answer = "";

    cin >> n;

    for(int i = 0; i < n; i++){
        cin >> command;

        if(command == "enqueue"){
            cin >> num;
            mfq.enqueue(num);
        } else if(command == "dequeue"){
            int n = mfq.dequeue();

            answer += to_string(n) + " ";
        }
    }

    cout << answer << endl;

	return 0;
}