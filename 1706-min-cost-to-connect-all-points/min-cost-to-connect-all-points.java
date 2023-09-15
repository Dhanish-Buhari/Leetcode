class Solution {
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<int[]>pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.offer(new int[]{0,0});
        int n = points.length;
        int sum = 0;
        Set<Integer> visited = new HashSet<>();
        while(visited.size()<n){
            int arr[] = pq.poll();
            //System.out.println(arr[0]+" "+arr[1]+" "+visited);
            if(visited.contains(arr[1]))continue;
            sum+=arr[0];
            visited.add(arr[1]);
            int currNode = arr[1];
            for(int nextNode = 0; nextNode<n; nextNode++){
                int dist = Math.abs(points[nextNode][0]-points[currNode][0])+Math.abs(points[nextNode][1]-points[currNode][1]);
                pq.offer(new int[]{dist,nextNode});
            }
        }
        return sum;
    }
}