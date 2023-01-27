//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String str = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.CountWays(str);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


//User function Template for Java



//User function Template for Java

class Solution
{
    private int MOD = (int)(1e9) + 7;
    
    Integer[] memo;
    public int CountWays(String str) {
        if (str.charAt(0) == '0') {
            return 0;
        }
        
        int n = str.length();
        memo = new Integer[n + 1];
        
        return countWays(str, 0);
    }
    
    private int countWays(String s, int index) {
        if (index == s.length()) {
            return 1;
        }
        
        if (s.charAt(index) == '0') {
            return 0;
        }
        
        if (memo[index] != null) {
            return memo[index];
        }
        
        int way1 = countWays(s, index + 1) % MOD;
        int way2 = 0;
        
        if (index + 2 <= s.length() && Integer.parseInt(s.substring(index, index + 2)) >= 1 && Integer.parseInt(s.substring(index, index + 2)) <= 26) {
            way2 = countWays(s, index + 2) % MOD;
        }
        
        return memo[index] = (way1 + way2) % MOD;
    }
    
}