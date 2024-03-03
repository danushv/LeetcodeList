class Solution {
    //what is my idea??
    // if and only if the size ==n i will add the subarray into the curr arraylist 

    int n;
    List<List<Integer>> result=new ArrayList();
    public List<List<Integer>> permute(int[] nums) {
        
        List<Integer> curr=new ArrayList<>();
        dfshelper(0,curr,nums);
        return result;
    }

    public void dfshelper(int start,List<Integer>curr,int []nums)
    {
        if(start==nums.length)
        {
            result.add(new ArrayList<>(curr));
            return;
        }

        for(int i=start;i<nums.length;i++)
        {
            curr.add(nums[i]);
            swap(nums,start,i);
            dfshelper(start+1,curr,nums);
            swap(nums,start,i);
            curr.remove(curr.size()-1);
        }
    }
    public void swap(int []nums,int i,int j)
    {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
