class Solution {
    List<List<Integer>> result=new ArrayList();
    int n;
    public List<List<Integer>> subsets(int[] nums) {
        // this is all about finding the power set to be honest 
        // we must loop over length of the combination

         n=nums.length;
        
        backtrack(0,new ArrayList<Integer>(),nums);
        return result;

    }
  public void  backtrack(int first,ArrayList<Integer>curr,int []nums)
  {
      result.add(new ArrayList(curr));
    //   if(first==nums.length)
    //   return;
      for(int i=first;i<nums.length;i++)
      {
          curr.add(nums[i]);
          backtrack(i+1,curr,nums);
          curr.removeLast();
      }
  }
}
