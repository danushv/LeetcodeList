class Solution {
    public boolean isValid(String s) {
        if(s.length()%2!=0)
            return false;
        Stack<Character> stack=new Stack();
        for(char c:s.toCharArray())
        {
if(c=='('||c=='{'||c=='[')
    stack.push(c);
            if(c==')'&& !stack.isEmpty() &&stack.peek()=='(')
            {
                stack.pop();
            }
            if(c==']'&& !stack.isEmpty() &&stack.peek()=='[')
            {
                stack.pop();
            }
            if(c=='}'&& !stack.isEmpty() &&stack.peek()=='{')
            {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
