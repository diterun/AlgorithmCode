#include <iostream>
#include <vector>
#include <queue>
using namespace std;

string solution(int n, vector<string> plates, vector<int> odo, int k, vector<int> drives);

int main() {
	vector<string> a = {"AZ3618", "XP9657", "SP6823", "UH7515", "TV6621", "WZ8264"};
	vector<int> b = {20, 16, 18, 20, 24, 19};
	vector<int> d = {3,7,5,8,6,5,10,2};

	cout << solution(6, a, b, 8, d) << endl;

	return 0;
}

class Avante{
public:
	string carID;
	int odo;

	Avante(string id, int o){
		carID = id;
		odo = o;
	}
};

class MyCompare{
public:
	bool operator() (const Avante& a, const Avante& b) const {
		if(a.odo == b.odo){
			return a.carID > b.carID;
		}
		return a.odo > b.odo;
	}
};

string solution(int n, vector<string> plates, vector<int> odo, int k, vector<int> drives) {
	priority_queue<Avante, vector<Avante>, MyCompare> mpq;

	for(int i = 0; i < n; i++){
		Avante newAvante(plates[i], odo[i]);
		mpq.push(newAvante);
	}

	for(int i = 0; i < k; i++){
		Avante nowAvante = mpq.top();
		mpq.pop();
		nowAvante.odo += drives[i];
		mpq.push(nowAvante);
	}

    return mpq.top().carID;
}