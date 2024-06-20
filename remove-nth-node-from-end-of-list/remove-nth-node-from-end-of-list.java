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


 // when revising there is something called as one pass algorithm using two pointers have a look at it too
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
       ListNode dummy=new ListNode(0);
       dummy.next=head;
       int length=0;
       ListNode first=head;
       while(first!=null) 
       {
           length++;
           first=first.next;
       }
       // here is the concept 5=length , n=2; remove l-n+1 elemnt 
       // 1 2 3 4 5 -> 5-2+1==4. so remve the fourth element 
        //ListNode a=head;

        // so the normal question arises ? why dummy node ? 
        // dummy node is used to simplify some corner cases , list with only one node
        // or when we have to remove the head node 
       length-=n;
       first=dummy;
       while(length>0)
       {
           length--;
            first=first.next;
       }
       first.next=first.next.next;
         return dummy.next;
    }
  
}