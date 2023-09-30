class Solution {
    public int maxSubarrays(int[] nums) {
        int arr[] = nums;
        int and = nums[0];
        for(int i=1; i<nums.length; i++){
            and&=nums[i];
        }
        int ans = 0;
        int var = nums[0];
        for(int i=0; i<nums.length; i++){
            if(var==Integer.MAX_VALUE)var=nums[i];
            else{
            var&=nums[i];
            }
            if(var==and){
                ans++;
                // if(i+1<nums.length){
                //     var=nums[i+1];
                // }
                var=Integer.MAX_VALUE;
            }
        }
        return and==0?ans:1;
    }
}