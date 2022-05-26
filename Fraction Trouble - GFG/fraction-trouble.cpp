// { Driver Code Starts
// Initial Template for C++
#include <bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
// User function Template for C++
class Solution {
  public:
    vector<int> numAndDen(int n, int d){
        int num = 0;
        int den = 1;
        for (int q = 10000; q >= 2; q--){
            int p = (n * q - 1) / d;
            if (p * den >= num * q)
            {
                den = q;
                num = p;
            }
        }
        int tot = __gcd(num,den);
        vector<int>ans;
        ans.push_back(num/tot);
        ans.push_back(den/tot);
        return ans;
    }
};

// { Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int n,d;
        cin >> n >> d;
        Solution ob;
        vector<int>ans=ob.numAndDen(n,d);
        for(int i=0;i<ans.size();i++)cout<<ans[i]<<" ";
        cout<<endl;
    }
    return 0;
}
  // } Driver Code Ends