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
    public ListNode reverseList(ListNode head) {
        if(head==null)
        {
            return head;
        }
ListNode currentNode=head;
while(head.next!=null)
{
ListNode p=head.next;
head.next=p.next;
p.next=currentNode;
currentNode=p;
}
        return currentNode;
    }
}