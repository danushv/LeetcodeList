//A Sorted linked list would  be given what we have to do is convert that to binary search tree a only positive thing which is given is that 
//its sorted
//now what we have to do is find the mmid value of the linked list and that would form the mid value of the root
// we keeep a track of one more pointer which will help us to disconnect the linked list
//then we use the recursive call to sort the vbalue the base case iff its null
class Solution {
// this is the place where i find the middle element
    private ListNode  midelement(ListNode head)
    {
        ListNode slowp=head;
        ListNode fastp=head;
        ListNode prevp=head;
        while(fastp!=null&&fastp.next!=null)
        {
            prevp=slowp;
            slowp=slowp.next;
            fastp=fastp.next.next;
        }
        if(prevp!=null)
        {
            prevp.next=null;
        }
        return slowp;
        }
    public TreeNode sortedListToBST(ListNode head) {
    // this is the base function where i return null
        if(head==null)
        {
            return null;
        }
        // i get the middle value here
        ListNode mid=midelement(head);
       // i assign it to the tree root
        TreeNode node=new TreeNode(mid.val);
            if(head==mid)
            {
                return node;
            }
            // this is the recursice function for right and left
        node.left=sortedListToBST(head);
        node.right=sortedListToBST(mid.next);
        
        return node;
    }
}
