class Solution {
    public boolean isPathCrossing(String path) {
        Set<String> map=new HashSet<String>();

        map.add("0,0");

        int x=0;
        int y=0;
        for(int i=0;i<path.length();i++)
        {
         if(path.charAt(i)=='N')
         {
             y++;
         }
         else if(path.charAt(i)=='E')
         {
            x++;
         }
         else if(path.charAt(i)=='W')
         {
            x--;
         }
         else if(path.charAt(i)=='S')
         {
             y--;
         }
         if(map.contains(x+","+y))return true;
         else
         map.add(x+","+y);
        }x

        return false;
    }
}
