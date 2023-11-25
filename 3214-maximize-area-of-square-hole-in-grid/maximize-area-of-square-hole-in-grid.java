class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        // int i=0,j=0;
        // Arrays.sort(hBars);
        // HashSet<Integer> st = new HashSet<>();
        // for(i=0;i<vBars.length; i++){
        //     st.add(vBars[i]);
        // }
        // int max =Integer.MIN_VALUE;
        // int val = 1;
        // while(j<hBars.length){
        //     val=1;
        //     while(j<hBars.length && st.contains(hBars[j])){
        //         val++;
        //         j++;
        //     }
        //     max=Math.max(val,max);
        //     j++;
        // }
        // return max*max;
        Arrays.sort(hBars);
        Arrays.sort(vBars);
        int i=0,j=0;
        int hcnt = 1;
        int hpre = hBars[0];
        int hmax = 1;
        int vcnt = 1;
        int vpre = vBars[0];
        int vmax = 1;
        if(hBars.length==1){
            hmax=1;
        }
        else{
        while(i<hBars.length){
           // System.out.print(hBars[i]+" "+hpre);
            if(Math.abs(hBars[i]-hpre) == 1){
                hcnt++;
                hpre = hBars[i];
                 hmax = Math.max(hcnt,hmax);
                 i++;
            }
            else{
                hpre = hBars[i];
                hcnt=1;
                i++;
            }
        }
        }
        if(vBars.length==1){
            vmax=1;
        }
        else{
        while(j<vBars.length){
            //System.out.println(vBars[j]+" "+vpre);
            if(Math.abs(vBars[j]-vpre) == 1){
                vcnt++;
                vmax = Math.max(vcnt,vmax);
                vpre = vBars[j];
                j++;
            }
            else{
                vpre = vBars[j];
                vcnt= 1;
                j++;
            }
            
        }}
      // System.out.print(hmax+" "+vmax);
        int var = Math.min(hmax,vmax)+1 ;
        return var*var;
    }
}