//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            int i = 0;
            int N = Integer.parseInt(br.readLine().trim());

            int start[] = new int[N];
            int end[] = new int[N];

            String inputLine2[] = br.readLine().trim().split(" ");
            String inputLine3[] = br.readLine().trim().split(" ");
            
            for (i = 0; i < N; i++) {
                start[i] = Integer.parseInt(inputLine2[i]);
                end[i] = Integer.parseInt(inputLine3[i]);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.minLaptops(N, start, end));
        }
    }
}
// } Driver Code Ends


//User function Template for Java





class Pair{
    int start;
    int end;
    
    public Pair(int start, int end){
        this.start = start;
        this.end = end;
    }
}

class Solution {
    public int minLaptops(int N, int[] start, int[] end) {
    
        List<Pair> list = new ArrayList<>();
        
        for(int i = 0; i < N; i++){
            list.add(new Pair(start[i], end[i]));    
        }
        
        Collections.sort(list, new Comparator<Pair>(){
            @Override
            public int compare(Pair a, Pair b){
                if(a.start < b.start){
                    return -1;
                }    
                else if(b.start < a.start){
                    return 1;
                }
                return a.end - b.end;
            }
        });
        
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        pq.add(list.get(0).end);
        
        for(int i = 1; i < N; i++){
            if(pq.peek() <= list.get(i).start){
                pq.remove();
            }   
            pq.add(list.get(i).end);
        }
        
        return pq.size();
    }
}