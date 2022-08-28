class Solution {
    public int[][] diagonalSort(int[][] mat) {
        
        int n = mat.length, m = mat[0].length,a = 0 ,b=  0;
        
        for(int i = 0; i < m; i++)sortDiag(a,i,mat,n,m); 
        for(int i = 1; i < n; i++)sortDiag(i,b,mat,n,m);
        
        return mat;
    }
    
    void sortDiag(int a, int b, int[][] mat, int n, int m){
        int[] aux = new int[Math.min(n,m)]; 
     
        int idx = 0,a2 = a, b2 = b;
        while(a < n && b < m)aux[idx++] = mat[a++][b++];
        
        Arrays.sort(aux);
        for(int k = 0; k < aux.length; k++ )if(aux[k] != 0){ idx = k; break; }
        
		while(a2 < n && b2 < m) mat[a2++][b2++] = aux[idx++];
        
    } 
}