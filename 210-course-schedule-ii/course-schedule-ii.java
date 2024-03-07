class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = numCourses;
        int m = prerequisites.length;
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<m; i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        int indegree[] = new int[n];
        for(int i=0; i<n; i++){
            for(int it: adj.get(i)){
                indegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        List<Integer> topo = new ArrayList<>();
        while(!q.isEmpty()){
            int num = q.peek();
            q.remove();
            topo.add(num);
            for(int it:adj.get(num)){
                indegree[it]--;
                if(indegree[it]==0)q.add(it);
            }
        }
        int[] primitive = topo.stream().mapToInt(Integer::intValue).toArray();
        if(topo.size( )==n)return primitive;
        return new int[]{};
    }
}

