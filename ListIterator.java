

/**
 * To be implemented by ListIterator class
 * 
 * @Payton Schubel
 * @9/26/2018
 */
public interface ListIterator
{
    /**
     * Moves list iterator past next element
     * @param none
     * @return the transversed element
     */
    Object next();
    
    /**
     * Sees whether the listIterator hasNext();
     * @param none
     */
    boolean hasNext();
    
    /**
     * Adds element to the list
     * @param Object the object to add to the list
     */
    void add(Object element);
    
    /**
     * Removes element from the list and returns said element
     * @param none
     * @return Object the object remove from the list
     */
    Object remove();
}
