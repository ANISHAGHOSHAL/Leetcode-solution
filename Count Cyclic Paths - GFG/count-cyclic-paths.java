//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

//User function Template for Java

class Solution{
	public static int countPaths(int N){
	    int m=1000000007;
	    long o=0, a=1, b=1, c=1;
	    for(int i=2; i<=N; i++){
	        long ways2Origin=(a+b+c)%m;
	        long ways2A=(o+b+c)%m;
	        long ways2B=(o+a+c)%m;
	        long ways2C=(o+b+a)%m;
	        o=ways2Origin;
	        a=ways2A;
	        b=ways2B;
	        c=ways2C;
	    }
	    return (int)o;
		//code here
	}
}

//{ Driver Code Starts.

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.countPaths(N));
        }
    }
}

// } Driver Code Ends