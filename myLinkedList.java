import java.util.NoSuchElementException;
import java.util.Arrays;
/**
 * Watered-Down version of a linked list created for practice
 * 
 * @Payton
 * @9/25/2018
 */
public class myLinkedList
{
    private Node first; //Linked list must know where the first is.

    //The linked list has to access all of the nodes, but nodes still need to be private.
    //So inner class for nodes.
    class Node{
        //Nodes must be able to see object
        public Object data;
        //Nodes must know next node
        public Node next;
        
        //Old school: Any object in, cast to type the object as we remove.
    }
    
    /**
     * Default constructor for objects of class myLinkedList
     */
    public myLinkedList()
    {
        //initizlise linked list variables
        first = null;
    }

    /**
     * Adds element to the front of the LinkedList
     * @param element the element added to the front of the list.
     */
    public void addFirst(Object element){
        Node newNode = new Node();
        newNode.data = element;//points to the object
        newNode.next = first; //Moves along the path
        first = newNode;//Says that the newNode is first.
    }
    
    /**
     * A purposefully bad method so we can work on our QA skills
     * @param element the element to add to the front of the list
     * @return none
     */
    public void jankyAddFirst(Object element){
        Node newNode = new Node();
        first = newNode;
        newNode.data = element;
        newNode.next = first;
    }
    
    /**
     * Gets the first element in the LinkedList
     * @param none
     * @return Object the element at the front of the list
     */
    public Object getFirst(){
        if (first == null){throw new NoSuchElementException();}
        else{return first.data;}
    }
    
    /**
     * Removes the first element in the LinkedList
     * @param none
     * @return Object the element at the beginning of the list
     */
    public Object removeFirst(){
        if (first == null){throw new NoSuchElementException();}
        Object data = first.data;
        first = first.next;
        return data;
    }
    
    public LinkedListIterator listIterator(){
        return new LinkedListIterator();
    }
    
    public void reverse(){
        if (first == null) return;
        /*
        Node previous = first;
        Node current = first.next;
        Node next = null;
        first.next = null;
        while (current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        first = previous;
        */
        
        /*
        //The Janky Code I promised Justas that doesn't even work
        Node temp = first;
        int count = 0;
        
        //Goes through to find size of LL
        while (temp.next != null){
            temp = temp.next;
            count++;
        }
        //Array of all nodes in the LL
        Node[] nodes = new Node[count];
        
        //resets temp back to first
        temp = first;
        
        //puts all nodes in array in reverse
        while (temp.next != null){
            nodes[--count] = temp;
            temp = temp.next;
        }
        
        count = 0;
        first = nodes[count];
        temp = first;
        
        //Puts all nodes back into LL in reverse
        for (int i = 1; i < nodes.length; i++){
            temp.next = nodes[i];
            System.out.println(temp.data + ", " + temp.next.data);            
            if (i == nodes.length - 1) break;
            temp = temp.next;
        }
        */
    
      }
    
    public String toString(){
        if (first == null){return "";}
        Node temp = first;
        String hold = "";
        while (temp != null){
            hold += temp.data + ", ";
            //System.out.println(hold);
            temp = temp.next;
        }
        return hold;
    }
    
    //Class for the iterator
    class LinkedListIterator{
        private Node position;//the position of the iterator
        private Node previous;//the previous position of the iterator -- for removal
        private boolean isAfterNext;//makes sure we've moved before error.
        
        /**
         * Constructor for the LinkedListIterator
         */
        public LinkedListIterator(){
            position = null;
            previous = null;
            isAfterNext = false;
        }
        
        /**
         * Iterates through the list
         * @param none
         * @return object the object the iterator just passed over
         */
        public Object next(){
            if(!hasNext()){throw new NoSuchElementException();}
            
            isAfterNext = true; //because we just called next
            
            //moves previous over to current position
            previous = position;
            
            if(position == null){//at very beginning of list
                position = first;
            }else{
                position = position.next;
            }
            
            return previous;
        }
        
        /**
         * Sees whether the LinkedList has an element next or not
         * @param none
         * @return boolean whether or not there is another element after said element in LL
         */
        public boolean hasNext(){
            if(position == null){
                return first != null;
            }else{
                return position.next != null;
            }
        }
        
        /**
         * Adds element to the list
         * @param Object the object to add to the list
         */
        public void add(Object element){
            if (position == null){
                addFirst(element);
                position = first;
            }else{
                Node newNode = new Node();
                newNode.data = element;
                newNode.next = position.next;
                //This is why can't add/remove before calling next -- both pos and pos.next
                //point at same node.
                position.next = newNode;
                position = newNode;
            }
            
            isAfterNext = false;
        }
        
        /**
         * Removes element from the list
         * @param none
         * @return Object the object we just removed from LL
         */
        public Object remove(){
            if(!isAfterNext){throw new IllegalStateException();}
            
            if(position == first){
                removeFirst();
            }else{
                previous.next = position.next;
            }
            position = previous;
            isAfterNext = false;
            return position;
        }
    }
}
