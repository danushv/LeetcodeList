/*Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start 
of the string. If there are less than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, 
then reverse the first k characters and left the other as original.

Example:

Input: s = "abcdefg", k = 2
Output: "bacdfeg"*/
class Solution {
    public String reverseStr(String s, int k) {
        char []a= s.toCharArray();
        for (int b=0;b<a.length;b+=2*k)
        {
            int i=b;
        int j= Math.min(b+k-1,a.length-1);
        while(i<j)
        {
            char temp=a[i];
            a[i]=a[j];
            a[j]=temp;
            i++;
            j--;
            
        }
        }
        return new String(a); 
    }
}
