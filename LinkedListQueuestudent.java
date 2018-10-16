/**
   Add a method firstToLast to this implementation of a queue.
   The method moves the element at the head of the queue to
   the tail of the queue. The element that was second in line
   will now be at the head.
*/
public class LinkedListQueuestudent
{
   private Node head;
   private Node tail;

   /**
      Constructs an empty queue.
   */
   public LinkedListQueuestudent()
   {
      head = null;
      tail = null;
   }

   /**
      Moves the head of the queue to the tail.
   */
   public void firstToLast()
   {
      if (head == null){return;}
      tail.next = head;
      tail = head;
      head = head.next;
      tail.next = null;
   }

   /**
      Checks whether this queue is empty.
      @return true if this queue is empty
   */
   public boolean empty()
   {
      return head == null;
   }

   /**
      Adds an element to the tail of this queue.
      @param newElement the element to add
   */
   public void add(Object newElement)
   {
       if (tail == null){
           Node newNode = new Node();
           newNode.data = newElement;
           newNode.next = null;
           tail = newNode;
           head = newNode;
        }else{
            Node newNode = new Node();
            newNode.data = newElement;
            newNode.next = null;
            tail.next = newNode;
            tail = newNode;
        }

   }
   
   /**
    * Takes the first element and makes it the last element
    * @param none
    * @return none
    */
   public void firstToLast2(){
       if (head  == null){return;}
       Node temp = new Node();
       temp.data = head.data;
       temp.next = null;
       head = head.next;
       tail.next = temp;
       tail = tail.next;
    }
  
   /**
   * Takes the last element and makes it the first element
   * @param none
   * @return none
   */
   public void lastToFirst(){
       if (head == null){return;}
       Node temp = new Node();
       temp.data = tail.data;
       temp.next = head;
       head = temp;
       Node flag = head;
       while (flag.next != tail){
           flag = flag.next;
        }
       tail = flag;
       tail.next = null;
    }

   /**
      Removes an element from the head of this queue.
      @return the removed element
   */
   public Object remove()
   {
       if (head == null){return null;}
       Object element = head.data;
       head = head.next;
       
       if (head == null)//queue is empty
        tail = null;
       
       return element;
    }

   class Node
   {
      public Object data;
      public Node next;
    }
}
