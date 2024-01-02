class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        

        List<List<Integer> >result=new ArrayList<>();

        Map <Integer,Integer> mp=new HashMap<>();

        for(int i=0;i<nums.length;i++)
        {
            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
        }

        while(!mp.isEmpty())
        {
            List<Integer> row=new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry:mp.entrySet())
        {
            int num=entry.getKey();
            int count=entry.getValue();
            // if(count==0)
            // mp.remove(num);
            if(!row.contains(num)&&count>0)
            {
                row.add(num);
                mp.put(num,count-1);
            }
         


        }
        result.add(row);
        mp.values().removeIf(count->count==0);
        }

        return result;
    }
}
