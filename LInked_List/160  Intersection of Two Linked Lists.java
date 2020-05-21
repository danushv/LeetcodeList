We have to find the intersection of the linkedlist the idea behind it is when  a loop gets to the null the we assing it to bhead similarly if b get to null we assign It to ahead so each pointer traverse it twice and hence we get the solution
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a=headA;
        ListNode b=headB;
        while(a!=b)
        {
          
            if(a==null)
            {
                a=headB;
            }
            else
                a=a.next;
            if(b==null)
            {
                
                b=headA;
        }
        else
        {
            b=b.next;
        }
    }
        return a;
}
}
