//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            String W = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.numberOfSubsequences(S,W));
        }
    }
}

// } Driver Code Ends


//User function Template for Java


//User function Template for Java
class Solution{

    static int numberOfSubsequences(String S, String W){

        // code here

        int count=0;

        ArrayList<Character> al=new ArrayList<>();

        for(int i=0;i<S.length();i++){

            al.add(S.charAt(i));

        }

        

        for(int i=0;i<S.length();i++){

            if(S.charAt(i)==W.charAt(0)){

                if(helper(al,W)){

                    count++;

                }else{

                    break;

                }

            }

        }

        return count;

        

        

    }

    static boolean helper(ArrayList<Character> al,String W){

         int k=0;

         for(int i=0;i<al.size();i++){

             if(al.get(i)==W.charAt(k)){

                 al.remove(i);

                 k=k+1;

                 i--;

             }

             

             if(k==W.length())

                 return true;

         }

         return false;

     }

}