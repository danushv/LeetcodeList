class Solution {
    public int numIslands(char[][] grid) {

        if(grid.length==0||grid==null)
        return 0;
        int nr=grid.length;
        int nc=grid[0].length; 
        int numOfIsland=0;
        for(int r=0;r<nr;r++)
        {
            for(int c=0;c<nc;c++)
            {
                if(grid[r][c]=='1')
                {
                    numOfIsland++;
                    dfs(grid,r,c);
                }
            }
        }
        return numOfIsland;
    }


    public void dfs(char [][]grid,int r,int c)
    {
        int nr=grid.length;
        int nc=grid[0].length;

        if(r<0||r>=nr||c<0||c>=nc||grid[r][c]=='0')
        return ;
        grid[r][c]='0';
        dfs(grid,r+1,c);
        dfs(grid,r-1,c);
        dfs(grid,r,c+1);
        dfs(grid,r,c-1);
    }
}
