class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        // question one ? how to determine which to play face up or face down????????
     // Ans  the lowest power tokens are played faceup to increase score
     //.     the hignes power tokens are played facedown to increase power 


     // Algorithm , first sort it 
     // two pointers low and high , low will point the lowest power token 
     // high will point the high power token 
     //

    // when we dont care about the current order of element , ie when. elements are independent of each other 
    // we must use greed

    // Sorting 
    Arrays.sort(tokens);
    int i=0;// two pointers one for low
    int j=tokens.length-1; //this is for the high
    int score=0;


    while(i<=j)
    {

        //when we have enough power 
    if(tokens[i]<=power)
    {
        power=power-tokens[i];
        i++;
        score++;
       
    }
     // We don't have enough power to play a token face-up
            // If there is at least one token remaining,
            // and we have enough score, play highest token face-down
   else if(i<j&& score>0)
    {
        power=power+tokens[j];
        j--;
        score--;
    }
    // when we dont have enough power , score or tokens 
    //to play faceup or face down just return 
    else
    {
        return score;
    }
    }
    
    // if every thing was possible to be done then also return it
    return score;
    }
}
