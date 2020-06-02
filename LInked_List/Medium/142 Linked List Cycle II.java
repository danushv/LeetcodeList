//first we check if there is any loop in the given linked list
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slowptr=head;
        ListNode fastptr=head;
        //int count=0;
        if(head==null)
            return null;
while(fastptr.next!=null && fastptr.next.next!=null)
{
    
    slowptr=slowptr.next;
    fastptr=fastptr.next.next;
    // if there is a loop
    // that is when sloopointer is equla to fastptr at that time we reset it to the head;
    
    if(slowptr==fastptr)
    {
        slowptr=head;
        //again when it meets at that time it would be the start of the loop yes we have no definiton so do handson check using a example
        // its working
        while(slowptr!=fastptr)
        {
            slowptr=slowptr.next;
            fastptr=fastptr.next;
        }
   return slowptr;
    }
   
    }
        return null;
}
}
