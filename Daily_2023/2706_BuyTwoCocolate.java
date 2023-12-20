class Solution {
    public int buyChoco(int[] prices, int money) {
       
       int firstMin=Integer.MAX_VALUE;
       int secondMin=Integer.MAX_VALUE;

           Arrays.sort(prices);
           firstMin=prices[0];
           secondMin=prices[1];
        
        int rem=money-(firstMin+secondMin);

        if(rem>=0)
        return rem;
        else
        return money;

     


    }
}
