we have to find the next greater element

for example 215--my stack is empty 2 is pushed , 1 is pushed but-- 5 is greater so what happens is 1 is popped and is the 1's index 
5 is added sp now my stack contains only 2 and 5 is not pushec because 2 is there not two is popped and in 2's index 5 is added

class Solution {
    public int[] nextLargerNodes(ListNode head) {
        ListNode temp=head;
        i am creating a array list and i am storing the linked list value
        ArrayList<Integer> res=new ArrayList<Integer>();
        Stack<Integer> stack=new Stack();
        while(temp!=null)
        {
            res.add(temp.val);
            temp=temp.next;
        }
        // here is the output array;
        // the index is kept track by the (i)
        int []output=new int[res.size()];
        for(int i=0;i<res.size();i++)
        {
        this is where it compare between 1 and 5
            while(!stack.isEmpty()&&res.get(stack.peek())<res.get(i)){
                output[stack.pop()]=res.get(i);// this is very important in this it works ith the output[stack.pop()] works witht the index value
        }
            stack.push(i);
        }
        return output;
    }
}
