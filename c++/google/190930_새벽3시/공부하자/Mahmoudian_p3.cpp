
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
const int N = (int) 2e5 + 5 + 6, mod = (int) 0;
int dp[N][3], a[N], odp[3];
vector<int> adj[N];
void dfs(int v, int p = -1) {
	dp[v][2] = a[v];
	dp[v][1] = -1e18;
	dp[v][0] = 0;
	for (int u : adj[v]) {
		if (u != p) 
			dfs(u, v);
	}
	for (int u : adj[v]) if (u != p) {
		memcpy(odp, dp[v], sizeof dp[v]);
		memset(dp[v], -63, sizeof dp[v]);
		for (int curd = 0; curd <= 2; ++curd) {
			for (int dd = 0; dd <= 2; ++dd) {
				int nd = max(curd, dd - 1);
				int add = dp[u][dd] + odp[curd];
				if (curd == 0 && dd == 2) add += a[v];
				if (curd == 2 && dd == 0) add += a[u];
				dp[v][nd] = max(dp[v][nd], add);
			}
		}
	}
}
int32_t main() {
	int tc;
	cin >> tc;
	for (int tt = 1; tt <= tc; ++tt) {
		cout << "Case #" << tt << ": ";
		memset(dp, 0, sizeof dp);
		for (int cur = 0; cur < N; ++cur) adj[cur].clear();
		int n;
		cin >> n;
		for (int j = 0; j < n; ++j) cin >> a[j];
		for (int j = 0; j < n - 1; ++j) {
			int u, v;
			cin >> u >> v;
			--u, --v;
			adj[u].pb(v);
			adj[v].pb(u);
		}
		dfs(0);
		cout << max(dp[0][0], max(dp[0][1], dp[0][2])) << '\n';
	}
}

















