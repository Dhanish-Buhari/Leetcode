class Solution {
    public int[] searchRange(int[] nums, int target) {
        int i,j;
        int arr [] = new int[2];
        Arrays.fill(arr,-1);
        for(i=0; i<nums.length; i++){
            if(nums[i]==target){
                arr[0]=i;
                break;
            }
        }
        for(j=nums.length-1; j>=0; j--){
            if(nums[j]==target){
                arr[1]=j;
                break;
            }
        }
        return arr;
    }
}