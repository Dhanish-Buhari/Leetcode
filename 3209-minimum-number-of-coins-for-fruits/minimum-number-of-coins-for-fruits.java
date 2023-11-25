class Solution {
    private int[][] memo;
    public int minimumCoins(int[] prices) {
        memo = new int[prices.length][prices.length+1];
        for (int[] row : memo) Arrays.fill(row, -1);
        return dp(prices, 0, 0);
    }
    
    public int dp(int[] prices, int i, int freeCount) {
        if (i >= prices.length) {
            return 0;
        }
        
        if (memo[i][freeCount] != -1) {
            return memo[i][freeCount];
        }
        int take = dp(prices, i+1, i+1) + prices[i];
        int takeForFree = Integer.MAX_VALUE;
        
        if (freeCount > 0) {
            takeForFree = dp(prices, i+1, freeCount-1);
        }
        
        
        return memo[i][freeCount] = Math.min(take, takeForFree);
        
    }
}