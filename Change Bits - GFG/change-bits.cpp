// { Driver Code Starts
//Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
//User function Template for C++

class Solution{   
public:
    vector<int> changeBits(int N) {
        vector<int> arr(2);
        int bits = log2(N)+1;    // Getting Number of bits of the number.
        int ans = pow(2,bits)-1; // Getting the Changed Number
        int sub = ans-N;     
        arr[0]=sub; // Assigning their values to the Array.
        arr[1]=ans;
        return arr;
    }
};

// { Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int N;
        cin>>N;
        Solution ob;
        auto ans = ob.changeBits(N);
        cout<<ans[0]<<" "<<ans[1]<<endl;
    }
    return 0;
}  // } Driver Code Ends