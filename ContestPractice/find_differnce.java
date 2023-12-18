class Solution {
    public char findTheDifference(String s, String t) {
        HashMap<Character,Integer> map1=new HashMap<>();
        char c=' ';
for(int i=0;i<s.length();i++)
{

if(map1.containsKey(s.charAt(i)))
{
map1.put(s.charAt(i),map1.get(s.charAt(i))+1);
}
else
map1.put(s.charAt(i),1);
}
for(int j=0;j<t.length();j++)
{
if(!map1.containsKey(t.charAt(j))||map1.get(t.charAt(j))==0)
{ 
   c= t.charAt(j);
break;
}
    else
    {
        map1.put(t.charAt(j),map1.get(t.charAt(j))-1);
    }
}

return c;
    }
}
