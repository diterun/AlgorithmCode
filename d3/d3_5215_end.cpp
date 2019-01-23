#include<iostream>
using namespace std;

#define MAX 1002

int N, L, result;
int material[22][2];

    
int getMaximumJMT(int index, int deliGrade, int currentCal, bool* use) {
    use[index] = true;
    deliGrade = material[index][0];
    currentCal += material[index][1];

    for (int j = index; j <= N; j++) {
        if(currentCal + material[j][1] <= L && !use[j]) {
            int sub_de = material[index][0] + getMaximumJMT(j, deliGrade, currentCal, use);
            deliGrade = deliGrade > sub_de ? deliGrade : sub_de;
            
            use[j] = false;
        }
    }
    
    return deliGrade;
}

void initialize(){
    for(int i = 0; i < 22; i++){
        material[i][0] = 0;
        material[1][1] = 0;
    }
    result = 0;
}

int main(int argc, char** argv)
{
	int test_case;
	int T;
    cin >> T;

	for(test_case = 1; test_case <= T; ++test_case)
	{
        bool useMaterial[22];
        initialize();
        for (int i = 0; i < 22; i++) {
            useMaterial[i] = false;
        }

        cin >> N >> L;
        for (int i = 1; i <= N; i++) {
            cin >> material[i][0];
            cin >> material[i][1];
        }
			
        for (int i = 1; i <= N; i++) {
            int sub_result = getMaximumJMT(i, 0, 0, useMaterial);
            
            result = result > sub_result ? result : sub_result;
        }

        cout << "#" << test_case << " " << result << endl;
	}
	return 0;
}