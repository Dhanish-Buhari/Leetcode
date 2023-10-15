class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] p = new int[n][m];
        int MOD = 12345;

        long next = 1;
        for (int i = n-1; i >= 0; i--) {
            for (int j = m-1; j >= 0; j--) {
                p[i][j] = (int)next;
                next = ((long)next * grid[i][j]) % MOD; 
            }
        }
        
        next = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                p[i][j] = (int)((p[i][j]*next) % MOD);
                next = ((long)next * grid[i][j]) % MOD; 
            }
        }
        
        return p;
        
        
    }
}