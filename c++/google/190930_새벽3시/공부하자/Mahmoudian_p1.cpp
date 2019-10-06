#include <iostream>
#include <algorithm>
#include <fstream>
#include <vector>
#include <deque>
#include <assert.h>
#include <queue>
#include <stack>
#include <set>
#include <map>
#include <stdio.h>
#include <string.h>
#include <utility>
#include <math.h>
#include <bitset>
#include <iomanip>
#include <complex>

using namespace std;

#define mp make_pair
#define x first
#define y second
#define pb push_back
#define ALL(x) (x).begin(), (x).end()

typedef long long LL;

const int N = (int) 1e3 + 3;
const int M = 105;
const int mod = (int) 0;

int dp[M][M], cnt[N], a[M];

int main() {
	cout << 1e3 << endl;
	cout << N << endl;
	memset(dp, 63, sizeof dp);
	dp[0][0] = 0;

	int tc;
	cin >> tc;
	for (int tt = 1; tt <= tc; ++tt) {
		cout << "Case #" << tt << ": ";

		int n, k;
		cin >> n >> k;
		for (int j = 0; j < n; ++j) {
			cin >> a[j];
		}

		// dp 길이(M * M개의 int형 변수 = 44100) 만큼 63(11111111)로 모든 바이트를 채운다.
		// 한마디로 모두 1로 초기화 
		memset(dp, 63, sizeof dp);
		dp[0][0] = 0;

		for (int r = 1; r <= n; ++r) {
			memset(cnt, 0, sizeof cnt);
			int mx = 0;
			for (int l = r - 1; l >= 0; --l) {
				++cnt[a[l]];
				mx = max(mx, cnt[a[l]]);
				for (int p = 1; p <= k + 1; ++p) {
					dp[r][p] = min(dp[r][p], dp[l][p - 1] + (r - l) - mx);
				}
			}
		}
		int res = 1e9;
		for (int j = 0; j <= k + 1; ++j)
			res = min(res, dp[n][j]);
		cout << res << '\n';
	}
}

















