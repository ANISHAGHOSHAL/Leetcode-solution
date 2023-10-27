class Solution {
    
    string pally(string& s, int L, int R) {
        int n = s.length();
        while(L >= 0 && R < n) {
            if(s[L] != s[R]) break;
            L--;
            R++;
        }
        return s.substr(L+1, R - L - 1);
    } 
    
    void bestAns(string& ans, string& candidate, int& ansLen) {
        if(candidate.length() > ansLen) {
            ans = candidate;
            ansLen = candidate.length();
        }
    }
    
public:
    string longestPalindrome(string s) {
        int ansLen = 0;
        string ans = "";
        int n = s.length();
        for(int i = 0; i < n; i++) {
            string odd = pally(s, i, i);
            bestAns(ans, odd, ansLen);
            string even = pally(s, i-1, i);
            bestAns(ans, even, ansLen);
        }
        return ans;
    }
};