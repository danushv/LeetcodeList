Since the linked is a singly linked list we cant traverse back so what we do is we would have two pointers namely slow and fast pointers
Push ever node into a stack while traversing in the forward direction. 
eg 122221->>> stack value 221
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null)
        {
            return true;
        }
        ListNode first=head;
        ListNode last=head;
        // i am creating a stack to push in the values
        Stack<Integer> stack=new Stack<Integer> ();
        
        while(last!=null&&last.next!=null)
        {
        //here i push the slow pointers value into the stack 
            stack.push(first.val);
            first=first.next;
            last=last.next.next;
        }
    this is when if i have the odd number of linked list node
        if(last!=null)
        {
            first=first.next;
        }
            //in this loop i will check the stack popped out value is equla to the slow pointer 
            // because sloww pointer would have reached the 
    while(first!=null)
    {
        if(stack.pop()!=first.val)
        {
            
            return false;
        }
    
        first=first.next;
    }
      return true;
    }
}
