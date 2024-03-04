class Solution {
    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> curr=new ArrayList<>();
        Arrays.sort(candidates);
        dfshelper(0,target,candidates,result,curr);
        return result;
    }
    public void dfshelper(int start,int target,int []candidates,List<List<Integer>> result,List<Integer> curr)
    {
        if(target==0)
        {
            result.add(new ArrayList<>(curr));
            return ;
        }
        if(target<0)
        {
            return;
        }
        for(int i=start;i<candidates.length;i++)
        {
            if(i>start&&candidates[i]==candidates[i-1])
            {
                continue;
            }
           // if(!curr.contains(candidates[i]))
           // {
            curr.add(candidates[i]);
            dfshelper(i+1,target-candidates[i],candidates,result,curr);
            curr.remove(curr.size()-1);
           // }
            
        }

    }
}
