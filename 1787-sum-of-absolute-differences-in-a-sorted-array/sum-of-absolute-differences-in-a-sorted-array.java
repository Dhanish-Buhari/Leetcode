class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int[] prefixSum = new int[n];
        int sum = 0;
        for (int i = 0; i < n; ++i) {
            sum += nums[i];
            prefixSum[i]=sum;
        }
        for (int i = 0; i < n; ++i) {
            res[i] = (i+1)*nums[i]-prefixSum[i] + (sum-prefixSum[i])-((n-i-1)*nums[i]);
        }
        return res;
    }
}