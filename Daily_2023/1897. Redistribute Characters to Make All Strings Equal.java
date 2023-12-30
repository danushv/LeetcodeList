class Solution {
    public boolean makeEqual(String[] words) {
        HashMap<Character,Integer> mp=new HashMap<>();
        String finalstr="";

        for(int i=0;i<words.length;i++)
        {
            finalstr=finalstr+words[i];
        }

        for(int i=0;i<finalstr.length();i++)
        {
            mp.put(finalstr.charAt(i),mp.getOrDefault(finalstr.charAt(i),0)+1);
        }
        Iterator<Map.Entry<Character,Integer>> it=mp.entrySet().iterator();

        while(it.hasNext())
        {
                Map.Entry<Character,Integer> entry=it.next();
                if(entry.getValue()%words.length!=0)
                return false;
        }

        return true;

    }
}
