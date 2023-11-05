class Solution {
    // public int getWinner(int[] arr, int k) {
    //    List<Integer> ls = new ArrayList<>();
    //    for(int a: arr){
    //        ls.add(a);
    //    }
    //     int count = 0;
    //     while(count!=k && count<arr.length){
    //         if(ls.get(0)<ls.get(1)){
    //             count=1;
    //             int temp = ls.get(0);
    //             ls.set(0,ls.get(1));
    //             ls.remove(1);
    //             ls.add(temp);
    //         }
    //         else{
    //             count++;
    //             int var = ls.get(1);
    //             ls.remove(1);
    //             ls.add(var);
    //         }
    //      //   System.out.println(ls+" "+count);
    //     }
    //     return ls.get(0);
    // }
        public int getWinner(int[] A, int k) {
        int cur = A[0], win = 0;
        for (int i = 1; i < A.length; ++i) {
            if (A[i] > cur) {
                cur = A[i];
                win = 0;
            }
            if (++win == k) break;
        }
        return cur;
    }
}