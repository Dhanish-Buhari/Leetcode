class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int dp[] = new int[cost.length+1];
        Arrays.fill(dp,-1);
        return Math.min(helper(cost,0,dp),helper(cost,1,dp));
    }
    public int helper(int []cost, int idx, int [] dp){
        if(idx>=cost.length){
            return 0;
        }
        if(dp[idx]!=-1)return dp[idx];
        return dp[idx]=Math.min(cost[idx]+helper(cost,idx+1,dp),cost[idx]+helper(cost,idx+2,dp));
    }
}