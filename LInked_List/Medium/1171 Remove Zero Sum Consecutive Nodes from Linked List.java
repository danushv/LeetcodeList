// So a linked list will be given we have to delete nodes which sums to zero delete some part and return the linked list
//ADd the linked list that is node 1 , node2 , node 3 untill we get the sum as zero if we get zero(return the remaining ll)
// else if we dont get zero then increment the value and pass it to the function and return the head value
class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        if(head==null)
            return head;
        ListNode current =head;
        int sum=head.val;
        while(sum!=0&&current.next !=null)
        {
            current =current.next;
            sum=sum+current.val;
        }
        if(sum==0)
        {
            return removeZeroSumSublists(current.next);
        }else {
          //  head=head.next;
            head.next= removeZeroSumSublists(head.next);
            return head;
        }
    }
}
