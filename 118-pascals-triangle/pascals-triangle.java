class Solution {
    public List<List<Integer>> generate(int n) {
        List<Integer> pre = null;
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i<n; i++){
        List<Integer> ls = new ArrayList<>();
            // if(pre==null){
            //     ls.add(1);
            //     pre=ls;
            //     continue;
            // }
            for(int j=0;j<=i; j++){
                if(j==0 || j==i){
                    ls.add(1);
                } 
                else{
                    ls.add(pre.get(j-1)+pre.get(j));
                }
            }
            pre=ls;
            ans.add(ls);
        }
   
        return ans;
    }
}