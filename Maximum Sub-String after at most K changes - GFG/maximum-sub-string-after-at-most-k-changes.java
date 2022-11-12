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
            String s = br.readLine().trim();
            int k = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.characterReplacement(s, k);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java


//User function Template for Java

class Solution
{
    public int characterReplacement(String s, int k)
    {
        int N=s.length();
        int[] char_counts=new int[26];
        int window_start=0;
        int max_length=0;
        int max_count=0;
        for(int window_end=0;window_end<N;window_end++)
        {
            char_counts[s.charAt(window_end) - 'A']++;
            int current_char_count = char_counts[s.charAt(window_end) - 'A'];
            max_count = Math.max(max_count, current_char_count);
            
            while(window_end - window_start - max_count + 1 > k)
            {
                char_counts[s.charAt(window_start) - 'A']--;
                window_start++;
            }
            max_length = Math.max(max_length, window_end - window_start + 1);
        }
        return max_length;
        // code here
    }
}