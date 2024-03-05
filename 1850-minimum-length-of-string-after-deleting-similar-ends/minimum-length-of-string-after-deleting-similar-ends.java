class Solution {
    public int minimumLength(String s) {
        int i=0;
        int j= s.length()-1;
        int min = j-i+1;
        char c='*';
        while(i<j && s.charAt(i)==s.charAt(j)){
            c=s.charAt(i);
                while(i<=j && s.charAt(i)==c){
                 i++;
                }
                while(i<=j && s.charAt(j)==c){
                    j--;
                
                }
                System.out.print(i+" "+j);
                
            }
        
min = Math.min(min,j-i+1);
return min;   

 }
}