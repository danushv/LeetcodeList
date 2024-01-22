class Solution {
    public int[] sortArray(int[] nums) {
        int n=nums.length;
         helper(nums,0,n-1);
         return nums;
    }

    public static void helper(int []nums,int left,int right)
    {
        if(left>=right)
        return;

        int pivot=partition(nums,left,right);
        helper(nums,left,pivot-1);
        helper(nums,pivot+1,right);
    }
    public static int partition(int []nums,int left,int right)
    {
        int pivot=nums[right];// lets choose the last element as pivot element;
        int i=left-1;
        for(int j=left;j<right;j++)
        {
            if(nums[j]<pivot)
            {
                i++;
                swap(nums,i,j);
            }
        }
        swap(nums,i+1,right);   // i am swaping the last position toooooo.
        return i+1;   // i am returning the pivot element;
    }

    public static void swap(int [] nums, int i,int j)
    {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }


}
