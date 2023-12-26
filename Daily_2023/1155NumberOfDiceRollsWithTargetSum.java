class Solution {
    public static Integer [][]dp=new Integer[2][2];
    public int numRollsToTarget(int n, int k, int target) {
        dp=new Integer[n+1][target+1];
       return helper(n,k,target);
    }

    // public static int helper(int n,int k,int target){
    //     if(n==0||target<=0)
    //     {
    //     if(n==0&&target==0)
    //     {
    //     return 1;
    //     }
    //     return 0;
    //     }
        

    //   int res=0;
    //   for(int i=1;i<=k;i++)
    //   {
    //       res=res+helper(n-1,k,target-i);
    //   }

    //   return res;
    
     public static int helper(int n,int k,int target){
         
        
        if(n==0||target<=0)
        {
        if(n==0&&target==0)
        {
        return 1;
        }
        return 0;
        }
        if(dp[n][target]!=null)
        return dp[n][target];
        

      int res=0;
      for(int i=1;i<=k;i++)
      {
          res=(res+helper(n-1,k,target-i))%(int)(1e9+7);
          dp[n][target]=res;
      }

      return res;
    }
}1
