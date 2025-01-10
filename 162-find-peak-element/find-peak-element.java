class Solution {
    public int findPeakElement(int[] nums) {
        int max = nums[0];
        int temp = max;
        int maxInd = 0;
        int ans = 0;
        boolean flag = false;
        for(int i=1; i<nums.length; i++){
            max=Math.max(max,nums[i]);
            if(max>temp){
                maxInd=i;
                temp=max;
            }
            if(i<nums.length-1 && nums[i-1]<nums[i] && nums[i+1]<nums[i]){
                flag = true;
                ans = i;
            }
        }
        if(flag){
            return ans;
        }
        return maxInd;
    }
}