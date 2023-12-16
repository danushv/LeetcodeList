class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        
        String word1result="";
        String word2result="";

        for (int i=0;i<word1.length;i++)
        {
            word1result=word1result+word1[i];
        }
        for (int i=0;i<word2.length;i++)
        {
            word2result=word2result+word2[i];
        }

        return word1result.equals(word2result);
    }
}
