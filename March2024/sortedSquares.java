class Solution {
    public int[] sortedSquares(int[] nums) {

        // this you would do in o(nlogn)
        // for(int i=0;i<nums.length;i++)
        // {
        //     nums[i]=nums[i]*nums[i];
        // }
        // Arrays.sort(nums);
        // return nums;


        // how can you do in o(n)???
        int n=nums.length;
        int a=0;// negative
        int j=n-1;//postivie
        int []result = new int [n];
        for(int i=n-1;i>=0;i--)
        {
            int square=0;
            if(Math.abs(nums[j])>Math.abs(nums[a]))
            {
                square =nums[j];
                j--;
               
            }
            else
            {
                square=nums[a];
                a++;
            }
            result[i]=square*square;

        }
        return result;
    }
}
