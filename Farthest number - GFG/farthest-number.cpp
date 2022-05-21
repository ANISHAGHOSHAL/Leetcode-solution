// { Driver Code Starts
//Initial Template for C++
#include<bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
//User function Template for C++
class Solution{   
  public:
    vector<int> farNumber(int N,vector<int> Arr){
        vector<int> answer;
        int suffix_min[N];
        for(int i=N-1;i>=0;i--)
        {
            suffix_min[i]=Arr[i];
            if(i+1<N)
                suffix_min[i]=min(suffix_min[i],suffix_min[i+1]);
        }
        for(int i=0;i<N;i++)
        {
            int l=i+1;
            int r=N-1;
            int x=-1;
            while(l<=r)
            {
                int mid=(l+r)/2;
                if(suffix_min[mid]<Arr[i])
                {
                    x=mid;
                    l=mid+1;
                }
                else{
                    r=mid-1;
                }
            }
            answer.push_back(x);
        }
        return answer;
    }
};


// { Driver Code Starts.
signed main()
{
    int t;
    cin>>t;
    while(t--)
    {
        int N;
        cin>>N;
        vector<int> Arr(N);
        for(int i=0;i<N;i++)
            cin>>Arr[i];
        Solution obj;
        vector<int> answer=obj.farNumber(N,Arr);
        for(auto i:answer)
            cout<<i<<" ";
        cout<<endl;
  }
}  // } Driver Code Ends