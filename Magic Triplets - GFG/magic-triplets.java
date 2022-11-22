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
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine().trim();
            String[] S = s.split(" ");
            int[] nums = new int[n];
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(S[i]);
            }
            Solution ob = new Solution();
            int ans = ob.countTriplets(nums);
            System.out.println(ans);         
        }
    }
}

// } Driver Code Ends


//User function Template for Java


//User function Template for Java

class Solution{
    public int countTriplets(int[] a){
        // code here
        int noOfTriplets = 0, len = a.length; 
        for(int mid = 1; mid<len-1; mid++){
            int left = mid-1;
            int right = mid+1;
            for(int i = left; i>=0; i--)
                for(int j = right; j<len; j++)
                    if(a[i]<a[mid] && a[mid]<a[j]) noOfTriplets++;
        }
        return noOfTriplets;
    }
}