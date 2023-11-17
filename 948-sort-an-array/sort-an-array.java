class Solution {
    public int[] sortArray(int[] nums) {
        int[] res=new int[nums.length];
       PriorityQueue<Integer> pq=new PriorityQueue<>();
       for(int i=0;i<nums.length;i++){
           pq.offer(nums[i]);
       }
      int index=0;
      while(!pq.isEmpty())     {
         res[index++]=pq.poll();
      }  
      return res;
    }
}