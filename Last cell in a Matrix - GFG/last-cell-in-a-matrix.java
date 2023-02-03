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
            String str[] = read.readLine().trim().split("\\s+");
            int r = Integer.parseInt(str[0]);
            int c = Integer.parseInt(str[1]);
            int matrix[][] = new int[r][c];
            
            for(int i = 0; i < r; i++)
            {
                int k = 0;
                str = read.readLine().trim().split("\\s+");
                for(int j = 0; j < c; j++){
                  matrix[i][j] = Integer.parseInt(str[k]);
                  k++;
                }
            }
            Solution obj = new Solution();
            int[] p = obj.endPoints(matrix,r,c);
            out.print("(" +  p[0]+ ", " +  p[1]+ ")" +"\n");
        }
        out.close();
    }
}


// } Driver Code Ends


//User function Template for Java




//User function Template for Java

class Solution{
    static int [] endPoints(int [][]matrix, int R, int C){
        //code here
        int exit[] = new int[2];
        String lastD = "r";
        
        int i=0, j=0;
        while(i>=0 && i<R && j>=0 && j<C){
            exit[0]=i;
            exit[1]=j;
            
            if(matrix[i][j]==1){
                matrix[i][j]=0;
                lastD = changeDirection(lastD); 
            }
            
            int updatedIndex[] = moveInDir(lastD, i, j);
            i=updatedIndex[0];
            j=updatedIndex[1];
            
                
        }
        return exit;
    }
    
    static String changeDirection(String dir){
        String s = "";
        if(dir.equals("u"))
            s="r";
        else if(dir.equals("r"))
            s="d";
        else if(dir.equals("d"))
            s="l";
        else if(dir.equals("l"))
            s="u";
        return s;    
    }
    
    
    static int[] moveInDir(String lastD, int i, int j){
        int[] newIndex = new int[2];
        
        if(lastD.equals("r"))
            j++;
        else if(lastD.equals("l"))
            j--;
            
        else if(lastD.equals("u"))
            i--;
        else if(lastD.equals("d"))
            i++;    
        
        newIndex[0]=i;
        newIndex[1]=j;
        return newIndex;
            
    } 
}