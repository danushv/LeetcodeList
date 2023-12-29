518. Coin Change II

You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.

You may assume that you have an infinite number of each kind of coin.

The answer is guaranteed to fit into a signed 32-bit integer.


class Solution {
    public int change(int amount, int[] coins) {
        int []dp=new int [amount+1];
        dp[0]=1;

        for(int i=0;i<coins.length;i++)
        {
            for(int j=coins[i];j<dp.length;j++)
            {
                dp[j]+=dp[j-coins[i]];
            }
        }
       int result=dp[amount];
       return result;
    }
}
