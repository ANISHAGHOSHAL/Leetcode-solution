//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            int tmp = sc.nextInt();
            int[][] flights = new int[tmp][3];
            for (int i = 0; i < tmp; i++) {

                int u1 = sc.nextInt();
                int v1 = sc.nextInt();
                int w1 = sc.nextInt();
                flights[i][0] = u1;
                flights[i][1] = v1;
                flights[i][2] = w1;
            }

            Solution ob = new Solution();
            int ans = ob.minimumCost(flights, n, k);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java



// User function Template for Java

class Solution {
    private class Pair{
        int node;
        int weight;
        public Pair(int _node, int _weight){
            this.node = _node;
            this.weight = _weight;
        }
    }
    int minimumCost(int[][] flights, int n, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < n+1; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] flight : flights){
            adj.get(flight[0]).add(new Pair(flight[1], flight[2]));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        int[] distance = new int[n+1];
        Arrays.fill(distance, (int)1e8);
        distance[k] = 0;
        pq.offer(new Pair(k, 0));
        while(!pq.isEmpty()){
            int size = pq.size();
            while(size-- > 0){
                Pair head = pq.poll();
                for(Pair neighbour : adj.get(head.node)){
                    if(head.weight + neighbour.weight < distance[neighbour.node]){
                        distance[neighbour.node] = head.weight + neighbour.weight;
                        pq.offer(new Pair(neighbour.node, distance[neighbour.node]));
                    }
                }
            }
        }
        int ans = 0;
        for(int i = 1; i < distance.length; i++){
            if(distance[i] == (int)1e8) return -1;
            ans = Math.max(ans, distance[i]);
        }
        return ans;
    }
}
