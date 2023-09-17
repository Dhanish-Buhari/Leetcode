class Solution {
    int cnt = 0;
    public int countWays(List<Integer> num) {
        int[] nums = num.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(nums);
//         helper(arr.length-1,arr,0);
//         return cnt;               
            
//     }
//     public void helper(int idx, int arr[], int sum){
//         if(idx==0){
//             if(sum>arr[idx]){
//                 System.out.println(sum+" "+arr[idx]);
//                 cnt++;
//                 return;
//             }
//             return;
//         }
//      helper(idx-1,arr,sum);
//      helper(idx-1,arr,sum=sum+1);
       
//         return ;
        int cnt = 0;
        int n = nums.length;
        // int chk = 1;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++){
            if(nums[i]<i+1){
                if(i<n-1 && nums[i+1]>i+1)cnt++;
                else if(i==n-1)cnt++;
            }        
        }
        if(nums[0]>0){
            cnt++;
        }
        return cnt;
    }
}