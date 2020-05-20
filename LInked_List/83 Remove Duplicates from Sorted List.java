already a sorted arrayb will be given just find if there is/are any duplicate elements
Just carefully watch the while loop
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp=head;
        while(temp!=null&&temp.next!=null)
        {
            if(temp.val==temp.next.val)
                temp.next=temp.next.next;
            else
                temp=temp.next;
        }
        return head;any duplicate elements
