// { Driver Code Starts
#include<bits/stdc++.h>
using namespace std;


 // } Driver Code Ends
long long MAX = 1e18;

class Solution{
public:    
    bool check(int num,int start,long long water,int *cap,vector<int> *graph){
        queue<pair<int,long long>> q;
        vector<int> vis(100010,0);
        q.push({start,water});
        while(q.size()){
            auto val=q.front();
            q.pop();
            int curr=val.first;
            long long curr_water=val.second;
            vis[curr] = 1;
            if (cap[curr-1]>curr_water)
                return false;
            
            curr_water-=cap[curr-1];
            
            int neighbour=0;
            
            for (auto it: graph[curr]){
                int nxt=it;
                if(!vis[nxt])
                    neighbour+=1;  
            }
            if(neighbour>0)
                curr_water/=neighbour;
            
            for (auto it: graph[curr]){
                int nxt=it;
                if(!vis[nxt])
                    q.push({nxt,curr_water});
            }
        }
        return true;
    }
    long long minimum_amount(vector<vector<int>> &Edges, int num, int start, int *cap){
        vector<int> graph[100010];
        long long high=1e18,low=0;
        for(int i=0;i<num-1;i++){
            graph[Edges[i][0]].push_back(Edges[i][1]);
            graph[Edges[i][1]].push_back(Edges[i][0]);
        }
        while(low<=high){
            long long mid=low+(high-low)/2;
            if(mid>=MAX) return -1;
            if(check(num,start,mid,cap,graph)==false){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return low;
    }
};


// { Driver Code Starts.


int main()
 {
	int T;
	cin>> T;
	while (T--)
	{
	    int num, start;
	    cin>>num>>start;
	    int cap[num];
	    for(int i = 0; i<num; i++)
	        cin>>cap[i];
	    
	    vector<vector<int>> Edges(num);
	    for(int i=1;i < num;i++){
	        int u, v; cin >> u >> v;
	        Edges[i-1].push_back(u);
	        Edges[i-1].push_back(v);
	    }
	    
	    
    	Solution obj;
	    long long ans = obj.minimum_amount(Edges, num, start, cap);
	    cout << ans << endl;
	    
	}
	
	return 0;
}  // } Driver Code Ends