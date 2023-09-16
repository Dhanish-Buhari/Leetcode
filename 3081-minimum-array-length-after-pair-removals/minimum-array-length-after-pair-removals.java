class Solution {
    public int minLengthAfterRemovals(List<Integer> num) {
        int ans = 0;
        // int i =0;
        // int j = nums.size()-1;
        // while(i<j){
        //     if(nums.get(i)<nums.get(j)){
        //         ans+=2;
        //     }
        //     if(nums.get(i)==nums.get(j)){
        //         break;
        //     }
        //     i++;
        //     j--;
        // }
        // return nums.size()-ans;
              int[] nums = num.stream()
                              .mapToInt(Integer::intValue)
                              .toArray();
//         int max =  nums[0];
//         int i = 0;
//         while(i<nums.length){
//             if(nums[i]==max){
//                 i++;
//                 continue;
//             }
//             if(nums[i]>max){
//                 ans+=2;
//                    if(i+1==nums.length){
//                     break;
//                 }
//                 max=nums[i+1];
             
//             }
//             i++;
//         }
//         return num.size()-ans;
//         Stack<Integer> stk = new Stack<>();
//         stk.push(nums[0]);
//         int i = 1;
//             while(i<nums.length || !stk.isEmpty()){
//                 if(i>=nums.length){
//                     return stk.size();
//                 }
//                 if(!stk.isEmpty() && stk.peek()<nums[i]){
//                     ans+=2;
//                     stk.pop();
                   
//                 }
//                 else{
//                     stk.push(nums[i]);
//                 }
//                  i++;
//             }
            
//         return stk.size();
        
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->b.val-a.val);
        for(Map.Entry<Integer,Integer> map: mp.entrySet()){
            pq.add(new Pair(map.getKey(),map.getValue()));
        }
        while(pq.size()>1){
            Pair poll1 = pq.poll();
            Pair poll2 = pq.poll();
            System.out.println(poll1.key+" "+poll1.val+" "+poll2.key+" "+poll2.val);
            // if(poll1.val==poll2.val){
            //     continue;
            // }
            if(poll1.val-1>0){
                pq.add(new Pair(poll1.key,poll1.val-1));
            }
            if(poll2.val-1>0){
                 pq.add(new Pair(poll2.key,poll2.val-1));
            }
           
        }
        return pq.size()==0?0:pq.peek().val;
        
    }
    class Pair{
        int key;
        int val;
        Pair(int key, int val){
            this.key=key;
            this.val=val;
        }
    }
}