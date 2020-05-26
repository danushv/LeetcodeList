// there will be two linked list given we hav to find the sum of it
//Algorithm
//1 add the linked list in a stack
//2 while both stacks are not null
//3 add it also keep in track with carry thing
 
 /* ____________
    | dummy    |
    |__________|     between this summ                ____________
                      will be added                   | next     |
                                                      |__________|*/
                                                      
 
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null&&l2==null)
            return null;
        if(l1==null )
            return l2;
        if(l2==null)
            return l1;
        Stack<ListNode>s1=new Stack();
        Stack<ListNode>s2=new Stack();
        ListNode temp1=l1;
        while(temp1!=null)
        {
           s1.push(temp1);
            temp1=temp1.next;
        }
        ListNode temp2=l2;
        while(temp2!=null)
        {
            s2.push(temp2);
            temp2=temp2.next;
        }
        ListNode dummy= new ListNode(0);
        int carry=0;
        while(!s1.isEmpty()||!s2.isEmpty()||carry!=0)
        {
            int a=s1.isEmpty()?0:s1.pop().val;
            int b=s2.isEmpty()?0:s2.pop().val;
            int sum=a+b+carry;
            carry=0;
            if(sum>=10)
            {
                carry=1;
                sum=sum-10;
            }
            ListNode add =new ListNode(sum);
            ListNode next=dummy.next;
            add.next=next;
            dummy.next=add;
        }
        return dummy.next;
    }
}
