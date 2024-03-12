class Solution {
    private Boolean memo[][];
    public boolean canPartition(int[] nums) {
        
        int tot=0;
        for(int i=0;i<nums.length;i++)
        {
            tot=tot+nums[i];
        }
        if(tot%2!=0)
        return false;
        memo=new Boolean[tot/2+1][nums.length];
        return helper(nums,tot/2,0);
    }

    public boolean helper(int []nums,int sum,int index)
    {
        if(sum==0)
        return true;
        if(sum<0||index>=nums.length)
        return false;
        if(memo[sum][index]!=null)
        return memo[sum][index];
        if(sum>=nums[index])
        {
            if(helper(nums,sum-nums[index],index+1))
            {
            memo[sum][index]=true;
            return true;
            }
        }

       memo[sum][index]= helper(nums,sum,index+1);
        return memo[sum][index];      

    }
}
