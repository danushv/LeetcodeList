class Solution {
    public int maximalSquare(char[][] matrix) {
        int n=matrix.length;

        int m=matrix[0].length;
        
        int [][]dp=new int[n+1][m+1];
        int result=0;

        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=m;j++){
                if(matrix[i-1][j-1]=='1')
                {
                    dp[i][j]=Math.min(Math.min(dp[i][j-1],dp[i-1][j]),dp[i-1][j-1])+1;
                    result=Math.max(result,dp[i][j]);
                }
            }
        }
            return result*result;

    }
}
