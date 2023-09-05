class Solution {
    public int trap(int[] nums) {
        int left = 0;
        int right =nums.length-1;
        int maxL = nums[left];
        int maxR = nums[right];
        int sum = 0;
        while(left<=right){
            if(maxL<=maxR){
                int var = maxL-nums[left];
                if(var>=0){
                    sum+=var;
                }
                if(nums[left]>maxL){
                    maxL=nums[left];
                }
                left++;
            }
            else{
                int var = maxR-nums[right];
                if(var>=0){
                    sum+=var;
                }
                if(nums[right]>maxR){
                    maxR=nums[right];
                }
                right--;

            }
        }
    return sum;
    }
}