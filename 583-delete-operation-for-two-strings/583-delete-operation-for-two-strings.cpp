class Solution {
public:
    int dp[501][501];
   
    int minDistance(string &word1, string &word2) {
       
       memset(dp,-1,sizeof(dp));
        return del(word1,word2,0,0);
    }
     int del(string &word1,string &word2,int i,int j)
    {
        if(i==word1.size() and j==word2.size())
        {
            return 0;
        }
        if(i==word1.size() or j==word2.size())
        {
            return max(word1.size()-i,word2.size()-j);
        }
        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }
        if(word1[i]==word2[j])
        {
            return del(word1,word2,i+1,j+1);
        }
        return dp[i][j]=1+min(del(word1,word2,i+1,j),del(word1,word2,i,j+1));
    }

};
