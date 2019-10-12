#include <string>
#include <vector>

using namespace std;

class Avante{
public:
    string carID;
    int odo;
};

class MyHeap{
public:
    Avante alist[20000];
    int listCnt;

    MyHeap(){
        listCnt = 0;
    }

    void push(string id, int odo){
        listCnt++;
        alist[listCnt].carID = id;
        alist[listCnt].odo = odo;

        int child = listCnt;
        int parent = child / 2;

        while(child > 1){
            if(alist[parent].odo > alist[child].odo){
                swapList(parent, child);
                child = parent;
                parent = child / 2;
            } else if(alist[parent].odo == alist[child].odo){
                if(alist[parent].carID.compare(alist[child].carID)){
                    swapList(parent, child);
                    child = parent;
                    parent = child / 2;
                } else {
                    break;
                }
            } else {
                break;
            }
        }
    }

    Avante pop(){
        Avante result = alist[1];

        swapList(1, listCnt);
        listCnt--;

        int parent = 1;
        int child = parent * 2;

        if(child + 1 <= listCnt){
            if(alist[child].odo > alist[child + 1].odo){
                child = child + 1;
            } else if(alist[parent].odo == alist[child].odo){
                if(alist[child].carID.compare(alist[child + 1].carID)){
                    child = child + 1;
                }
            }
        }

        while(child <= listCnt){
            if(alist[parent].odo > alist[child].odo){
                swapList(parent, child);
                parent = child;
                child = parent * 2;
            } else if(alist[parent].odo == alist[child].odo){
                if(alist[parent].carID.compare(alist[child].carID)){
                    swapList(parent, child);
                    parent = child;
                    child = parent * 2;
                } else {
                    break;
                }
            } else {
                break;
            }

            if(child + 1 <= listCnt){
                if(alist[child].odo > alist[child + 1].odo){
                    child = child + 1;
                } else if(alist[parent].odo == alist[child].odo){
                    if(alist[child].carID.compare(alist[child + 1].carID)){
                        child = child + 1;
                    }
                }
            }
        }

        return result;
    }

    void swapList(int a, int b){
        string tid = alist[a].carID;
        int todo = alist[a].odo;
        alist[a].carID = alist[b].carID;
        alist[a].odo = alist[b].odo;
        alist[b].carID = tid;
        alist[b].odo = todo;
    }
};

string solution(int n, vector<string> plates, vector<int> odo, int k, vector<int> drives) {
    MyHeap heap;

    for(int i = 0; i < n; i++){
        heap.push(plates[i], odo[i]);
    }

    for(int i = 0; i < k; i++){
        Avante nowAvante = heap.pop();
        nowAvante.odo += drives[i];
        heap.push(nowAvante.carID, nowAvante.odo);
    }

    return heap.pop().carID;
}