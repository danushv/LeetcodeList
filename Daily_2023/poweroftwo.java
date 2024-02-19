class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n<=0)
        return false;
        int count=Integer.bitCount(n);
        return count==1;
    }
}
