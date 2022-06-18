// { Driver Code Starts
//Initial Template for C++

#include <bits/stdc++.h>
using namespace std;


 // } Driver Code Ends
//User function Template for C++

class Solution {
public:
    int max_ans = INT_MIN;
    
    bool isValid(int i,int j,int n,int m){
        
        if(i<n && i>=0 && j<m && j>=0){
            return true;
        }
        return false;
    }
    
    void solve(vector<vector<int>> &matrix,vector<vector<bool>> &visited,int i,int j,int xd,int yd,int len,int n,int m){
        
        if(i==xd && j==yd){
            max_ans = max(max_ans,len);
            return;
        }
        
        visited[i][j] = true;
        
        if(isValid(i+1,j,n,m) && matrix[i+1][j]!=0 && visited[i+1][j]==false){
            solve(matrix,visited,i+1,j,xd,yd,len+1,n,m);
        }
        if(isValid(i-1,j,n,m) && matrix[i-1][j]!=0 && visited[i-1][j]==false){
            solve(matrix,visited,i-1,j,xd,yd,len+1,n,m);
        }
        if(isValid(i,j+1,n,m) && matrix[i][j+1]!=0 && visited[i][j+1]==false){
            solve(matrix,visited,i,j+1,xd,yd,len+1,n,m);
        }
        if(isValid(i,j-1,n,m) && matrix[i][j-1]!=0 &&  visited[i][j-1]==false){
            solve(matrix,visited,i,j-1,xd,yd,len+1,n,m);
        }
        
        visited[i][j] = false;
        
    }
    int longestPath(vector<vector<int>> matrix, int xs, int ys, int xd, int yd)
    {
        // code here
        int n = matrix.size();
        int m = matrix[0].size();
        
        vector<vector<bool>> visited(n,vector<bool>(m,false));
        if(matrix[xs][ys]==0 || matrix[xd][yd]==0)
            return -1;
        solve(matrix,visited,xs,ys,xd,yd,0,n,m);
        if(max_ans == INT_MIN)
            return -1;
        return max_ans;
    }
};

// { Driver Code Starts.

int main()
{
    int t;
    cin >> t;
    while (t--)
    {
        int n, m;
        cin >> n >> m;
        int xs, ys, xd, yd;
        cin >> xs >> ys >> xd >> yd;
        vector<vector<int>> mat(n, vector<int>(m));
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                cin >> mat[i][j];
            }
        }
        Solution ob;
        int ans = ob.longestPath(mat, xs, ys, xd, yd);
        cout << ans;
        cout << "\n";
    }
    return 0;
}  // } Driver Code Ends