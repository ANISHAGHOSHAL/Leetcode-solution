//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String[] str = br.readLine().trim().split(" ");
            int n = Integer.parseInt(str[0]);
            int k = Integer.parseInt(str[1]);
            str = br.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }

            long ans = new Solution().countSubarray(arr, n, k);

            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java


// User function Template for Java

class Solution {

    long countSubarray(int arr[], int n, int k) {

        // code here
        int recent=-1;
        long ans=0;
        for(int i=0;i<n;i++)
        {
            if(arr[i]>k)
            {
              ans++;
              int left=i-(recent+1);
              ans+=left;
              int right=n-1-i;
              ans+=right;
              int center=(left*right);
              ans+=center;
              recent=i;
            }
        }
        return ans;
    }
}