class Solution {
    private static int ans=-1;
    public static int longestPath(int[][] mat,int n,int m,int xs,int ys,int xd,int yd) {
        // code here
        
         ans=-1;
         if(mat[xs][ys]==0||mat[xd][yd]==0)
         return -1;
        boolean [][]vis=new boolean[n][m];
        helper(mat,xs,ys,xd,yd,0,vis);
        return ans;
    }
    
    public static void helper(int [][]mat,int x,int y,int xd,int yd,int pathlen,boolean [][]vis)
    {
        if(x==xd&&y==yd)
        {
            ans =Math.max(pathlen,ans);
            return;
        }
        vis[x][y]=true; // marking that it is visited
        int []row={0,-1,0,1};
        int []col={1,0,-1,0};
        
        for(int i=0;i<4;i++)
        {
            int nrow=x+row[i];
            int ncol=y+col[i];
        
        // if it is 2, it is already accessed
        if(nrow>=0&&nrow<mat.length&&ncol>=0&&ncol<mat[0].length&&mat[nrow][ncol]==1&&vis[nrow][ncol]==false)
        {
            helper(mat,nrow,ncol,xd,yd,pathlen+1,vis);
        }
       
        }
         vis[x][y]=false;
        
        // we should unvisit
        
        
        }
    }
