class Solution {
	public int numDecodings(String s) {
        int n=s.length();
        Integer[] mem=new Integer[n];
        return s.length()==0?0:numDecodings(0,s,mem);      
    }
    private int numDecodings(int i, String s, Integer[] mem) {
        int n=s.length();
        if(i==n) return 1;
        if(s.charAt(i)=='0') return 0;
        if(mem[i]!=null) return mem[i];
        int res=numDecodings(i+1,s,mem);
        if(i<n-1&&(s.charAt(i)=='1'||s.charAt(i)=='2'&&s.charAt(i+1)<='6')) 
			res+=numDecodings(i+2,s,mem);
        return mem[i]=res;
    }
}