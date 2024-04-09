class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int result=0;
        int n=tickets.length;
        while(tickets[k]>0)
        {
            for(int i=0;i<n;i++)
            {
                tickets[i]=tickets[i]-1;
                if(tickets[k]==0)
                break;
                if(tickets[i]>=0)
                result++;
                
            }
           
        }
         return result+1;
    }
}
