class Solution {
    public long largestPerimeter(int[] nums) {
        
        Arrays.sort(nums);
        long sum=nums[0]+nums[1];
        long perimeter=0;
        
        for(int i=2;i<nums.length;i++)
        {
            if(sum>nums[i])
            {
                perimeter=sum+nums[i];     
            }
            sum=sum+nums[i];
        }
        return perimeter==0?-1:perimeter;
    }
}
