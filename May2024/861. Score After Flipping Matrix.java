class Solution {
    public int matrixScore(int[][] grid) {
      int m=grid.length;
      int n=grid[0].length;
      int score=0;

        //iterate throught he first column of the matrix and if(element is 0 flip the enitre row)
        for(int i=0;i<m;i++)
        {
             if(grid[i][0]==0)
             {
                for(int j=0;j<n;j++)
                {
                    grid[i][j]=grid[i][j]==0?1:0;
                }
             }

        }

        // Iterate from Second column to the last column of the matrix for each column
        // 1.Count the number of zeros and store in the countZero 
        // 2. if number of 0 is greater flip the entire column 
        for(int j=1;j<n;j++)
        {
            int countZero=0;
            for(int i=0;i<m;i++)
            {
                if(grid[i][j]==0)
                    countZero++;
            }
            if(countZero>m/2)
            {
                for(int i=0;i<m;i++)
                {
                    // if(grid[i][j]==0)
                    // {
                    //     grid[i][j]=1;
                    // }
                    // else
                    // {
                    //     grid[i][j]=0;
                    // }all this code can be written in sigle line

                    grid[i][j]=grid[i][j]==0?1:0;
                }
            }
        }


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Left shift bit by place value of column to find column contribution
                int columnScore = grid[i][j] << (n - j - 1);
                // Add contribution to score
                score += columnScore;
            }
        }
        return score;
    }   
}
