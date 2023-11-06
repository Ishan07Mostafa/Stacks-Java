public class ListStack implements Stack{
    int size;
    Node top;


    public ListStack(){
        this.size = 0;
        this.top = null;
    }

    // The number of items on the stack
    public int size(){
        return this.size;
    }
    // Returns true if the stack is empty
    public boolean isEmpty(){
        if(this.size==0) return true;
        return false;
    }
    // Pushes the new item on the stack, throwing the
    // StackOverflowException if the stack is at maximum capacity. It
    // does not throw an exception for an "unbounded" stack, which
    // dynamically adjusts capacity as needed.
    public void push(Object element){
        Node n = new Node(element, this.top);
        this.top = n;
        this.size++;
    }
    // Pops the item on the top of the stack, throwing the
    // StackUnderflowException if the stack is empty.
    public Object pop() throws StackUnderflowException{
        if(this.size==0) throw new StackUnderflowException();
        Object element = this.top.value;
        this.top = top.next;
        this.size--;
        return element;
    }
    // Peeks at the item on the top of the stack, throwing
    // StackUnderflowException if the stack is empty.
    public Object peek() throws StackUnderflowException{
        if(this.size==0) throw new StackUnderflowException();
        return this.top.value;
    }
    // Returns a textual representation of items on the stack, in the
    // format "[ x y z ]", where x and z are items on top and bottom
    // of the stack respectively.
    public String toString(){
        String str = "[ ";
        for(Node n = top; n!=null; n = n.next){
            str = str + n.value + " ";
        }
        str = str + "]";
        return str;
    }
    // Returns an array with items on the stack, with the item on top
    // of the stack in the first slot, and bottom in the last slot.
    public Object[] toArray(){
        Object[] array = new Object[this.size];
        int i = 0;
        for(Node n = top; n!=null; n = n.next){
            array[i] = n.value;
            i++;
        }
        return array;
    }
    // Searches for the given item on the stack, returning the
    // offset from top of the stack if item is found, or -1 otherwise.
    public int search(Object element){
        int distance = 0;
        for(Node n = top; n!=null; n = n.next){
            if(n.value==element) return distance;
            else distance+=1;
        }
        return -1;
    }
}