class Solution 
{
    public static class Pair
    {
        int ele, ind;

        public Pair(int ele, int ind)
        {
            this.ele = ele;
            this.ind = ind;
        }
    }

    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) 
    {
        final int n = nums.length;

        final Pair[] minPrefix = new Pair[n + 1];
        final Pair[] maxPrefix = new Pair[n + 1];

        minPrefix[0] = new Pair(nums[0], 0);
        maxPrefix[0] = new Pair(nums[0], 0);

        for (int i = 1; i < n; i++)
        {
            minPrefix[i] = minPrefix[i - 1].ele <= nums[i] ? minPrefix[i - 1] : new Pair(nums[i], i);
            maxPrefix[i] = maxPrefix[i - 1].ele >= nums[i] ? maxPrefix[i - 1] : new Pair(nums[i], i);
        }

        for (int i = indexDifference; i < n; i++)
        {
            if (Math.abs(minPrefix[i - indexDifference].ele - nums[i]) >= valueDifference)
            {
                return new int[]{minPrefix[i - indexDifference].ind, i};
            }

            if (Math.abs(maxPrefix[i - indexDifference].ele - nums[i]) >= valueDifference)
            {
                return new int[]{maxPrefix[i - indexDifference].ind, i};
            }
        }

        return new int[]{-1, -1};
    }
}