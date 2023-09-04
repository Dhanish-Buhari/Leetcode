class Solution {
    public String shortestPalindrome(String s) {
        int i = 0;
        int j;
        if(s.length()==1)return s;
        
        for(j=s.length(); j>=i; j--){
            if(isPalindrome(s.substring(i,j))){
                if(s.substring(j,s.length()).length()%2==1){
                    return reverse(s.substring(j,s.length()))+s;
                }
                return reverse(s.substring(j,s.length()))+s;
            }
        }
        return s+s;
        
    }
    public boolean isPalindrome(String s){
        int i = 0;
        int j =s.length()-1;
        while(i<j){
            if(s.charAt(i)==s.charAt(j)){
                i++;
                j--;
            }
            else{
                return false;
            }
        }
        return true;
    }

    public String reverse(String s){
        String rev = "";
        for(int i=0; i<s.length(); i++){
            rev=s.charAt(i)+rev;
        }
        return rev;
    }
}