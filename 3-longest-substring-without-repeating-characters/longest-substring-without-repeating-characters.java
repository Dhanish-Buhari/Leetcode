class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i=0;
        int j=0;
        int ans = 0;
        HashSet<Character> st = new HashSet<>();
        while(j<s.length()){
            if(st.contains(s.charAt(j))){
                while(s.charAt(i)!=s.charAt(j)){
                    st.remove(s.charAt(i));
                    i++;
                }
                i++;
            }
            st.add(s.charAt(j));
            ans = Math.max(j-i+1,ans);
            j++;
        }
        return ans;
    }
}