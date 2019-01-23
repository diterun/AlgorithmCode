#include<iostream>
using namespace std;

#define MAX 10001

int i, j, n;
bool allCases[MAX];
bool allCasesTemp[MAX];

int getGradesCnt(){
	int cnt = 0;
	cin >> n;

    allCases[0] = true;
	allCasesTemp[0]  = true;
	for(i = 0; i < n; i++){
        int grade;

		cin >> grade;

		for(j = 0; j < MAX; j++){
			if(allCases[j] && j + grade < MAX){
				allCasesTemp[j + grade] = true;
			}
		}

		for(j = 0; j < MAX; j++){
			allCases[j] = allCasesTemp[j];
		}
	}

	for(i = 0; i < MAX; i++){
		if(allCases[i]){
			cnt++;
		}
	}

	return cnt;
}

void initialize(){
	for(i = 0; i< MAX; i++){
		allCases[i] = false;
		allCasesTemp[i] = false;
	}
}

int main(int argc, char** argv)
{
	int test_case;
	int T;
    
	cin>>T;
    
	for(test_case = 1; test_case <= T; ++test_case)
	{
        initialize();

        int result;

        result = getGradesCnt();
        
        cout << "#" << test_case << " " << result << endl;
	}

	return 0;
}