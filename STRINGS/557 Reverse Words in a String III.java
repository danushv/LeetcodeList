//We use a stack to push all words before space. As soon as we encounter a space, we empty the stack.
class Solution {
    public String reverseWords(String s) {
    // i am creating a stack
        Stack <Character> st= new Stack<Character>();
        //strings cannot be changed so we use a stringbuilder
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++)
        {
        //we push in a stack untill we get a space
            if(s.charAt(i)!=' ')
                st.push(s.charAt(i));
            else {
            // once we encounter  a space then pop and append it to the stringbuilder
                while(st.empty()==false)
                {
                   sb.append( st.pop());
                }
                // after that append a space
                sb.append(' ');
            }
        }
        // this thing is present since we dont have a space after 
    // last word. 
           while (st.empty() == false) { 
        sb.append(st.pop()); 
           }
           // sb is stringBuilder but the return type is string so we use tostring function
               return sb.toString();
    }
}
