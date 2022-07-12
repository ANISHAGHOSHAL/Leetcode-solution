// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String A[] = read.readLine().split(" ");
            
            String S = A[0];
            String T = A[1];

            Solution ob = new Solution();
            System.out.println(ob.shortestUnSub(S,T));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static int shortestUnSub(String S, String T) {
        int MAX = 9999999;
        
        int m = S.length(), n = T.length();
 
        // declaring 2D array of m + 1 rows and
        // n + 1 columns dynamically
        int [][] dp = new int[m+1][n+1];
     
        // T string is empty
        for (int i = 0; i <= m; i++)
            dp[i][0] = 1;
     
        // S string is empty
        for (int i = 0; i <= n; i++)
            dp[0][i] = MAX;
     
        for (int i = 1; i <= m; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                char ch = S.charAt(i-1);
                int k;
                for (k = j-1; k >= 0; k--)
                    if (T.charAt(k) == ch)
                        break;
     
                // char not present in T
                if (k == -1)
                    dp[i][j] = 1;
                else
                   dp[i][j] = Math.min(dp[i-1][j], dp[i-1][k] + 1);
            }
        }
     
        int ans = dp[m][n];
        if (ans >= MAX)
            ans = -1;
     
        return ans;
    }
}
