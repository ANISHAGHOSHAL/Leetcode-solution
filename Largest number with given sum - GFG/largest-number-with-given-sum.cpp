// { Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


 // } Driver Code Ends
// Function to return Largest Number

class Solution
{
    public:
    //Function to return the largest possible number of n digits
    //with sum equal to given sum.
    string largestNumber(int n, int sum)
    {
        //maximum achievable sum is 9*n. if given sum is 
        //greater than that, we return -1.
        if(sum > 9*n)
    		return "-1";
        
        int temp;
        string str = "";
    	for(int i=0;i<n;i++)
    	{
    	    temp = 0;
    		if(sum!=0)
    		    //if sum>9 we store 9 in temp as digit or we store the sum.
    			temp = sum>9? 9 : sum;
    			
    		//storing the number in temp as character in final string.
    		str += (char)(temp + '0');
    		//updating the sum.
    		sum -= temp;
    	}
    	//returning the final string.
    	return str;
    }
};

// { Driver Code Starts.
int main()
{
    //taking testcases
	int t;
	cin>>t;

	while(t--)
	{
	    //taking n and sum
		int n,sum;
		cin>>n>>sum;
		
        Solution obj;
        //function call
		cout<<obj.largestNumber(n, sum)<<endl;
	}
	return 0;
}  // } Driver Code Ends