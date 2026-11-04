class MyLinkedList {

    private ListNode head;
    private ListNode tail;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
    }
    
    public int get(int index) {
        ListNode curr = head;
        int i = 0;
        while (curr != null && index != i) {
             curr = curr.next;
             i++;
        }

        if (curr != null && index == i) {
            return curr.getVal();
        }

        return -1;
    }
    
    public void addAtHead(int val) {
        ListNode curr = new ListNode(val, head);
        head = curr;
        if (tail == null) {
            tail = curr;
        }
    }
    
    public void addAtTail(int val) {
        ListNode curr = new ListNode(val, null);
        if (head == null) {
            head = curr;
            tail = curr;
        } else {
            tail.setNext(curr);
            tail = curr;
        }
    }
    
    public void addAtIndex(int index, int val) {

        ListNode sentinel = new ListNode(Integer.MIN_VALUE, head);

        int i = 0;
        ListNode prev = sentinel, curr = head;

        while (curr != null && i != index) {
            prev = curr;
            curr = curr.getNext();
            i++;
        }

        ListNode node = new ListNode(val, curr);
        if (curr != null || i == index) {
            prev.setNext(node);
            if (node.getNext() == null) {
                this.tail = node;
            }
        }

        this.head = sentinel.getNext();        
        
    }
    
    public void deleteAtIndex(int index) {
        
        ListNode sentinel = new ListNode(Integer.MIN_VALUE, head);
        ListNode prev = sentinel, curr = head;
        int i = 0;
        while (curr != null && i != index) {
            prev = curr;
            curr = curr.getNext();
            i++;
        }

        if (curr != null) {
            prev.setNext(curr.getNext());
            if (this.tail == curr) {
                this.tail = prev;
                if (this.tail == sentinel) {
                    this.tail = null;
                }   
            }
        }

        this.head = sentinel.getNext();

        
    }
}

class ListNode {

    private int val; 
    private ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
    
    public ListNode getNext() {
        return this.next;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public int getVal() {
        return this.val;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */