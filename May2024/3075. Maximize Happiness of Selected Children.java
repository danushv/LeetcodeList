class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        
        int haps=happiness.length;

        Integer[]hapArray=new Integer[haps];

        for(int i=0;i<haps;i++)
        {
            hapArray[i]=happiness[i];
        }
        Arrays.sort(hapArray,Collections.reverseOrder());

        long result=0;
        int turns=0;

        for(int i=0;i<k;i++)
        {
            result=result+Math.max(hapArray[i]-turns,0);
            turns++;
        }

        return result;
    }
}
