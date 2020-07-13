//Reverse bits of a given 32 bits unsigned integer.
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        List<Integer> l= new ArrayList<>();// creating a array
        int times=32; // because it is given only 32 bit;
        int result=0;
        while(times>0)// loop runs for 32 time
        {
            int t=n&1; //t will have the last integer 
            l.add(t); // add it to the list
            n=n>>1;   // right shift it;
            times--;
        }
        for(int i=0;i<l.size();i++)
        {
            result<<=1; // for left shift it crearte a space and then or 
            result=result|l.get(i); // it is a basic very basic bit manipulation
        }
        return result; // now return the result
    }
}
