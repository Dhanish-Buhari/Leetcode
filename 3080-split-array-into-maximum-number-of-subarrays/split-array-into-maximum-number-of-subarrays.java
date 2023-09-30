class Solution {
    public int maxSubarrays(int[] nums) {
        int and = Integer.MAX_VALUE;
        for(int a:nums){
            and&=a;
        }
        int ans = 0;
        int curr = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++){
            if(curr==Integer.MAX_VALUE)curr=nums[i];
            else{
                curr&=nums[i];
            }
            if(curr==and){
                ans++;
                curr=Integer.MAX_VALUE;
            }
        }
        return and==0?ans:1;
    }
}