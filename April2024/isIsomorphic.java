class Solution {
    public boolean isIsomorphic(String s, String t) {

        return transform(s).equals(transform(t));

    }
    public String  transform(String sa)
    {
        Map<Character,Integer> indexmapping=new HashMap<>();
        StringBuilder sb=new StringBuilder();

        for(int i=0;i<sa.length();i++)
        {
            char c=sa.charAt(i);

            if(!indexmapping.containsKey(c))
            {
                indexmapping.put(c,i);
                
            }
            else
            {
                indexmapping.put(c,indexmapping.get(c));
            }

            sb.append(Integer.toString(indexmapping.get(c)));
            sb.append(" ");
            
        }
        return sb.toString();
    }

}
