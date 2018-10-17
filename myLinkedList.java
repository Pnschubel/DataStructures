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
    private int currentSize;
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
        currentSize = 0;
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
        currentSize += 1;
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
     * A size method to get the size of the linked list
     * @param none
     * @return int the size of the LL
     */
    public int size(){
        if (first == null){return 0;}
        Node temp = first;
        int count = 1;
        
        //Goes through to find size of LL
        while (temp.next != null){
            temp = temp.next;
            count++;
        }
        
        return count;
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
        currentSize -= 1;
        return data;
    }
    
    public ListIterator listIterator(){
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
    
    /**16.1**/
    /**
     * Helper method to follow n nodes in LL
     * @pre LL must have at least n nodes
     * @param int n the number of nodes to follow
     * @return Node the node that is node number n
     */
    private Node getNode(int n){
        Node desiredNode; //the node we use to follow all the nodes down to the one we want
        int count = 1;
        desiredNode = first; //starting location
        while (count != n){
            desiredNode = desiredNode.next;
            count += 1;
        }
        return desiredNode;
    }
    
    /**
     * Method to get the data located at node #n
     * @param int n the desired node
     * @return Object 
     */
    public Object get(int n){
        if (n > currentSize){throw new NoSuchElementException();}
        Node temp = this.getNode(n);
        return temp.data;
    }
    
    /**
     * Method to set the data located at node #n
     * @param int n the desired node Object obj the data to be set
     * @return none
     */
    public void set(int n, Object obj){
        if (n > currentSize){throw new NoSuchElementException();}
        Node change = this.getNode(n);
        change.data = obj;
    }
    /**End of 16.1**/
    
    /**Start of 16.4**/
    /**
     * Sees whether an object is in the LL
     * @param Object obj the object to check for
     * @return boolean whether or not obj is in LL
     */
    public boolean contains(Object obj){
        Node temp = first;
        boolean flag = false; //var to tell us whether it is in LL or not
        while (!flag && temp.next != null){
            if (temp.data.equals(obj)){
                flag = true;
            }
            temp = temp.next;
        }
        return flag;
    }
   
    //Class for the iterator
    class LinkedListIterator implements ListIterator{
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
         * Janky hasNext to test our QA abilities
         * @param none
         * @return boolean janky whether or not anothe lement after said element LL
         */
        public boolean jankyHasNext(){
            return position != null;
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
            currentSize += 1;
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
            currentSize -= 1;
            return position;
        }
    }
}
