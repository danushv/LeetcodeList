class Solution {
    public int calPoints(String[] ops) {
    Stack<Integer> stack=new Stack();
        for (String c:ops)
        {
            if(c.equals("+"))
            {
                int top=stack.pop();
                int newtop=top+stack.peek();
                stack.push(top);
                stack.push(newtop);
                
            }
            else if(c.equals("C"))
            {
                stack.pop();
            }
            else if(c.equals("D"))
            {
                stack.push(2*stack.peek());
            }
            else
            {
                stack.push(Integer.valueOf(c));
            }
        }
        int ans=0;
        for(int score:stack)
        {
            ans=ans+score;
        }
        return ans;
    }
}
