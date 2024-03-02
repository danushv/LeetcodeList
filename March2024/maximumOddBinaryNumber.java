class Solution {
    public String maximumOddBinaryNumber(String s) {
        // you can do it easily dont worry 
        // this is greedy bit manipulation 
        int n=s.length();
        int no_one=0;

        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='1')
            no_one++;
        }
        StringBuilder sb=new StringBuilder();

        for(int i=0;i<no_one-1;i++)
        {
            sb.append('1');
        }
        for(int i=0;i<n-no_one;i++)
        {
            sb.append('0');
        }

        sb.append('1');
        return sb.toString();
    }
}
