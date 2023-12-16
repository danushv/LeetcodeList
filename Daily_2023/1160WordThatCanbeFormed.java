class Solution {
    public int countCharacters(String[] words, String chars) {
        HashMap <Character ,Integer> charsFreq=new HashMap<>();
         int result=0;
        for(int i=0;i<chars.length();i++)
        {  
            if(charsFreq.containsKey(chars.charAt(i)))
            {
                charsFreq.put(chars.charAt(i),charsFreq.get(chars.charAt(i))+1);
            }
            
             else
            charsFreq.put(chars.charAt(i),1);
        }

        for(int i=0;i<words.length;i++)
        {
            HashMap<Character,Integer> w=new HashMap<>();
            for(int a=0;a<words[i].length();a++)
            {
                if(w.containsKey(words[i].charAt(a)))
                {
                    w.put(words[i].charAt(a),w.get(words[i].charAt(a))+1);
                }
                else
                {
                    w.put(words[i].charAt(a),1);
                }
            }
                boolean validword=true;
                for(char currchar:w.keySet())
                {
                    if(!charsFreq.containsKey(currchar)||w.get(currchar)>charsFreq.get(currchar))
                    {
                        validword=false;
                        break;
                    }
                }
                  if(validword)
                    result=result+words[i].length();  
            }
            
        
        return result;
    }
}
