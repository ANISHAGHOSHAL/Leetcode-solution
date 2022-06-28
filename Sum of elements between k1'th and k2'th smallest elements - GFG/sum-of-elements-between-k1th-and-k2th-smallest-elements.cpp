// { Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
class Solution{
    public:
    long long sumBetweenTwoKth( long long a[], long long n, long long k1, long long k2)
    {
        sort(a, a+n);
        unordered_set<long long> s;
        long long c = 0, sum = 0;    
    
        if(k1>k2)
        swap(k1, k2);
    
        for(int i =0;i<n;i++){
            if(s.count(a[i]) == 0){
                s.insert(a[i]);
                c++;
            }
            
            if(c > k1 && c < k2)
                sum+=a[i];
            
            if(c == k2)
                break;
        }
        return sum;
    }
};

// { Driver Code Starts.
int main()
 {
    long long t;
    cin>>t;
    while(t--)
    {
        long long n, k;
        cin>>n;
        long long a[n+5];
        for(int i =0;i<n;i++)
            cin >> a[i];
        
        long long k1, k2;
        cin >> k1 >> k2;
        Solution ob;
        cout << ob.sumBetweenTwoKth(a, n, k1, k2) << endl;
        
    }
	return 0;
}
  // } Driver Code Ends