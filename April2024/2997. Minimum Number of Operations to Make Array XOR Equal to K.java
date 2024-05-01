class Solution {
    public int minOperations(int[] nums, int k) {
        int finalXor=0;
        for(int n:nums)
        {
            finalXor=finalXor^n;
        }
        int count=0;

        while(k>0||finalXor>0)
        // k % 2 returns the rightmost bit in k,
            // finalXor % 2 returns the rightmost bit in finalXor.
            // Increment counter, if the bits don't match.
            {
                if((k%2)!=(finalXor%2))
                {
                    count++;
                }
                k=k/2;
                finalXor=finalXor/2;
            }
            return count;
    }
}
