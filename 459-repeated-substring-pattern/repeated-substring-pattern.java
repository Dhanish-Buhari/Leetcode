class Solution {
    public boolean repeatedSubstringPattern(String s) {
        String temp = s+s;
        String sub = temp.substring(1,temp.length()-1);
            System.out.print(temp+" "+sub);
        return sub.contains(s);
    }
}

