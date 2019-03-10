#include <iostream>
using namespace std;

int days;
int price[1001];
int i, j;
int max_, maxi, pmaxi, coins;
int result;

int main(void) {
	result = 0;
	coins = 0;
	max_ = 0;

	cin >> days;

	for (i = 0; i < days; i++) {
		cin >> price[i];
		if (max_ <= price[i]) {
			max_ = price[i];
			maxi = i;
		}
	}

	pmaxi = 0;
	while (1) {
		for (i = pmaxi; i < maxi; i++) {
			if (maxi - 1 == pmaxi) {
				
			}
			else {
				result -= price[i];
				coins++;
			}
		}

		result = result + (price[maxi] * coins) - 1;
		coins = 0;
		max_ = 0;

		cout << result << endl;
		if (maxi == days - 1) {
			break;
		}
		
		pmaxi = maxi + 1;
		for (i = pmaxi; i < days; i++) {
			if (max_ <= price[i]) {
				max_ = price[i];
				maxi = i;
			}
		}
	}

	cout << result << endl;

	system("pause");
	return 0;
}