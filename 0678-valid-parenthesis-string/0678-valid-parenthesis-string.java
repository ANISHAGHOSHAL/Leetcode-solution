class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer>  bracketsStack = new Stack<>();
        Stack<Integer> asteriskStack = new Stack<>();
        char [] sArr = s.toCharArray(); 
        for(int i=0;i<sArr.length;i++){
            char ch = sArr[i];

            if(ch == '(')
                bracketsStack.push(i);
            else if(ch=='*') 
                asteriskStack.push(i);
            else if(!bracketsStack.isEmpty())
                bracketsStack.pop();
            else if(!asteriskStack.isEmpty())
                asteriskStack.pop();
            else
                return false;
        }

        while(!bracketsStack.isEmpty() && !asteriskStack.isEmpty() && bracketsStack.peek()<asteriskStack.peek()){
            bracketsStack.pop();
            asteriskStack.pop();
        }

        return bracketsStack.isEmpty();
    }
}