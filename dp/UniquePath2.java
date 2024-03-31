class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n=obstacleGrid.length;
        int m=obstacleGrid[0].length;
        int [][]dp=new int [n][m];

        for(int i=0;i<n;i++)
        {        
            for(int j=0;j<m;j++)
        {
                dp[i][j]=-1;
        }
        }
        return helper(n-1,m-1,dp,obstacleGrid);

        
    }
    public int helper(int row,int col,int[][]dp,int[][]org)
    {
        if(row<0||col<0||org[row][col]==1)
        return 0;
        if(row==0&&col==0)
        return 1;

        if(dp[row][col]!=-1)
        return dp[row][col];
       int up=helper(row-1,col,dp,org);
        int lef=helper(row,col-1,dp,org);
         dp[row][col]=up+lef;
         return dp[row][col];

    }
}
