class Solution {
    public int tribonacci(int n) {
        int memo[]=new int [38];
        memo[0]=0;
        memo[1]=1;
        memo[2]=1;
        return helper(n,memo);
    }
    public int helper(int n,int[]memo)
    {
        if(n<0)
        return 0;
        if(n==0||n==1||n==2)
        return memo[n];
        
        if(memo[n]>0)
        return memo[n];

        memo[n]=helper(n-1,memo)+helper(n-2,memo)+helper(n-3,memo);

        return memo[n];
    }
}