// { Driver Code Starts
#include <bits/stdc++.h>
#include <unordered_map>
using namespace std;


 // } Driver Code Ends
class Solution
{
    public:
        //Back-end complete function Template for C++

    int transform (string A, string B)
    {
        if (A.length () != B.length ())
        {
            return -1;
        }
    
        unordered_map <char, int> m;
        int n = A.length ();
    
        for (int i = 0; i < n; i++)
            m[A[i]]++;
    
        for (int i = 0; i < n; i++)
            if (m[B[i]])
                m[B[i]]--;
    
        for (auto i : m)
        {
            if (i.second != 0)
            {
                return -1;
            }
        }
    
    
        int i = n - 1, j = n - 1;
        int res = 0;
        while (i >= 0 and j >= 0)
        {
            while (i >= 0 and A[i] != B[j])
            {
                i--;
                res++;
            }
    
            i--;
            j--;
        }
    
        return res;
    }
};

// { Driver Code Starts.

int main () 
{
    int t; cin >> t;
    while (t--)
    {
        string A, B; 
        cin >> A >> B;
        Solution ob;
        cout <<ob.transform (A, B) << endl;
    }
}  // } Driver Code Ends