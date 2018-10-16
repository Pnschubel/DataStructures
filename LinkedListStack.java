import java.util.NoSuchElementException;

/**
   An implementation of a stack as a sequence of nodes.
*/
public class LinkedListStack
{
   private Node top;

   /**
      Constructs an empty stack.
   */
   public LinkedListStack()
   {
      top = null;
   }

   /**
      Adds an element to the top of the stack.
      @param element the element to add
   */
   public void push(Object element){
       Node temp = new Node();
       temp.data = element;
       temp.next = top;
       top = temp;
    }

   /**
      Removes the element from the top of the stack.
      @return the removed element
   */
   public Object pop(){
       if (top == null){throw new NoSuchElementException();}
       Object temp = top.data;
       top = top.next;
       return temp;
    }

   /**
    * Returns the element from the top of the stack
    * @return the top of the stack
    */
   public Object peek(){
       return top;
    }

   /**
      Checks whether this stack is empty.
      @return true if the stack is empty
   */
   public boolean isEmpty(){
       return top == null;
    }

   class Node
   {
      public Object data;
      public Node next;
   }
}
