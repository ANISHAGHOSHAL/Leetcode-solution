// { Driver Code Starts
//Initial template for C++

#include<bits/stdc++.h>
using namespace std;



 // } Driver Code Ends
//User function template 

class Solution{
  public:
    int fun(string &s)
    {
        map<char, long long int> mp;
        mp['a']=0;
        mp['b']=0;
        mp['c']=0;
    
          for(int i = s.size()-1;i >= 0;--i)
        {
            if(s[i] == 'c')
                mp['c'] = ( 2*mp['c'] + 1 ) % 1000000007;
            
            else if(s[i] == 'b')
                mp['b'] = ( 2*mp['b'] + mp['c'] ) % 1000000007;
            
            else if(s[i] == 'a')
                mp['a'] = ( 2*mp['a'] + mp['b'] ) % 1000000007;
        }
        
        return (int)(mp['a']);
    }
};

// { Driver Code Starts.
 
int main()
 {
    int t;
    cin>>t;
    while(t--) {
        string s;
        cin>>s;
        Solution obj;
        cout<<obj.fun(s)<<endl;
    }
	return 0;
}  // } Driver Code Ends