class Solution {
    public int firstMissingPositive(int[] nums) {
        int n=nums.length;
        int i=0;
        while(i<n)
        {
            int c=nums[i]-1;
            if(nums[i]>0&&nums[i]<=n&&nums[i]!=nums[c])
            {
                int temp=nums[i];
                nums[i]=nums[c];
                nums[c]=temp;
            }
            else
            {
                i++;
            }
        }
        for(int a=0;a<n;a++)
        {
            if(nums[a]!=a+1)
            return a+1;

        }
            return n+1;
    }
}
