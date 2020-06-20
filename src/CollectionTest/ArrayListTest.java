package CollectionTest;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
 class SmartPhone {
    String brand;
    String model;
    int price;
    int rating;
    SmartPhone(String brand,String model,int price, int rating){
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.rating = rating;

    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public int getRating() {
        return rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }
    public String toString() {
        return"SmartPhone [brand=" + brand + ", model=" + model + ", price=" + price + ", rating=" + rating + "]";
    }
    public int compareTo(SmartPhone sp) {
        return this.price - sp.price;

    }
}
class RatingComparator implements Comparator<SmartPhone> {
    @Override
    public int compare(SmartPhone obj1, SmartPhone obj2) {
        return (obj1.rating<obj2.rating) ? -1 : (obj1.rating>obj2.rating) ? 1 : 0;
    }
}
public class ArrayListTest {

    public static void test()
    {
         List<String> list = new ArrayList<>(10);

        list.add("Apple");
        list.add("Banana");
        list.add("Grapes");
        Iterator itr=list.iterator();//getting the Iterator
        while (itr.hasNext())
        {
            System.out.print(" " + itr.next());

        }
        System.out.println();
        for(int i = 0; i<list.size(); ++i)
        {
            System.out.print(" " +list.get(i));
        }
        System.out.println();
        ListIterator<String> list1=list.listIterator(list.size());
        while(list1.hasPrevious())
        {

            System.out.print(" " +list1.previous());
        }
        System.out.println();
        list.forEach(a->{ //Here, we are using lambda expression
            System.out.print(" " +a);
        });
        System.out.println();
        Iterator<String> itr1=list.iterator();
        itr1.forEachRemaining(a-> //Here, we are using lambda expression
        {
            System.out.print(" " +a);
        });
        System.out.println();
        Collections.sort(list, Collections.reverseOrder());
        list.forEach(a->{ //Here, we are using lambda expression
            System.out.print(" " +a);
        });
        Collections.sort(list);
        System.out.println();
        list.forEach(a->{ //Here, we are using lambda expression
            System.out.print(" " +a);
        });
        System.out.println();

        ArrayList<String> firstList=new ArrayList<String>();
//adds elements to the arraylist
        firstList.add("Apple");
        firstList.add("Pears");
        firstList.add("Guava");
        firstList.add("Mango");
        System.out.println(firstList);
//second array list
        List<String> secondList=new ArrayList<String>();
//adds elements to the arraylist
        secondList.add("Apple");
        secondList.add("Apple");
        secondList.add("Pears");
        secondList.add("Guava");
        secondList.add("Mango");
        System.out.println(secondList);
//comparing both lists
        boolean boolval = firstList.equals(secondList); //returns true because lists are equal
        System.out.println(boolval);
//adding another element in the second list
        secondList.add("Papaya");
//again comparing both lists
        boolean bool = firstList.equals(secondList); //returns false because lists are not equal
        System.out.println(bool);
        ArrayList<Integer> firstList1=new ArrayList<Integer>(Arrays.asList(12, 4, 67, 90, 34));
        System.out.println("First array list: ");
        System.out.println(firstList1);
//second array list
        List<Integer> secondList1=new ArrayList<Integer>(Arrays.asList(12, 4, 67, 0, 34));
        System.out.println("Second array list: ");
        System.out.println(secondList1);
//returns the common elements in both list
      //  firstList1.removeAll(secondList1);
      //  System.out.println("Un-common element of the first list: ");
   //     System.out.println(firstList1);
        // Finds common elements
        Collections.reverse(secondList1);
        System.out.print("Common elements: " +firstList1.stream().filter(secondList1::contains).collect(Collectors.toList()));;

       // List<String>unmodifiableList= Collections.unmodifiableList(secondList);
       // unmodifiableList.add("INDIA");
        System.out.println(secondList1);
        Set<String> s = new LinkedHashSet<String>(secondList);
        System.out.println(s);


        List<SmartPhone> phoneList = new ArrayList<>();
        SmartPhone ph1 = new SmartPhone("Apple", "6s", 50000, 10);
        SmartPhone ph2 = new SmartPhone("lg", "pro2", 40000, 9);
        SmartPhone ph3 = new SmartPhone("MI", "3s", 10000, 6);
        SmartPhone ph4 = new SmartPhone("Letv", "le2", 12000, 7);

        phoneList.add(ph1);
        phoneList.add(ph2);
        phoneList.add(ph3);
        phoneList.add(ph4);
        System.out.println("Actual List");
        System.out.println(phoneList);
        System.out.println("Sorting the list as comparator");
        Collections.sort(phoneList, new RatingComparator());

        System.out.println(phoneList);
        System.out.println("Reversing the Comparator sorting");
        Comparator<SmartPhone> cmp = Collections.reverseOrder(new RatingComparator());

        Collections.sort(phoneList, cmp);
        System.out.println("Printing the reverse list");
        System.out.println(phoneList);


        List<String> fruitList = new ArrayList<>();
        //adding String Objects to fruitsList ArrayList
        fruitList.add("Mango");
        fruitList.add("Banana");
        fruitList.add("Apple");
        fruitList.add("Strawberry");
        fruitList.add("Pineapple");
        System.out.println("Converting ArrayList to Array" );
        String[] item = fruitList.toArray(new String[fruitList.size()]);
        for(String s1 : item){
            System.out.println(s1);
        }
        System.out.println("Converting Array to ArrayList" );
        List<String>l2 = new ArrayList<>();
        l2 =  Arrays.asList(item);
        System.out.println(l2);

        // Synchronizing ArrayList in Java
        fruitList = Collections.synchronizedList(fruitList);

        // we must use synchronize block to avoid non-deterministic behavior
        synchronized (fruitList) {
            Iterator<String> itr11 = fruitList.iterator();
            while (itr11.hasNext()) {
                System.out.println(itr11.next());
            }
        }

    }
}
