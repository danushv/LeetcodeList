class Solution {
    List<List<Integer>> result=new ArrayList<>();
   // int n;
    public List<List<Integer>> combine(int n, int k) {

        List<Integer> curr=new ArrayList<>();
        dfshelper(1,curr,result,n,k);
        return result;


    }

    public void dfshelper(int start,List<Integer>curr,List<List<Integer>> result,int n,int k)
    {
        if(curr.size()==k)
        {
            result.add(new ArrayList<>(curr));
            return;
        }
        for(int i=start;i<=n;i++)
        {
            //if(!curr.contains(i) )
            //{
            curr.add(i);
            dfshelper(i+1,curr,result,n,k);
            curr.remove(curr.size()-1);
           // }
        }
    }
}
