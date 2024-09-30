class CustomStack {
    Stack<Integer> mainStack;
    Stack<Integer> updateStack;
    int capacity;

    public CustomStack(int maxSize) {
        this.mainStack = new Stack<>();
        this.updateStack = new Stack<>();
        this.capacity = maxSize;
    }
    
    public void push(int x) {
        if (mainStack.size() == capacity){
            return;
        }
        mainStack.push(x);
    }
    
    public int pop() {
        if (mainStack.isEmpty()){
            return -1;
        }
        return mainStack.pop();
    }
    
    public void increment(int k, int val) {
        while (!mainStack.isEmpty()){
            updateStack.push(mainStack.pop());
        }

        while (!updateStack.isEmpty() && k > 0){
            mainStack.push(updateStack.pop() + val);
            k--;
        }

        while (!updateStack.isEmpty()){
            mainStack.push(updateStack.pop());
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
