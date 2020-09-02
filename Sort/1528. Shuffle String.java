class Solution {
    public String restoreString(String s, int[] indices) {
        StringBuilder sb= new StringBuilder(s);
        int size=s.length();
        for (int i=0;i<size;i++)
        {
            sb.setCharAt(indices[i],s.charAt(i));
        }
        return sb.toString();
    }
}
