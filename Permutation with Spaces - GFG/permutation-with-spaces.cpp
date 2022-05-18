// { Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


 // } Driver Code Ends
class Solution{
public:
    void permute(string S, int start, int end, string current, vector<string>& result){
        if(start>end){
            result.push_back(current);
            return;
        }
        current.push_back(S[start]);
        permute(S, start+1, end, current, result);
        current.insert(current.length()-1, 1, ' ' );
        permute(S, start+1, end, current, result);
    }

    vector<string> permutation(string S){
        vector<string> result;
        string current;
        current.push_back(S[0]);
        permute(S,1, S.length()-1, current, result);
        sort(result.begin(), result.end());
        return result;
    }
};

// { Driver Code Starts.

int  main(){
    int t;
    cin>>t;
    while(t--){
        string S;
        cin>>S;
        vector<string> ans;
        Solution obj;
        ans = obj.permutation(S);
        for(int i=0;i<ans.size();i++){
            cout<<"("<<ans[i]<<")";
        }
        cout << endl;
    }
}
  // } Driver Code Ends