// Time: O(N); Space: O(N)
class Solution {
    public int minOperations(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int max1 = 0, max2 = 0;

        for (int i = 0; i < n; i++) {
            max1 = Math.max(max1, nums1[i]);
        }

        for (int i = 0; i < n; i++) {
            max2 = Math.max(max2, nums2[i]);
        }

        if (max1 == nums1[n - 1] && max2 == nums2[n - 1]) {
            return 0;
        }

        int cand1 = swap(nums1, nums2, n);
        int cand2 = noSwap(nums1, nums2, n);
        if (cand1 == -1 && cand2 == -1) {
            return -1;
        }

        return Math.min(cand1, cand2);
    }

    private int swap(int[] nums1, int[] nums2, int n) {
        int res = 1, n1 = nums2[n - 1], n2 = nums1[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (nums1[i] > n1 || nums2[i] > n2) {
                if (nums1[i] > n2 || nums2[i] > n1) {
                    return -1;
                } else {
                    res++;
                }
            }
        }

        return res;
    }

    private int noSwap(int[] nums1, int[] nums2, int n) {
        int res = 0, n1 = nums1[n - 1], n2 = nums2[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (nums1[i] > n1 || nums2[i] > n2) {
                if (nums1[i] > n2 || nums2[i] > n1) {
                    return -1;
                } else {
                    res++;
                }
            }
        }

        return res;
    }
}