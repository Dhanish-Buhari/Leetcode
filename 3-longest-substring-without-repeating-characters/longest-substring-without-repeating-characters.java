class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        Set<Character> st = new HashSet<>();
        int max = 0;
        while(left<s.length()&&right<s.length()){
            if(st.contains(s.charAt(right))){
                while(s.charAt(left)!=s.charAt(right)){
                    st.remove(s.charAt(left));
                    left++;
                }
                left++;
            }
                st.add(s.charAt(right));
                max=Math.max(right-left+1,max);
                right++;
        }
        return max;
    }
}