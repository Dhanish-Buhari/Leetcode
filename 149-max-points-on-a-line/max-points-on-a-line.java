class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if(n==1) return 1;
        int globalCount = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){
            int x1 = points[i][0];
            int y1 = points[i][1];
            Map<String,Integer> slope = new HashMap<>();
            int repeated = 1;
            int maxPoints = Integer.MIN_VALUE;

            for(int j = i+1; j < n; j++){
                int x2 = points[j][0];
                int y2 = points[j][1];

                if(x1 == x2 && y1 == y2){
                    repeated++;
                    continue;
                }

                int x = x2-x1;
                int y = y2-y1;
                //breaking the points
                int gcd = gcd(x,y);
                x = x/gcd;
                y = y/gcd;

                //to avoid negative numbers
                if((x < 0 && y < 0) || (x > 0 && y < 0)){
                    x *= -1;
                    y *= -1;
                }
                String key = x + "-" + y;
                slope.put(key, slope.getOrDefault(key,0)+1);

                maxPoints = Math.max(maxPoints,slope.get(key));
            }
            globalCount = Math.max(globalCount, (maxPoints + repeated));
        }
        return globalCount;
    }
    private int gcd(int big, int small){
        if(small == 0) return big;
        return gcd(small, big%small);
    }
}