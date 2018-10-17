/**
 * Class to test the self-made data structures
 * 
 * @Payton Schubel 
 * @9/26/2018
 */
public class TestDataStructure
{
    public static myLinkedList createLinkedList(){
        myLinkedList list = new myLinkedList();
        
        list.addFirst(new String("this"));
        list.addFirst(new String("is"));
        list.addFirst(new String("a"));
        list.addFirst(new String("somewhat"));
        list.addFirst(new String("boring"));
        list.addFirst(new String("test"));
        list.addFirst(new String("and"));
        list.addFirst(new String("waffle"));
        return list;
    }
    public static void LLtest(myLinkedList list){
        //System.out.println(list);
        list.reverse();
        //System.out.println(list);
        /*
         * //old school -- must cast since getFirst() returns object
        String word2 = (String)list.getFirst();
        System.out.println(word2);
        */
        System.out.println(list);
        
        System.out.println("\nContain somewhat? Expect True: " + list.contains("somewhat"));
        System.out.println("Contain omega? Expect False: " + list.contains("omega"));
        System.out.println("Get value of Node 3. Expect test: " + list.get(3));
        System.out.println("Setting value of Node 3 to PARTY.");list.set(3, "PARTY");
        
        System.out.println("\n" + list);
    }
    public static void QA(myLinkedList list){
        /*
        myLinkedList list = new myLinkedList();
        //Tests jankyAddFirst to try and get an error.
        list.jankyAddFirst(new String("this"));
        list.jankyAddFirst(new String("is"));
        list.jankyAddFirst(new String("a"));
        list.jankyAddFirst(new String("somewhat"));
        list.jankyAddFirst(new String("janky"));
        list.jankyAddFirst(new String("test"));
        list.jankyAddFirst(new String("and"));
        list.jankyAddFirst(new String("waffle"));
        if (list.removeFirst().equals(list.removeFirst())){
            System.out.println("Error: LL points to itself");
        }
        */
        ListIterator iter = list.listIterator();
        iter.remove();
    }
    public static void queueTester(){
        LinkedListQueuestudent q = new LinkedListQueuestudent();
        q.add("Tom");
        q.add("Diana");
        q.add("Mark");
        q.add("Harry");
        q.firstToLast();
        q.add("Bob");
        while (!q.empty()){
            System.out.println(q.remove()+" ");
        }
    }
    public static void main (String[] args){
        myLinkedList list = createLinkedList();
        LLtest(list);
        //QA(list);
        //queueTester();
    }

}
