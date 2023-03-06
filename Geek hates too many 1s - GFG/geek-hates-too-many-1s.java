//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            Solution obj = new Solution();
            int res = obj.noConseBits(n);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends




class Solution {
       public static int noConseBits(int n) {

        StringBuilder sb=new StringBuilder();

        int num=n;

        while(n!=0)

        {

            sb.append((n&1));

            n>>=1;

        }

        String s=sb.reverse().toString();

        int len=s.length();

        int temp=len-1;

        int sum=0,c=0;

        for(int i=0;i<len;i++)

        {

            if(s.charAt(i)=='1')

            {

                c++;

                if(c==3)

                {

                    sum+=1<<(temp-i);

                    c=0;

                }

            }

            else

                c=0;

        }

        return num-sum;

    }
}
              
