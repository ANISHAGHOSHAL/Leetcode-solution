//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution {
public:
	long long int NoOfChicks(int n){
	    // Code here
	    long long int total=1;
	    vector<long long int>chicks(n,0);
	    chicks[0]=1;
	    for(int i=1;i<n;i++)
	    {
	        if(i>=6)
	        {
	            total-=chicks[i-6];
	        }
	        chicks[i]=total*2;
	        total+=chicks[i];;
	    }
	    return total;
	}
};

//{ Driver Code Starts.
int main(){
	int tc;
	cin >> tc;
	while(tc--){
		int N;
		cin >> N;
		Solution obj;
		long long int ans = obj.NoOfChicks(N);
		cout << ans <<"\n";
	}
	return 0;
}
// } Driver Code Ends