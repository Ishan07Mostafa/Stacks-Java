public class ArrayStack implements Stack{
    int size;
    Object [] data;

    public ArrayStack(){
        this.size=0;
        this.data = new Object[5];
    }

    // The number of items on the stack
    public int size(){
        return this.size;
    }
    // Returns true if the stack is empty
    public boolean isEmpty(){
        if(this.size==0) return true;
        else return false;
    }
    // Pushes the new item on the stack, throwing the
    // StackOverflowException if the stack is at maximum capacity. It
    // does not throw an exception for an "unbounded" stack, which
    // dynamically adjusts capacity as needed.
    public void push(Object element) throws StackOverflowException{
        if(this.size>=this.data.length) throw new StackOverflowException();
        data[this.size] = element;
        this.size+=1;
    }
    // Pops the item on the top of the stack, throwing the
    // StackUnderflowException if the stack is empty.
    public Object pop() throws StackUnderflowException{
        Object element = null;
        if(this.size==0) {
            throw new StackUnderflowException();
        }
        int n;
        if(this.size==0) n = this.size;
        else n = this.size-1;
        element = this.data[n];
        this.data[n] = null;
        this.size--;
        return element;
    }
    // Peeks at the item on the top of the stack, throwing
    // StackUnderflowException if the stack is empty.
    public Object peek() throws StackUnderflowException{
        int n;
        if(this.size==0) n = this.size;
        else n = this.size-1;
        if(this.size<0) throw new StackUnderflowException();
        Object element = null;
        element = this.data[n];
        return element;
    }
    // Returns a textual representation of items on the stack, in the
    // format "[ x y z ]", where x and z are items on top and bottom
    // of the stack respectively.
    public String toString(){
        String str = "[ ";
        for(int i = this.size-1; i>=0; i--){
            str = str + this.data[i] + " ";
        }
        str+="]";
        return str;
    }
    // Returns an array with items on the stack, with the item on top
    // of the stack in the first slot, and bottom in the last slot.
    public Object[] toArray(){
        Object[] array;
        if(this.size==0){
            array = new Object[1];
            array[0] = null;
        }
        else{
            array = new Object[this.size];
            int j;
            if(this.size==0) j = 0;
            else j = this.size-1;
            for(int i = 0; i<this.size; i++,j--){
                array[i] = this.data[j];
            }
        }
        return array;
    }
    // Searches for the given item on the stack, returning the
    // offset from top of the stack if item is found, or -1 otherwise.
    public int search(Object element){
        int distance = 0;
        for(int i = this.size-1; i>=0; i--){
            if(this.data[i]==element) return distance;
            else distance+=1;
        }
        return -1;
    }

}