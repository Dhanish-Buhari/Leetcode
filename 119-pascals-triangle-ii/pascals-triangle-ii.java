class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ll = new ArrayList<>();
        long ncr=1;
        for(int i=0; i<=rowIndex; i++){
            ll.add((int)(ncr));
            ncr = ((rowIndex-i)*ncr)/(i+1);
            System.out.println(ncr);
        }
        return ll;
    }
}