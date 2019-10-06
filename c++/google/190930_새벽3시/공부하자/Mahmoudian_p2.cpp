
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
#define int long long
const int N = (int) 1e5 + 5, mod = (int) 0;
vector<int> a[N];
int sz[N];
int32_t main() {
	int tc;
	cin >> tc;
	for (int tt = 1; tt <= tc; ++tt) {
		cout << "Case #" << tt << ": ";
		int n, m;
		cin >> n >> m;
		for (int j = 0; j < N; ++j) a[j].clear();
		map<vector<int>, int> have;
		for (int j = 0; j < n; ++j) {
			cin >> sz[j];
			for (int i = 0; i < sz[j]; ++i) {
				int x;
				cin >> x;
				a[j].pb(--x);
			}
			sort(ALL(a[j]));
			have[a[j]]++;
		}
		int res = n * (n - 1);
		for (int cur = 0; cur < n; ++cur) {
			res -= have[a[cur]] - 1;
			for (int mask = 0; mask < (1 << sz[cur]) - 1; ++mask) {
				vector<int> all;
				for (int j = 0; j < sz[cur]; ++j)
					if (mask >> j & 1)
						all.push_back(a[cur][j]);
				res -= have[all];
			}
		}
		cout << res << endl;
		
	}
}

















