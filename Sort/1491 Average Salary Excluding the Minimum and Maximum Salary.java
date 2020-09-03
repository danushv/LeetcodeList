Given an array of unique integers salary where salary[i] is the salary of the employee i.

Return the average salary of employees excluding the minimum and maximum salary


class Solution {
    public double average(int[] salary) {
        double average=0;
        Arrays.sort(salary);
        double sum=0;
        int size= salary.length;
        for (int i=1;i<size-1;i++)
        {
            sum=sum+salary[i];
        }
        int div=size-2;
        average=sum/div;
        return average;
    }
}
