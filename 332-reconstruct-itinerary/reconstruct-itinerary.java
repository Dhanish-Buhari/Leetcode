class Solution {
    Map<String,PriorityQueue<String>> mp = new HashMap<>();
    LinkedList<String> ans = new LinkedList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        for(List<String> ls : tickets){
            mp.putIfAbsent(ls.get(0),new PriorityQueue<>());
            mp.get(ls.get(0)).add(ls.get(1));
        }
        dfs("JFK");
        //Collections.sort(ans,Collections.reverseOrder());
        return ans;
    }
    public void dfs(String airport){
        PriorityQueue<String> tic = mp.get(airport);
        System.out.println(tic);
        while(tic!=null && !tic.isEmpty()){
            dfs(tic.poll());
        }
        ans.addFirst(airport);
        return;
    }
}