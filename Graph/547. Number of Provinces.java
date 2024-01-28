class Solution {
    public static void dfs(int start,int[][]isConnected,boolean[] vis)
    {
        vis[start]=true;

        for(int i=0;i<isConnected.length;i++)
        {
            if(isConnected[start][i]==1&&!vis[i])
            {
                dfs(i,isConnected,vis);
            }
        }
    }


    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;

        int result=0;
        boolean[]vis=new boolean[n];
        for(int i=0;i<n;i++)
        {
        if(!vis[i])
        {
            result++;
            dfs(i,isConnected,vis);
            
        }
        }
        return result;

    }
}
