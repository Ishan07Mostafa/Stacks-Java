public class StackUnderflowException extends Exception{
    public StackUnderflowException(){
        System.out.println("Size of the stack is under the bound.");
    }
}
