class Solution {
  public boolean isPossible(int x, Map<Integer, Integer> countMap) {
        for (int count : countMap.values()) {
            int remainder = count % x;
            int quotient = count / x;

            if (remainder < x - 1) {
                int required = (x - 1) - remainder;
                if (quotient >= required) {
                    remainder = x - 1;
                }
            }

            if (0 < remainder && remainder < x - 1) {
                return false;
            }
        }

        return true;
    }

    public int minGroupsForValidAssignment(int[] nums) {
        int totalGroups = nums.length;
        int minimumCount = totalGroups;
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        for (int count : countMap.values()) {
            minimumCount = Math.min(minimumCount, count);
        }

        for (int i = minimumCount + 1; i > 0; i--) {
            if (isPossible(i, countMap)) {
                int result = 0;
                for (int count : countMap.values()) {
                    int remainder = count % i;
                    result += count / i;
                    if (remainder > 0) {
                        result += 1;
                    }
                }
                return result;
            }
        }

        return -1;
    }

}