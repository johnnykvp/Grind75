class MyQueue {
    Stack<Integer> backward = new Stack<>();
    Stack<Integer> forward = new Stack<>();
    int pushCount = 0;
    int popCount = 0;
    
    public void push(int x) {
        backward.push(x);
        pushCount++;
    }
    
    public int pop() {
        while (!backward.isEmpty()) {
            forward.push(backward.pop());
        }
        int pop = forward.pop();
        while (!forward.isEmpty()) {
            backward.push(forward.pop());
        }
        popCount++;
        return pop;
    }
    
    public int peek() {
        while (!backward.isEmpty()) {
            forward.push(backward.pop());
        }
        int peek = forward.peek();
        while (!forward.isEmpty()) {
            backward.push(forward.pop());
        }
        return peek;
    }
    
    public boolean empty() {
        if (pushCount == popCount) {
            return true;
        }
        return false;
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