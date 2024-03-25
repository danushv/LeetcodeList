class Solution {
    int result=0;
    public int fib(int n) {
        if(n==0)return 0;
        int []memo=new int [n+1];

        memo[0]=0;
        memo[1]=1;
        return helper(n,memo);


    }
    public int helper(int n,int []memo)
    {
        if(n==0)
        return 0;
        if(n==1)
        return 1;
        if(memo[n]>0)
        return memo[n];
    memo[n]=helper(n-1,memo)+helper(n-2,memo);

    return memo[n];
    }
}
