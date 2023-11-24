import java.util.*;
class Solution {
    public int maxCoins(int[] piles) {
        int sum = 0;
        Arrays.sort(piles);
        int n = piles.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = piles[i];
            piles[i] = piles[n - i - 1];
            piles[n - i - 1] = temp;
        }
        int i=1;
        int cnt = 0;
        for(i=1; i<piles.length; i+=2){
            if(cnt==n/3){
                break;
            }
            sum+=piles[i];
            cnt++;
        }
        return sum;
    }
}