import java.util.Arrays;

class Solution {
    public int findMaximumLength(int[] nums) {
        int n = nums.length;

        long[] pre = new long[n + 1];
        for (int i = 1; i <= n; i++)
            pre[i] = pre[i - 1] + nums[i - 1];

        Pair[] dp = new Pair[n + 1];
        for (int i = 0; i <= n; i++)
            dp[i] = new Pair(0, Long.MAX_VALUE);

        dp[0] = new Pair(0, 0);
        for (int i = 1; i <= n; i++) {
            long prevSum = dp[i - 1].second;
            long needed = pre[i - 1] + prevSum;

            int low = i;
            int high = n;
            int where = -1;
            while (low <= high) {
                int mid = (low + high) / 2;

                if (pre[mid] >= needed) {
                    where = mid;
                    high = mid - 1;
                } else
                    low = mid + 1;
            }
            if (where != -1) {
                Pair p = new Pair(dp[i - 1].first + 1, pre[where] - pre[i - 1]);

                if (dp[where].first < dp[i - 1].first + 1)
                    dp[where] = p;
                else if (dp[where].first == dp[i - 1].first + 1)
                    dp[where].second = Math.min(dp[where].second, pre[where] - pre[i - 1]);
            }

            if (dp[i].first < dp[i - 1].first)
                dp[i] = new Pair(dp[i - 1].first, dp[i - 1].second + pre[i] - pre[i - 1]);
            else if (dp[i].first == dp[i - 1].first)
                dp[i].second = Math.min(dp[i].second, pre[i] - pre[i - 1] + dp[i - 1].second);
        }

        int ans = 0;
        for (Pair pair : dp)
            ans = Math.max(ans, pair.first);

        return ans;
    }

    // Custom Pair class to hold two values
    class Pair {
        int first;
        long second;

        public Pair(int first, long second) {
            this.first = first;
            this.second = second;
        }
    }
}