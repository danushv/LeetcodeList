class Solution {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> stack=new Stack();
        Stack<Character> stack1=new Stack();
        for(char c:S.toCharArray())
        {
            if(!stack.isEmpty()&&c=='#')
            {
                stack.pop();
            }
            else 
            {
                stack.push(c);
            }
        }
         for(char a:T.toCharArray())
        {
            if(!stack1.isEmpty()&&a=='#')
            {
                stack1.pop();
            }
            else
            {
                stack1.push(a);
            }
        }
        if(stack.size()!=stack1.size())
        {
            return false;
        }
        if(stack.size()==1&&stack1.size()==1&&stack.peek()==stack1.peek())
        {
            return true;
        }
        while(stack1.empty()==false)
        {
            if(stack.peek()==stack1.peek())
            {
                stack.pop();
                stack1.pop();
            }
            else
            {
                return false;
                //break;
            }
        }
        return true;
    }
}//98 only passed
