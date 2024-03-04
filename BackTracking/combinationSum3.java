class Solution {
    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {

        List<Integer> curr=new ArrayList<>();

        dfshelper(1,curr,k,n,result);
        return result;

        
    }
    public void dfshelper(int start,List<Integer>curr,int k,int n, List<List<Integer>>result)
    {
        if(curr.size()==k&&n==0)
        {
            result.add(new ArrayList<>(curr));
            return;
        }
        else if(n<0||curr.size()==k)
        return;
        for(int i=start;i<=9;i++)
         {
             if(n-i<0)
             break;

            curr.add(i);
            dfshelper(i+1,curr,k,n-i,result);
            curr.remove(curr.size()-1);
        }
    }
}
