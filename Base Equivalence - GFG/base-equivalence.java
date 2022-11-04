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
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] input = new String[2]; 
            input = br.readLine().split(" "); 
            int n = Integer.parseInt(input[0]); 
            int m = Integer.parseInt(input[1]); 
            Solution ob = new Solution();
            System.out.println(ob.baseEquiv(n,m));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

//User function Template for Java
class Solution
{
    private static int numberOfDigits(int n, int base)
    {
        int digits = (int)(Math.log(n) / Math.log(base));
        return digits + 1;
    }
    String baseEquiv(int n, int m)
    {
        // code here
        int l = 2, r = 32, mid = 0;
        while (l <= r)
        {
            mid = (r + l) / 2;
            int digits = numberOfDigits(n, mid);
            if (digits == m)
                return "Yes";
            else if (digits > m)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return "No";
    }
}