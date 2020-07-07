class Solution {
    public String reverseOnlyLetters(String S) {
        char []a= S.toCharArray();
        int i=0;
        int j= S.length()-1;
        while (i<j)
        {
            if(i<j&&Character.isLetter(a[i])==false)
                i++;
            else if(j>i&&Character.isLetter(a[j])==false)
                j--;
            else
            {
                char  temp=a[i];
                  a[i]=a[j];
                a[j]=temp;
                i++;
                j--;
                }
        }
        return  new String(a);
    }
}
-------------------------------
// the secon type of solution is using stack
class Solution {
    public String reverseOnlyLetters(String S) {
       Stack<Character> res= new Stack<Character>();
        for (char c:S.toCharArray())
        {
            if(Character.isLetter(c)==true)
                res.push(c);
        }
        StringBuilder sb= new StringBuilder ();
        for (char c:S.toCharArray())
        {
            if(Character.isLetter(c)==true)
                sb.append(res.pop());
            
            else 
                sb.append(c);
            
        }
        return sb.toString();
    }
}
