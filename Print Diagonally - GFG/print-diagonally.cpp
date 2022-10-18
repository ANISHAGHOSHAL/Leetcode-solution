//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution{
	
		
	public:
	vector<int> downwardDigonal(int N, vector<vector<int>> A)
	{
	vector<int>ans;

 for(int j=0;j<N;j++)

 {

     int i=0;

     int temp=j;

     while(temp>=0)

     {

         ans.push_back(A[i][temp]);

         i++;

         temp--;

     }

 }

 for(int i=1;i<N;i++)

 {

     int j=N-1;

     int temp=i;

     while(temp<N)

     {

         ans.push_back(A[temp][j]);

         temp++;

         j--;

     }

 }

 return ans;

 }

};

//{ Driver Code Starts.



int main()
{

    
    int t;
    cin >> t;
    while(t--) 
    {
        int n;
        cin >> n;

        vector<vector<int>> A(n, vector<int>(n));

        for(int i = 0; i < n; i++)
        	for(int j = 0; j < n; j++)
        		cin >> A[i][j];

        Solution obj;
        vector<int> ans = obj.downwardDigonal(n, A);

        for(auto i:ans)
        	cout << i << " ";

	    cout << "\n";
    }

    return 0;
}

// } Driver Code Ends