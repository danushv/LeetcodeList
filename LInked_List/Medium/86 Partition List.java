//Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
//i use two pointer element concept
class Solution {
    public ListNode partition(ListNode head, int x) {
    //this is the pointers i use
    
        ListNode first=new ListNode(0);
        ListNode firstp=first;
        ListNode last=new ListNode(0);
        ListNode lastp=last;
        //i check with the head value
        while(head!=null)
        {
        // if it is less then i add it to the first linkef=d list
            if(head.val<x)
            {
                first.next=head;
                first=first.next;
            }
            // else i add it to the last linked list
            else
            {
                last.next=head;
                last=last.next;
            }
            // i increment the head value 
            head=head.next;
        }
        // now we have to merge the linked list so what we have to do is there are three steps
        // 1 last will be at the end so point it to the null
        //2 first will be in the middle so join it with the (lastp) of next which will point to the first node of last ll
        // firstp =0 so return the next value of ll
        last.next=null;
        first.next=lastp.next;
        return firstp.next;
    }
}
