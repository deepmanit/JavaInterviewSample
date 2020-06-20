package Java8;

import java.util.stream.Stream;

public class StreamTest {
    public static void test()
    {
        int sum = Stream.of(1, 2, 3, 4, 5).peek(i->System.out.println("Peek Element is " + i)).
                filter(i->i%2 != 0).peek(i -> System.out.println("Filter Elem is+" + i)).
                map(i->i*i).peek(i -> System.out.println("mapped Elem is+" + i)).reduce(0,Integer::sum);
        System.out.println("sum is "  +sum);
    }
}
