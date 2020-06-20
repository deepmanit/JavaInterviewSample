package CollectionTest;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListTet {
    public static void test()
    {
        LinkedList<String> ll=new LinkedList<String>();
        ll.add("Ravi");
        ll.add("Vijay");
        ll.add("Ajay");
        ll.descendingIterator();
        Iterator i=ll.descendingIterator();
        while(i.hasNext())
        {
            System.out.println(i.next());
        }

    }
}
