1122. Relative Sort Array
Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.

Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2. Elements that do not appear in arr2 should be placed at the end of arr1 in ascending order


class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        List<Integer> result = new ArrayList<>();
        int maxElement = Arrays.stream(arr1).max().orElse(0);

        int[] count = new int[maxElement + 1];
        for (int element : arr1) {
            count[element]++;
        }

        for(int value:arr2)
        {
            while(count[value]>0)
            {
                result.add(value);
                count[value]--;
            }
        }

        for(int num=0;num<=maxElement;num++)
        {
            while(count[num]>0)
            {
                result.add(num);
                count[num]--;
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
