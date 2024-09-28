class ListNode {
    int val;
    ListNode prev;
    ListNode next;

    public ListNode(int val){
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

class MyCircularDeque {
    int capacity;
    int size;
    ListNode left;
    ListNode right;
    
    public MyCircularDeque(int k) {
        this.capacity = k;
        this.size = 0;
        this.left = new ListNode(0);
        this.right = new ListNode(0);
        left.next = right;
        right.prev = left;
    }
    
    public boolean insertFront(int value) {
        if (isFull()){
            return false;
        }

        ListNode newNode = new ListNode(value);
        ListNode next = left.next;
        ListNode prev = left;
        next.prev = newNode;
        prev.next = newNode;
        newNode.prev = prev;
        newNode.next = next;
        this.size++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if (isFull()){
            return false;
        }

        ListNode newNode = new ListNode(value);
        ListNode next = right;
        ListNode prev = right.prev;
        next.prev = newNode;
        prev.next = newNode;
        newNode.next = next;
        newNode.prev = prev;
        this.size++;
        return true;
    }
    
    public boolean deleteFront() {
        if (isEmpty()){
            return false;
        }

        ListNode next = left.next.next;
        ListNode prev = left;
        next.prev = prev;
        prev.next = next;
        this.size--;
        return true;
    }
    
    public boolean deleteLast() {
        if (isEmpty()){
            return false;
        }

        ListNode next = right;
        ListNode prev = right.prev.prev;
        next.prev = prev;
        prev.next = next;
        this.size--;
        return true;
    }
    
    public int getFront() {
        if (isEmpty()){
            return -1;
        }
        return left.next.val;
    }
    
    public int getRear() {
        if (isEmpty()){
            return -1;
        }
        return right.prev.val;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == capacity;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
