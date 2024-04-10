class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
      int n= deck.length;
      int []result=new int[n];
      boolean skip=false;
      int indD=0;
      int indR=0;
      Arrays.sort(deck);

      while(indD<n)
      {
        if(result[indR]==0)
        {
            if(!skip)
            {
                result[indR]=deck[indD];
                indD++;
            }
            skip=!skip;
        }
        indR=(indR+1)%n;
      }  
      return result;
    }
}
