class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>>lst=new ArrayList<>();
        List<Integer>grp;
        Map<Integer,List<Integer>>map=new HashMap<>();
        for(int i=0;i<groupSizes.length;i++){
            if(map.containsKey(groupSizes[i]))
                grp=map.get(groupSizes[i]);
            else
                map.put(groupSizes[i],grp=new ArrayList<>());
            grp.add(i);
            if(grp.size()==groupSizes[i]){
                lst.add(grp);
                map.remove(groupSizes[i]);
            }
        }
        return lst;
    }
}