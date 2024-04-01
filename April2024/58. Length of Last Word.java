class Solution {
    public int lengthOfLastWord(String s) {
        String s2=s.trim();
        int result=0;

        for(int i=s2.length()-1;i>=0;i--)
        {

            if(s2.charAt(i)!=' ')
            result++;
            else
            break;
        }
        return result;
    }
}
