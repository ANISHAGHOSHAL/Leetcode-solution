//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution{
public:

       void solve(int value , int n , int m , int &count)
    {
        //base case
        if(value > m)return;
        
        if(n<=value && value<=m)count++;
        
        int back = value%10;
        
        if(back != 0)solve(value*10 + (back-1) , n , m , count);
        if(back != 9)solve(value*10 + (back+1) , n , m , count);
        
    }
    int steppingNumbers(int n, int m)
    {
        int count =0;
        
        if(n==0)count++;
        
        for(int i=1;i<=9;i++)
        {
            solve(i,n,m,count);
        }
        return count;
    }
    // bool check(int i){
    //     int t= i,before = INT_MIN;
    //     while(t){
    //         int lastEle = t%10;
    //             if(t!=i){
    //                 if(lastEle-before!=1 && before-lastEle!=1)
    //                 return false;
    //                 before = lastEle;
    //             }
    //             else before = lastEle;
                
    //             t/=10;
    //         }
    //         return true;
    // }
    // int steppingNumbers(int n, int m)
    // {
    //     // Code Here
    //     int sou = n,count = 0;
    //     for(int i = n ;i<=m;i++){
            
    //         if(i<=10)count++;
    //         else{
                
    //             if(check(i)) count++;
    //         }
    //     }
    //     return count;
    // }
};


//{ Driver Code Starts.

int main()
{
    Solution obj;
    int t;
    cin>>t;
    while(t--)
    {
        int n, m;
        cin>>n>>m;
        cout << obj.steppingNumbers(n,m) << endl;
    }
	return 0;
}


// } Driver Code Ends