class Solution {
    public char findTheDifference(String s, String t) {
        int arr[] = new int[26];
        for(int i=0; i<t.length(); i++){
            arr[t.charAt(i)-'a']++;
            if(i<s.length()){
                arr[s.charAt(i)-'a']--;
            }
        }
        char a='a';
        for(int i=0; i<26; i++){
            if(arr[i]==1){
                a = (char)(i+97);
           }
        }
        return a;  
    }
}