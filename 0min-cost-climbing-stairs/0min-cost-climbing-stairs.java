class Solution {
     HashMap<Integer,Integer> memo=new HashMap<>();
    public int minCostClimbingStairs(int[] cost) {
        //bottomup approach
        // int n=cost.length;
        // int [] minimumcost=new int [n+1];

        // for(int i=2;i<minimumcost.length;i++)
        // {
        //     int takeone=minimumcost[i-1]+cost[i-1];
        //     int taketwo=minimumcost[i-2]+cost[i-2];

        //     minimumcost[i]=Math.min(takeone,taketwo);
        // }
        // return minimumcost[minimumcost.length-1];

       return mincost(cost.length,cost);


    }
    private int mincost(int i,int []cost)
    {
        if(i<=1)
        return 0;

        if(memo.containsKey(i))
        return memo.get(i);
        int one=cost[i-1]+mincost(i-1,cost);
        int two=cost[i-2]+mincost(i-2,cost);
        memo.put(i,Math.min(one,two));
        return memo.get(i);

    }
    
}