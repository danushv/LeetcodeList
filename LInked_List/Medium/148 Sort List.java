/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 Merge sort is often preferred for sorting a linked list. The slow random-access performance of a linked list 
 makes some other algorithms (such as quicksort) perform poorly, and others (such as heapsort) completely impossible
 */
class Solution {
    public ListNode sortList(ListNode head) {
    //this is th base case in reccursive function
        if(head==null||head.next==null)
            return head;
        ListNode temp=head;
        ListNode slowp=head;
        ListNode fastp=head;
        // i find the middle element from this loop
        while(fastp!=null&&fastp.next!=null)
        {
            temp=slowp;
            slowp=slowp.next;
            fastp=fastp.next.next;
        }
        // this is to seperate the left and right listnide
        temp.next=null;
        //i recursively call this unill i get single single node the linked list will only contain single values
        ListNode left=sortList(head);
        ListNode right=sortList(slowp);
        return merge(left,right);
    }
    public ListNode merge(ListNode l1,ListNode l2)
    {
    // here i check the values and put it in the current value
     ListNode temp_node=new ListNode();
        ListNode current =temp_node;
            while(l1!=null&&l2!=null)
        {
            if(l1.val<l2.val)
            {
                current.next=l1;
                l1=l1.next;
            }
                else
                {
                    current.next=l2;
                    l2=l2.next;       
                }
                current=current.next;
        }
        // these are the corner cases
        if(l1!=null)
        {
            current.next=l1;
            l1=l1.next;
        }
       if(l2!=null)
        {
            current.next=l2;
           l2=l2.next;
        }
        // return the value
        return temp_node.next;
    }
    
}
