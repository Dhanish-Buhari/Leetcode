class Pair{
    String word;
    int steps;
    Pair(String word, int steps){
        this.word=word;
        this.steps=steps;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        Set<String> st = new HashSet<>();
        for(int i=0; i<wordList.size(); i++){
            st.add(wordList.get(i));
        }
        q.add(new Pair(beginWord,1));
        while(!q.isEmpty()){
            String word = q.peek().word;
            int steps = q.peek().steps;
            q.poll();
            if(word.equals(endWord))return steps;
            for(int i=0; i<word.length(); i++){
                for(char ch='a'; ch<='z'; ch++){
                    char charArr[] = word.toCharArray();
                    charArr[i]=ch;
                    String chk = new String(charArr);
                    if(st.contains(chk)){
                        st.remove(chk);
                        q.add(new Pair(chk,steps+1));
                    }
                }
            }
        }
        return 0;
    }
}