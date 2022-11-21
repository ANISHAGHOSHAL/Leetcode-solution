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
            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.UniquePartitions(n);
            for(ArrayList<Integer>i: ans)
                for(int j: i)
                    System.out.print(j + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java


//User function Template for Java

class Solution
{
    // public static void solve(int original,int num,ArrayList<Integer> ans,ArrayList<ArrayList<Integer>> res){
    //     if(original == 0){
    //         res.add(new ArrayList<>(ans));
    //         return;
    //     }
    //     if(num<=0)
    //         return;
    //     if(num<=original){
    //         ans.add(num);
    //         solve(original-num,num,ans,res);
    //         ans.remove(ans.size()-1);
    //         // /Backtracking for maintaining the previous recursion state of ans.
    //     }
    //     solve(original,num-1,ans,res);
    // }
    // public ArrayList<ArrayList<Integer>> UniquePartitions(int n)
    // {
    //     ArrayList<ArrayList<Integer>> res=new ArrayList<>();
    //     ArrayList<Integer> ans=new ArrayList<>();
    //     solve(n,n,ans,res);
    //     return res;
    //     // Code here
    // }
    public static void f(int n,ArrayList<ArrayList<Integer>> ans,ArrayList<Integer> list) {
        if(n<=0) {
            if(n==0) {
                // ans.add((ArrayList)list.clone());
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        int v =n;
        if(list.size()>0) v = list.get(list.size()-1);
        
        for(int i=v;i>=1;i--) {
            list.add(i);
            f(n-i,ans,list);
            list.remove(list.size()-1);
        }
        
    }
    
    public ArrayList<ArrayList<Integer>> UniquePartitions(int n)
    {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        f(n,ans,new ArrayList<>());
        return ans;            
    }
}