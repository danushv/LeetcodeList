class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> result=new HashMap<>();
        Stack <Integer> stack=new Stack<>();
       for (Integer c:nums2)
       {
           while(!stack.isEmpty()&&stack.peek()<c)
           {
               result.put(stack.pop(),c);
           }
           stack.push(c);
       }
        for(int i=0;i<nums1.length;i++)
        {
            nums1[i]=result.getOrDefault(nums1[i],-1);
        }
        return nums1;
    }
}
