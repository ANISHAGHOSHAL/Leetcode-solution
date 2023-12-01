class Solution {
public:
    string converter(vector<string>& vec) {
        string res = "";
        for(int i=0; i<vec.size(); i++) {
            res += vec[i];
        }
        return res;
    }
    bool arrayStringsAreEqual(vector<string>& word1, vector<string>& word2) {
        string str1 = converter(word1);
        string str2 = converter(word2);
        return str1 == str2; 
    }
};