package Threading;

public class BlockingQueue<T> {
    T[] array;
    int capacity;
    int head = 0;
    int tail = 0;
    int size;
  //  Object lock = new Object();
    public BlockingQueue(int capacity) {
        array = (T[]) new Object[capacity];
        this.capacity = capacity;
        size = 0;
    }

    public synchronized void enqueue(T item) throws InterruptedException{

            while (size == capacity)
                wait();

           if(tail ==capacity)
               tail=0;

           array[tail]= item;
           ++tail;
           ++size;
           notifyAll();



    }

    public synchronized T dequeue() throws InterruptedException {
        while (size == 0)
            wait();
        // reset head to start of array if its past the array
        if (head == capacity) {
            head = 0;
        }

       T item = array[head];
        array[head] = null;
       ++head;
       --size;
       notifyAll();
       return item;
    }
}
