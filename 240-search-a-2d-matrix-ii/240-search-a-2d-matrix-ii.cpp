class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
		int R = matrix.size();         //number of rows.
        int C = matrix[0].size();     //number of columns.
        int i = 0 , j = C - 1;           //choosing iterator i & j to search the target.
        while(i < R && j >= 0)
        {
            if(matrix[i][j] == target)   //if we find the target we return true.
                return true;
            else if(matrix[i][j] < target)     //if the value at position i & j is smaller than target then we move downward to next column. 
                i ++;
            else                   // else if value at i & j is greater than target then we go leftward in same row.
                j --;
        }
        return false;       // if the target element is not present in the matrix then return false.
    }
};