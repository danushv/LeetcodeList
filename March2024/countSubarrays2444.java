public long countSubarrays(int[] nums, int minK, int maxK) {
        int minPostion=-1,maxPosition=-1,leftBound=-1;
        long answer=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]<minK||nums[i]>maxK)
            {
                leftBound=i;
            }
             if(nums[i]==minK)
            {
                minPostion=i;
            }
             if(nums[i]==maxK)
            {
                maxPosition=i;
            }
            answer=answer+ Math.max(0, Math.min(maxPosition,minPostion)-leftBound);
        }
        return answer;
    }
