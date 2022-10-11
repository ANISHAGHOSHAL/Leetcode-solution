//{ Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
// User function Template for C++


class Solution{
public:
       string helper(int &pos , string s)

    {

        long long num=0;

        string word ="";

        for(;pos<s.size();pos++)

        {

            char cur = s[pos];

            if(cur=='[')

            {

                string curstr = helper(++pos,s);

                

                for(;num>0;num--)

                {

                    word+=curstr;

                }

            }

            

            else if(cur>='0' && cur<='9'){

                num = num*10 + cur-'0';

            }

            

            else if(cur==']'){

                return word;

            }else{

                word+=cur;

            }

        }

        return word;

    }

    string decodedString(string s){

        int n =  s.size();

        int pos =0;

       return helper(pos,s);

        

    }
};

//{ Driver Code Starts.

int main(){
    int t;
    cin>>t;
    while(t--){
        string s;
        cin>>s;
        
        Solution ob;
        cout<<ob.decodedString(s)<<"\n";
    }
    return 0;
}
// } Driver Code Ends