// { Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
class Solution {
public:
	int count_dfs(vector<vector<int>>graph, int u, int d, vector<bool>&vis){
		if(u == d)
			return 1;
		vis[u] = true;
		int ans = 0;
		for(auto v: graph[u]){
			if(!vis[v])
				ans += count_dfs(graph, v, d, vis);
		}
		vis[u] = false;
		return ans;
	}
	int possible_paths(vector<vector<int>>edges, int n, int s, int d){
		vector<vector<int>>graph(n);
		for(auto i: edges)
			graph[i[0]].push_back(i[1]);
		vector<bool>vis(n, false);
		return count_dfs(graph, s, d, vis);
	}
};

// { Driver Code Starts.
int main(){
	int tc;
	cin >> tc;
	while(tc--){
		int n, m, s, d;
		cin >> n >> m >> s >> d;
		vector<vector<int>>edges;
		for(int i = 0; i < m; i++){
			int u, v;
			cin >> u >> v;
			edges.push_back({u,v});
		}
		Solution obj;
		int ans = obj.possible_paths(edges, n, s, d);
		cout << ans <<"\n";
	}
	return 0;
}  // } Driver Code Ends