

class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        Pair[] a = new Pair[n];
        for (int i = 0; i < n; i++) {
            a[i] = new Pair(nums[i], i);
        }
        
        Arrays.sort(a, (p1, p2) -> Integer.compare(p1.val, p2.val));
        
        List<Integer>[] x = new ArrayList[n];
        List<Integer>[] y = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            x[i] = new ArrayList<>();
            y[i] = new ArrayList<>();
        }
        
        int j = 0, cur = a[0].val;
        x[j].add(a[0].val);
        y[j].add(a[0].idx);
        for (int i = 1; i < n; i++) {
            if (a[i].val - cur > limit) {
                j++;
            }
            x[j].add(a[i].val);
            y[j].add(a[i].idx);
            cur = a[i].val;
        }
        
        for (int i = 0; i < n; i++) {
            Collections.sort(y[i]);
        }
        
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            for (j = 0; j < x[i].size(); j++) {
                res[y[i].get(j)] = x[i].get(j);
            }
        }
        
        return res;
    }
    
    class Pair {
        int val, idx;
        Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }
}

