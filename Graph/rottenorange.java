class Solution {

    private int [][] direction={{-1,0},{0,-1},{1,0},{0,1}};
    public int orangesRotting(int[][] grid) {
        int tot=0;
        int n=grid[0].length;
        int m=grid.length;
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==2)
                //2d to 1d if you cant understand https://www.youtube.com/watch?v=tMSdjPKFRD4
                q.add(i*n+j);
                else if(grid[i][j]==1)
                tot++;
            }

        }
        int minutes=0;
        while(!q.isEmpty()&&tot>0)
        {
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                int num=q.poll();
                //1d to 2d 
               int row=num/n;
               int col=num%n;
                for(int [] d:direction)
                {
                    int x=d[0]+row;
                    int y=d[1]+col;
                    //now we are checking if x and y are valid coordinate 

                    if(x>-1&&y>-1&&x<m&&y<n &&grid[x][y]==1)
                    {
                        q.add(x*n+y);
                        tot--;
                        grid[x][y]=2;
                    }
                }
                
            }
            minutes++;
        }
        return tot==0?minutes:-1;
    }
}
