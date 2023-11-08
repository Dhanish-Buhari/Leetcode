class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        if(Math.abs(fy-sy)==0 && Math.abs(fx-sx)==0)return t!=1;
        return (Math.abs(fy-sy)<=t && Math.abs(fx-sx)<=t);
    }
}