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
            int N = Integer.parseInt(read.readLine());
            int[][]edge=new int[N-1][2];
            for(int i=0;i<N-1;i++)
            {
                String input[] = read.readLine().trim().split("\\s+");
                edge[i][0]=Integer.parseInt(input[0]);
                edge[i][1]=Integer.parseInt(input[1]);
            }
            Solution ob = new Solution();
            out.println(ob.countVertex(N, edge));
        }
        out.close();
    }
}


// } Driver Code Ends
//User function Template for Java

//User function Template for Java

class Solution{
    public int countVertex(int N, int[][] edges){
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        
        for(int i=0;i<=N;i++){
            adjList.add(new ArrayList<>());
        }
        
        for(int edge[] : edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        
        int dp[][] = new int[N+1][2];
        for(int i=1;i<=N;i++){
            dp[i][1] = 1;
        }
        
        dfs(adjList,1,1,dp);
        
        return Math.min(dp[1][0],dp[1][1]);
    }
    
    private void dfs(ArrayList<ArrayList<Integer>> adjList,int src,int par,int dp[][]){
            for(int node : adjList.get(src)){
                if(node == par) continue;
                dfs(adjList,node,src,dp);
                dp[src][0] += dp[node][1];
                dp[src][1] += Math.min(dp[node][0],dp[node][1]);
            }
    }
}

//{ Driver Code Starts.

// } Driver Code Ends