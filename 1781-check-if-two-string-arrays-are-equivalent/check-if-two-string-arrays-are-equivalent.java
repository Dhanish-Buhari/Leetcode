class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String first="",second="";
        for(String a: word1){
            first+=a;
        }
        for(String b: word2){
            second+=b;
        }
        if(first.equals(second)){
            return true;
        }
        return false;
    }
}