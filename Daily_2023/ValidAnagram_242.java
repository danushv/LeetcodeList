class Solution {
    public boolean isAnagram(String s, String t) {
        
        HashMap<Character,Integer> map1= new HashMap<>();
       // HashMap<String> map2=new HashMap<>();

       if(s.length()!=t.length())
       {
           return false;
       }

        for(int i=0;i<s.length();i++)
        { 
            if(map1.containsKey(s.charAt(i)))  
            map1.put(s.charAt(i),map1.get(s.charAt(i))+1);
            else
            map1.put(s.charAt(i),1);
        }
         for(int i=0;i<t.length();i++)
        {
            //map1.put(s.charAt(i));
            if(!map1.containsKey(t.charAt(i)))
            return false;
            else
            {
                map1.put(t.charAt(i),map1.get(t.charAt(i))-1);
                if(map1.get(t.charAt(i))==0)
                map1.remove(t.charAt(i));
            }
        }

        return true;
    }
}
