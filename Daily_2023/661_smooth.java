class Solution {
    public int[][] imageSmoother(int[][] img) {
        int [][] result=new int[img.length][img[0].length];


        for(int i=0;i<img.length;i++)
        {
            for(int j=0;j<img[0].length;j++)
            {
                result[i][j]=smooth(img,i,j);
            }
        }
        return result;
    }

    public static int smooth(int [][]img,int i,int j)
    {
        int m=img.length;
        int n=img[0].length;
        int totalsum=0;
        int count=0;

        for(int x=Math.max(0,i-1); x<=Math.min(m-1,i+1);x++)
        {
            for(int y=Math.max(0,j-1);y<=Math.min(n-1,j+1);y++)
            {
               // int nx=x+i;
               // int ny=y+j;
              //  if(nx<0||nx>=m||ny<0||ny>=n)
                
                   // continue;
                
                    count=count+1;
                    totalsum+=img[x][y];
            }
        }
            return totalsum/count;
    }
}
