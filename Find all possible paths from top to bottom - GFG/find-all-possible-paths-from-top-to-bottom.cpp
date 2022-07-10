// { Driver Code Starts
//Initial Template for C++

#include <bits/stdc++.h>
using namespace std;


 // } Driver Code Ends
//User function Template for C++

class Solution
{
public:
    // a function which check whether our step is safe or not
    bool isSafe(int r, int c, vector<vector<int>> &grid, int n, int m)
    {
        return (r < n and c < m and grid[r][c] != -1); // return true if all values satisfied else false
    }

    void findAllPossiblePaths(vector<vector<int>> &grid, int r, int c, int n, int m, vector<int> &ans, vector<vector<int>> &paths)
    {
        // when we hit the last cell we reach to destination then directly push the path
        if (r == n - 1 and c == m - 1)
        {
            ans.push_back(grid[r][c]);
            paths.push_back(ans); // function to display the path stored in ans vector
            ans.pop_back();       // pop back because we need to backtrack to explore more path
            return;
        }

        // we will store the current value in ch and mark the visited place as -1
        int ch = grid[r][c];

        ans.push_back(ch); // push the path in ans array
        grid[r][c] = -1;   // mark the visited place with -1

        // if is it safe to take next downward step then take it
        if (isSafe(r + 1, c, grid, n, m))
        {
            findAllPossiblePaths(grid, r + 1, c, n, m, ans, paths);
        }

        // if is it safe to take next rightward step then take it
        if (isSafe(r, c + 1, grid, n, m))
        {
            findAllPossiblePaths(grid, r, c + 1, n, m, ans, paths);
        }

        // backtracking step we need to make values original so to we can visit it by some another path
        grid[r][c] = ch;

        // remove the current path element we explore
        ans.pop_back();
        return;
    }
    vector<vector<int>> findAllPossiblePaths(int n, int m, vector<vector<int>> &grid)
    {
        vector<vector<int>> paths;
        vector<int> ans;
        findAllPossiblePaths(grid, 0, 0, n, m, ans, paths);
        return paths;
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
        vector<vector<int>> grid(n, vector<int>(m));
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                cin >> grid[i][j];
            }
        }
        Solution ob;
        auto ans = ob.findAllPossiblePaths(n, m, grid);
        for (int i = 0; i < ans.size(); i++)
        {
            for (int j = 0; j < ans[i].size(); j++)
            {
                cout << ans[i][j] << " ";
            }
            cout << "\n";
        }
    }
    return 0;
}
  // } Driver Code Ends