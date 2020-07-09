class Solution {
    public List<String> stringMatching(String[] words) {
        HashSet<String> results = new HashSet<String>();
        for (int i=0;i<words.length;i++)
        {
            for(int j=i+1;j<words.length;j++)
            {
                if(words[j].contains(words[i]))
                {
                    results.add(words[i]);
                }
                if(words[i].contains(words[j]))
                {
                    results.add(words[j]);
                }
            }
        }
        return new ArrayList<String> (results);
    }
}
