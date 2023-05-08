class Solution {
    public int diagonalSum(int[][] mat) {
      int i=0,j=mat.length-1,k=0,s=0;
      while(i<mat.length){
           if(k!=j)
           s+=(mat[i][k]+mat[i][j]);
           else
           s+=mat[i][j];
           i++;k++;j--;
      }
      return s;
    }
}