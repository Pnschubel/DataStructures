import java.util.NoSuchElementException;
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
}
