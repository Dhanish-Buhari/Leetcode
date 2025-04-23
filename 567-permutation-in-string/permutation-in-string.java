class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length())return false;
        int ht[] = new int[256];
        for(int i=0; i<s1.length(); i++){
            ht[s1.charAt(i)]++;
        }
        int j = 0;
        for(j=0; j<s1.length(); j++){
            ht[s2.charAt(j)]--;
        }
        j--; //very very important stand at the end of the window expand window in next while loop.
        if(isEmpty(ht))return true;
        int i = 0;
        while(j<s2.length()){
            ht[s2.charAt(i)]++;
            i++;
            j++;
            if(j<s2.length())ht[s2.charAt(j)]--;
            if(isEmpty(ht))return true;
        }
        return false;
    }

    public boolean isEmpty(int [] arr){
        for(int i=0; i<arr.length; i++){
            if(arr[i]!=0)return false;
        }
        return true;
    }
}