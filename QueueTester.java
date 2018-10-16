public class QueueTester
{
   public static void circularQueueTester(){
      CircularArrayQueue q = new CircularArrayQueue();
      q.add("Tom");
      q.add("Diana");
      q.add("Harry");
      q.firstToLast();
      while (!q.empty())
      {
         System.out.print(q.remove() + " ");
      }
      System.out.println();
      System.out.println("Expected: Diana Harry Tom");
      
      q = new CircularArrayQueue();
      q.add("Tom");
      q.add("Diana");
      q.add("Harry");
      System.out.println("\n\nExpected: Harry Tom Diana");
      q.lastToFirst();
      System.out.print("Result: ");
      while (!q.empty())
      {
         System.out.print(q.remove() + " ");
      }
      System.out.println();
    }
   public static void linkedQueueTester(){
      LinkedListQueuestudent q = new LinkedListQueuestudent();
      System.out.println("\n\n");
      q.add("Tom");
      q.add("Diana");
      q.add("Harry");
      q.firstToLast();
      while (!q.empty())
      {
         System.out.print(q.remove() + " ");
      }
      System.out.println();
      System.out.println("Expected: Diana Harry Tom");
      
      q = new LinkedListQueuestudent();
      q.add("Tom");
      q.add("Diana");
      q.add("Harry");
      q.lastToFirst();
      System.out.print("\n\nResult: ");
      while (!q.empty())
      {
         System.out.print(q.remove() + " ");
      }
      System.out.println();
      System.out.println("Expected: Harry Tom Diana");
    }
   public static void main(String[] args)
   {
      circularQueueTester();
      linkedQueueTester();
   }
}
