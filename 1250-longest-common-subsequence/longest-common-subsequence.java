class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int dp[][] = new int[text1.length()+1][text2.length()+1];
        for(int arr[]:dp){
            Arrays.fill(arr,-1);
        }
        return helper(0,0,text1,text2,dp);
    }
    public int helper(int i, int j,String a, String b,int dp[][]){
        if(i==a.length()|| j==b.length()){
            return 0;
        }
        if(dp[i][j]!=-1)return dp[i][j];
        if(a.charAt(i)==b.charAt(j)){
            return 1+helper(i+1,j+1,a,b,dp);
        }
        return dp[i][j]=Math.max(helper(i+1,j,a,b,dp),helper(i,j+1,a,b,dp));
    }
}