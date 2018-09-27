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
        String word = "word";
        list.addFirst(word);
        list.addFirst(new String("two"));
        
        //old school -- must cast since getFirst() returns object
        String word2 = (String)list.getFirst();
    }
    public static void main (String[] args){
        LLtest();
    }

}
