//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];
        
        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }
        
        return mat;
    }
    
    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
    
    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int[] a = IntArray.input(br, 3);
            int n = a[0],m=a[1],k=a[2];
            
            int[][] e = IntMatrix.input(br, a[2], 2);
            
            Solution obj = new Solution();
            int res = obj.largestArea(n,m,k,e);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


       


       

class Solution {
    public static int largestArea(int n,int m,int k,int[][] enemy) {
        // code here
        List<Integer> blockedRows = new ArrayList<>();
        List<Integer> blockedCols = new ArrayList<>();
        
        for(int[] e : enemy){
            blockedRows.add(e[0]);
            blockedCols.add(e[1]);
        }
        
        blockedRows.add(0);
        blockedRows.add(n+1);
        
        blockedCols.add(0);
        blockedCols.add(m+1);
        
        Collections.sort(blockedRows);
        Collections.sort(blockedCols);
        
        int maxRowDiff = 0;
        int maxColDiff = 0;
        
        for(int i=1;i<blockedRows.size();i++){
            maxRowDiff = Math.max(maxRowDiff, blockedRows.get(i) - blockedRows.get(i-1));
        }
        
        for(int i=1;i<blockedCols.size();i++){
            maxColDiff = Math.max(maxColDiff, blockedCols.get(i) - blockedCols.get(i-1));
        }
        
        return (maxRowDiff-1) * (maxColDiff-1);
    }
}
 
 
