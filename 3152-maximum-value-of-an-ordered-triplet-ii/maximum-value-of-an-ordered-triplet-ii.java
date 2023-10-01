class Solution {
    public long maximumTripletValue(int[] nums) {
        long ans = 0;
        int n = nums.length;
        int[] maxDiff = new int[n];
        maxDiff[0] = 0;
        int curMax = nums[0];
        for (int i = 1; i<nums.length; i++) {
            maxDiff[i] = maxDiff[i-1];
            if (nums[i] < curMax) {
                maxDiff[i] = Math.max(maxDiff[i], curMax- nums[i]);
            }
            curMax = Math.max(curMax, nums[i]);
            
        }
        // now loop over k
        for (int k = 2; k<n; k++) {
            ans = Math.max(ans, (long) nums[k] * (long) maxDiff[k-1]);
        }
        return ans;
    }
}