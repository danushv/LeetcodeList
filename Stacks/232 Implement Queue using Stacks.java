class MyQueue {
 Stack<Integer> queue = new Stack();
        Stack<Integer> stack=new Stack();
    /** Initialize your data structure here. */
    public MyQueue() {
       
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        while(!queue.isEmpty())
        {
            stack.push(queue.pop());
        }
        queue.push(x);
        while(!stack.isEmpty())
        {
            queue.push(stack.pop());
        }
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
     return queue.pop()  ;
    }
    
    /** Get the front element. */
    public int peek() {
       return queue.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
     return  queue.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
