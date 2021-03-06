// { Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
class Solution {
public:
	bool isBipartite(int V, vector<int>adj[]){
		vector<int>color(V, -1);
		queue<int>q;
		bool is_Bipratite = true;
		for(int i = 0; i < V; i++){
			if(color[i] == -1){
				q.push(i);
				color[i] = 0;
				while(!q.empty()){
					int u = q.front();
					q.pop();
					for(auto v: adj[u]){
						if(color[v] == -1){
							color[v] = color[u] ^ 1;
							q.push(v);
						}
						else is_Bipratite = is_Bipratite & (color[u] != color[v]);
					}

				}
			}
		}
		return is_Bipratite;
	}

};


// { Driver Code Starts.
int main(){
	int tc;
	cin >> tc;
	while(tc--){
		int V, E;
		cin >> V >> E;
		vector<int>adj[V];
		for(int i = 0; i < E; i++){
			int u, v;
			cin >> u >> v;
			adj[u].push_back(v);
			adj[v].push_back(u);
		}
		Solution obj;
		bool ans = obj.isBipartite(V, adj);    
		if(ans)cout << "1\n";
		else cout << "0\n";  
	}
	return 0;
}  // } Driver Code Ends