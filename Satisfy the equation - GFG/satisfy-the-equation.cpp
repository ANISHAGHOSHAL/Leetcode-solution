//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution {
   public:
    vector<int> satisfyEqn(int a[], int n) {
       
        unordered_map<int, set<pair<int,int>>>mp;
        for(int i = 0 ; i < n ; i++ ){
            for(int j = 0 ; j < n ; j++ ){
                if( i != j )
                    mp[a[i]+a[j]].insert( {i, j} ) ;
            }
        }
        
        for(int i = 0 ; i < n ; i++ ){
            for(int j = i+1 ; j < n ; j++ ){
                int tar = a[i] + a[j] ;
                if( mp.find(tar) != mp.end() ){
                    for( auto it : mp[tar] ){
                        if( it.first == i || it.first == j )
                            continue ;
                        if( it.second == i || it.second == j )
                            continue ;
                        
                        return { i, j, it.first, it.second } ;
                    }  
                }
            }
        }
        return {-1, -1, -1, -1} ;
    }
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int N;
        
        cin>>N;
        int A[N];
        
        for(int i=0; i<N; i++)
            cin>>A[i];

        Solution ob;
        vector<int> ptr = ob.satisfyEqn(A,N);
        
        cout<<ptr[0]<<" "<<ptr[1]<<" "<<ptr[2]<<" "<<ptr[3]<<endl;
    }
    return 0;
}
// } Driver Code Ends