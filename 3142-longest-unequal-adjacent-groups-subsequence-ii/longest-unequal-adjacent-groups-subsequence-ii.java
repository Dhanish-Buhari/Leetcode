class Solution {
    public boolean hammingDistance(String s1, String s2) {
        int count = 0;
        for(int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)) count++;            
        }
        return count == 1;
    }
    public List<String> getWordsInLongestSubsequence(int n, String[] words, int[] groups) {
        int[] dp = new int[n];
        int[] hash = new int[n];
        Arrays.fill(dp, 1);

        int size = 0, lastIdx = 0;

        for(int i = 0; i < n; i++){
            hash[i] = i;
            for(int prevIdx = 0; prevIdx < i; prevIdx++){
               if(groups[i] != groups[prevIdx] && words[i].length() == words[prevIdx].length() && hammingDistance(words[i], words[prevIdx]) && dp[i] < 1 + dp[prevIdx]){
                   dp[i] = dp[prevIdx] + 1;
                   hash[i] = prevIdx;
               }
            }  
            if(size < dp[i]){
                size = dp[i];
                lastIdx = i;
            }       
        }

        String[] LIS = new String[size];

        // filling LIS array from last because we will get values in reverse order

        LIS[size - 1] = words[lastIdx];

        int idx = size - 2;

        while(hash[lastIdx] != lastIdx){
            lastIdx = hash[lastIdx];
            LIS[idx--] = words[lastIdx];
        }
        
        return new ArrayList<>(Arrays.asList(LIS));
    }
}