class Solution {
    int n;
    List<List<Integer>>result=new ArrayList();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        List<Integer> curr=new ArrayList();
        Arrays.sort(nums);
        dfshelper(0,nums,curr);

        return result;
    }
    public void dfshelper(int first,int[]nums,List<Integer> curr)
    {
        result.add(new ArrayList<>(curr));

        for(int i=first;i<nums.length;i++)
        {
            if(i!=first&&nums[i]==nums[i-1])
            continue;
            curr.add(nums[i]);
            dfshelper(i+1,nums,curr);
            // if(nums[i]==nums[i+1])
            // curr.remove(curr.size()-2);
            // else
            curr.remove(curr.size()-1);
        }
    }
}
