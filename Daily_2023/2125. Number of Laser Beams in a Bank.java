class Solution {
    public int numberOfBeams(String[] bank) {
        int result=0;
        int n=bank.length;
        int []second=new int [n];

        for(int i=0;i<bank.length;i++)
        {
            second[i]=count1(bank[i]);
        }

        int apointer=0;
        int bpointer=1;
        
        while(bpointer<second.length)
        {
            if(second[bpointer]==0)
            {
            
            bpointer++;
            }
            else
            {
                int a =0;
                a=second[apointer]*second[bpointer];
                result=result+a;
                apointer=bpointer;
                bpointer++;
            }
        }

        return result;

    }

    public static int count1(String a)
    {
        int count=0;
        for(int i=0;i<a.length();i++)
        {
            if(a.charAt(i)=='1')
            count++;
        }
        return count;
    }
}
