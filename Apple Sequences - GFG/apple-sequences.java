//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);
            String arr = read.readLine().trim();

            Solution ob = new Solution();
            out.println(ob.appleSequence(N, M, arr));
        }
        out.close();
    }
}


// } Driver Code Ends
//User function Template for Java


//User function Template for Java


class Solution{
    public static int appleSequence(int n, int m, String arr){
        //code here
        ArrayList<Integer> list = new ArrayList<>();
        list.add(-1);
        int left=0;
        int ans=0;
        for(int i=0;i<n;i++){
            if(arr.charAt(i)=='O'){
                list.add(i);
                if(m==0){
                    left++;
                    m=1;
                }
                m--;
            }
            ans=Math.max(ans,i-list.get(left));
        }
        return ans;
    }
}


//{ Driver Code Starts.

// } Driver Code Ends