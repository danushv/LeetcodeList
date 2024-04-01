class Solution {
    public int minFallingPathSum(int[][] matrix) {
        
        int result=Integer.MAX_VALUE;
        Integer memo[][]=new Integer[matrix.length][matrix[0].length];
        for(int startcol=0;startcol<matrix.length;startcol++)
        {
            result=Math.min(result,helper(matrix,0,startcol,memo));
        }
        return result;
    }

    public int helper(int [][]matrix,int row,int col,Integer [][]memo)
    {
        if(col<0||col==matrix.length)
        return Integer.MAX_VALUE;
        if(row==matrix.length-1)
        return matrix[row][col];
        if(memo[row][col]!=null)
        return memo[row][col];

      int  left=helper(matrix,row+1,col,memo);
      int  middle=helper(matrix,row+1,col+1,memo);
      int right=helper(matrix,row+1,col-1,memo);
      memo[row][col]= Math.min(left,Math.min(middle,right))+matrix[row][col];
      return memo[row][col];
    }
}
