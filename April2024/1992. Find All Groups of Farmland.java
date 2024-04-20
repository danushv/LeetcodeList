class Solution {
    public int[][] findFarmland(int[][] land) {
        List<int[]> output=new ArrayList<>();
        int nr=land.length;
        int nc=land[0].length;
        for(int r=0;r<nr;r++)
        {
            for(int c=0;c<nc;c++)
            {
                if(land[r][c]==1)
                {
                int []arr={r,c,r,c};
                dfshelper(r,c,arr,land);
                output.add(arr);
                }
            }
        }
        int [][]result=new int[output.size()][4];
        for(int i=0;i<output.size();i++)
        {
            result[i]=output.get(i);
        }
        return result;
    }
    public void dfshelper(int r,int c,int []arr,int [][]land)
    {
        int nr=land.length;
        int nc=land[0].length;
        if(r<0||c<0||r>nr-1||c>nc-1||land[r][c]==0)
        return;
        land[r][c]=0;

        if(r<arr[0])
        {
            arr[0]=r;
        }
        if(c<arr[1])
        {
            arr[1]=c;
        }
        if(r>arr[2])
        {
            arr[2]=r;
        }
        if(c>arr[3])
        {
            arr[3]=c;
        }
        dfshelper(r+1,c,arr,land);
        dfshelper(r,c+1,arr,land);
        dfshelper(r-1,c,arr,land);
        dfshelper(r,c+1,arr,land);
    }
}
