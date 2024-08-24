class MinStack {

    private Stack<Integer> stack; // Stack to hold actual elements
    private Stack<Integer> minStack; // Stack to hold minimum elements

    /** Initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    /** Push element x onto stack. */
    public void push(int val) {
        stack.push(val);
        // Push onto minStack only if it's empty or val is smaller than the current minimum
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }
    
    /** Removes the element on the top of the stack. */
    public void pop() {
        if (stack.isEmpty()) return;
        int top = stack.pop();
        // Remove from minStack if it is the current minimum
        if (top == minStack.peek()) {
            minStack.pop();
        }
    }
    
    /** Get the top element. */
    public int top() {
        
        return stack.peek();
    }
    
    /** Retrieve the minimum element in the stack. */
    public int getMin() {
       
        return minStack.peek();
    }}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */