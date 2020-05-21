
We have to remeove the value given nodes from the linked list

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode cur=head;
        if head is not equal to null and if the head value is equal to the val of next then we have to shift the head 
        while(head!=null&&head.val==val)
        
            head=head.next;
            i have a pointer whihc traverse untill the penultimate node
        while(cur!=null&&cur.next!=null)
        {
            if(cur.next.val==val)
            {
                cur.next=cur.next.next;
            }
            else
                cur=cur.next;
        }
        return head;
    }
}
