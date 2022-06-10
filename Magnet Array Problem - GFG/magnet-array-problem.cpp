// { Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
class Solution{
    public:
        double searchBinary(double low, double high, double* LeftForce, int lefts, double* RightForce, int rights)
    {
    	double epsilon = 0.0000000000001;
    
    	double mid = (low + high)/2;
    	
    	double netForce = 0;
    
    	for(int i = 0; i < lefts; i++)
    		netForce += 1.0/(mid - LeftForce[i]);
    	for(int i = 0; i < rights; i++)
    		netForce -= 1.0/(RightForce[i] - mid);
    
    	if((-epsilon) < netForce && netForce < epsilon)
    		return mid;
    	else if (netForce > 0)
    		return searchBinary(mid, high, LeftForce, lefts, RightForce, rights);
    	else 
    		return searchBinary(low, mid, LeftForce, lefts, RightForce, rights);
    }
    
    void nullPoints(int n, double magnets[], double getAnswer[])
    {
    	for(int i=0; i<n-1; i++){
    		getAnswer[i] = searchBinary(magnets[i], magnets[i+1], magnets, i+1, magnets+i+1, n-1-i);
    	}
    }
};

// { Driver Code Starts.
int main()
{
    int t;
    cin>>t;
    while(t--)
    {
        int n;
        cin>>n;
        double magnets[n], getAnswer[n];
        for(int i=0;i<n;i++)
        cin>>magnets[i];
        Solution ob;
        ob.nullPoints(n, magnets, getAnswer);
        
        for(int i=0; i<n-1; i++)
            printf("%0.2lf ",getAnswer[i]);
        cout<<endl;
    }
    return 0;
}  // } Driver Code Ends