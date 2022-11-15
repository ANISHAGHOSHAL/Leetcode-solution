//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            int[] arr = new int[N];
            
            for(int i=0; i<N; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.longestPerfectPiece(arr,N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java


//User function Template for Java

class Solution {
    static int longestPerfectPiece(int[] arr, int n) {
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        
        int i=0,j=0;
        int ans=0;
        
        while(j<n){
            min.add(arr[j]);
            max.add(arr[j]);
            
            while(i<=j && max.peek() - min.peek() > 1){    
                 min.remove(arr[i]);
                 max.remove(arr[i]);
                 i++;
            }
            ans = Math.max(ans,j-i+1);
             j++;
        }
        
        return ans;
    }
};