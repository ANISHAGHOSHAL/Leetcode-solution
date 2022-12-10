//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            String str = read.readLine();
            Solution ob = new Solution();

            System.out.println(ob.buildLowestNumber(str,N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java



//User function Template for Java

class Solution {
    static String buildLowestNumber(String str, int k) {
        Stack<Character> st=new Stack<>();
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            while(!st.isEmpty() && k>0 && st.peek() > ch){
                st.pop();
                k--;
            }
            st.push(ch);
        }
        
        while(!st.isEmpty() && k>0){
            st.pop();
            k--;
        }
        
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        
        for(int i=sb.length()-1; i>=0; i--){
            if(sb.charAt(i) != '0') break;
            
            if(sb.charAt(i) == '0') sb.deleteCharAt(i);
        }
        
        return sb.length() == 0 ? "0" : sb.reverse().toString();
    }
}