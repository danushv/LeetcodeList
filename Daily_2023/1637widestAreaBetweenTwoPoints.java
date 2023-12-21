//https://leetcode.com/problems/widest-vertical-area-between-two-points-containing-no-points/?envType=daily-question&envId=2023-12-21

class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        int []arr=new int[points.length];

        for(int i=0;i<points.length;i++)
        {
        arr[i]=points[i][0];
        System.out.print(points[i][1]);
        }
        

        Arrays.sort(arr);
        int max=0;

        for(int i=0;i<arr.length-1;i++)
        {
            max=Math.max(Math.abs( arr[i+1]-arr[i]),max);
        }
        return max;
    
    }
}
