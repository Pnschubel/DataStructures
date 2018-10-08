/**
 * Class to test the self-made data structures
 * 
 * @Payton Schubel 
 * @9/26/2018
 */
public class TestDataStructure
{
    public static void LLtest(){
        myLinkedList list = new myLinkedList();
        /*
        String word = "word";
        list.addFirst(word);
        list.addFirst(new String("two"));
        */
        
        list.addFirst(new String("this"));
        list.addFirst(new String("is"));
        list.addFirst(new String("a"));
        list.addFirst(new String("somewhat"));
        list.addFirst(new String("boring"));
        list.addFirst(new String("test"));
        list.addFirst(new String("and"));
        list.addFirst(new String("waffle"));
        System.out.println(list);
        list.reverse();
        System.out.println(list);
        /*
         * //old school -- must cast since getFirst() returns object
        String word2 = (String)list.getFirst();
        System.out.println(word2);
        */
    }
    public static void QA(){
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
        
        if (list.getFirst() == null){
            System.out.println("Error");
        }
    }
    public static void main (String[] args){
        //LLtest();
        QA();
    }

}
