// { Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
class Solution{
	public:
	// direction vector for the Knight
	vector<int>dx = { 1, 2, 2, 1, -1, -2, -2, -1};
	vector<int>dy = { 2, 1, -1, -2, -2, -1, 1, 2};
	 
	// returns true if the knight is inside the chessboard
	bool inside(int N,int x, int y)
	{
	    return (x >= 0 and x < N and y >= 0 and y < N);
	}
	 
	// Bottom up approach for finding the probability to
	// go out of chessboard.
	double findProb(int N,int start_x, int start_y, int steps)
	{
	    // dp array
	    double dp1[N][N][N];
	 
	    // for 0 number of steps, each position
	    // will have probability 1
	    for (int i = 0; i < N; ++i)
	        for (int j = 0; j < N; ++j)
	            dp1[i][j][0] = 1;
	 
	    // for every number of steps s
	    for (int s = 1; s <= steps; ++s)
	    {
	        // for every position (x,y) after
	        // s number of steps
	        for (int x = 0; x < N; ++x)
	        {
	            for (int y = 0; y < N; ++y)
	            {
	                double prob = 0.0;
	 
	                // for every position reachable from (x,y)
	                for (int i = 0; i < 8; ++i)
	                {
	                    int nx = x + dx[i];
	                    int ny = y + dy[i];
	 
	                    // if this position lie inside the board
	                    if (inside(N,nx, ny))
	                        prob += dp1[nx][ny][s-1] / 8.0;
	                }
	 
	                // store the result
	                dp1[x][y][s] = prob;
	            }
	        }
	    }
	 
	    // return the result
	    return dp1[start_x][start_y][steps];
	}
};


// { Driver Code Starts.
int main(){
	int tc;
	cin >> tc;
	while(tc--){
		int N, start_x, start_y, steps;
		cin >> N >> start_x >> start_y >> steps;
		Solution ob;
		double ans = ob.findProb(N, start_x, start_y, steps);
		cout << fixed << setprecision(6) << ans <<"\n";
	}  
	return 0;
}  // } Driver Code Ends