class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack <Character> stk1 = new Stack<Character>();
        for(int i=0; i<s.length(); i++){
            if(stk1.size()>0 && s.charAt(i)=='#'){
                stk1.pop();
                continue;
            }
                else if(s.charAt(i)=='#'){
                continue;
            }
            stk1.add(s.charAt(i));
        }
        Stack <Character> stk2 = new Stack<>();
        for(int i=0; i<t.length(); i++){
            if(stk2.size()>0 && t.charAt(i)=='#'){
                stk2.pop();
                continue;
            }
            else if(t.charAt(i)=='#'){
                continue;
            }
            stk2.add(t.charAt(i));
        }
        //System.out.print(stk1+" "+stk2);
        while(!stk1.isEmpty() && !stk2.isEmpty()){
            if(stk1.pop()!=stk2.pop()){
                return false;
            }
        }
        if(stk1.size()!=stk2.size()){
            return false;

        }
        return true;
    }
}