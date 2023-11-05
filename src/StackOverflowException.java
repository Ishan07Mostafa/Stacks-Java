public class StackOverflowException extends Exception{
    public StackOverflowException(){
        System.out.println("Size of the stack is out of bound.");
    }
}
