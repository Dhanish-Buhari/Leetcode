class Solution {
    public int uniquePathsWithObstacles(int [][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int [][] dp = new int[m][n];
        for(int arr[]:dp){
            Arrays.fill(arr,-1);
        }
        return helper(0,0,m,n,dp,grid);
    }
    public int helper(int i, int j, int m, int n,int[][] dp,int [][] grid){
        if(i==m-1 && j==n-1 && grid[i][j]==0){
            return 1;
        }
        if(i>=m || j>=n || grid[i][j]==1){
            return 0;
        }
        if(dp[i][j]!=-1)return dp[i][j];
        return dp[i][j]=helper(i+1,j,m,n,dp,grid)+helper(i,j+1,m,n,dp,grid);
    }
}

/*class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        return helper(obstacleGrid,0,0,m,n);
    }
    public int helper(int[][] grid,int r,int c,int m,int n){
        if(r == m || c == n || grid[r][c] == 1)return 0;
        if(r == m-1 && c == n-1){
            if(grid[r][c] == 1)return 0;
            return 1;
        }
        return helper(grid,r+1,c,m,n)+helper(grid,r,c+1,m,n);
    }
}*/