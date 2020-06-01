/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy=new ListNode(-1),prev=dummy;
        dummy.next=head;
        for(int i=0;i<m-1;i++)
        {
            prev=prev.next;
        }
        ListNode cur=prev.next;
        while(m++<n)
        {
        //skip the middle node
        // lets take it 1,2,3,4,5,
        //1=prev ,2=curr ,3=temp
        //4 to 2 connection is made
            ListNode temp=cur.next;
            //4 to 5 connectio is changed to 2 to 5
            cur.next=temp.next;
            //13245 connection is made
            temp.next=prev.next;
            prev.next=temp;
        }
        return dummy.next;
    }
}
