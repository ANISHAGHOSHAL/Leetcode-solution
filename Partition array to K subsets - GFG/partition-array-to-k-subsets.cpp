// { Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


 // } Driver Code Ends
/*You are required to complete this method */

class Solution{
  public:
    int dp[(1<<16)+2];
    bool isKPartitionPossible(int nums[], int n, int k)
    {
      int sum = 0;
            fill(dp, dp+(1<<16)+2, -1);
            dp[0] = 0;
            for (int i = 0; i < n; i++) sum += nums[i];
            if (sum % k) return false;
            int tar = sum/k;
            
            for (int mask = 0; mask < (1<<n); mask++) {
                if (dp[mask] == -1) continue;  // if current state is illegal, simply ignore it
                for (int i = 0; i < n; i++) {
                    if (!(mask&(1<<i)) && dp[mask]+nums[i] <= tar) {  // if nums[i] is unchosen && choose nums[i] would not cross the target
                        dp[mask|(1<<i)] = (dp[mask]+nums[i]) % tar;
                    }
                }
            }
            return dp[(1<<n)-1] == 0;   //Your code here
    }
};
// { Driver Code Starts.
int main()
{
    int t;
    cin>>t;
    while(t--)
    {
    	int n;
    	
    	cin>>n;
    	int a[n];
    	for(int i=0;i<n;i++)
    	cin>>a[i];
    	int k;
    	cin>>k;
    	Solution obj;
    	cout<<obj.isKPartitionPossible(a, n, k)<<endl;
    }
}  // } Driver Code Ends