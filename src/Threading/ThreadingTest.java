package Threading;

import java.util.HashSet;
import java.util.Set;

public class ThreadingTest {
    public static void test() throws InterruptedException {
       // test1();
     //   runTestMaxTokenIsTen();
       // runLateThenEarlyCallback();
        runTestCountingSemaPhore();
    }

    public static void test1() throws InterruptedException {
        BlockingQueue<Integer> q = new BlockingQueue<>(10);
        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    for (int i = 0; i < 50; i++) {
                        q.enqueue(new Integer(i));
                        System.out.println("enqueued " + i);
                    }
                } catch (InterruptedException ie) {

                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 50; i++) {
                        q.enqueue(new Integer(i));
                        System.out.println("enqueued " + i);
                    }
                } catch (InterruptedException ie) {

                }
            }
        });
        Thread t3 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    for (int i = 0; i < 50; i++) {
                        System.out.println("Thread 3 dequeued: " + q.dequeue());
                    }
                } catch (InterruptedException ie) {

                }
            }
        });

        t1.start();
        // t2.start();
        t3.start();
        t1.join();
        t3.join();
        //t2.join();

    }
    public static void runTestMaxTokenIsTen() throws InterruptedException {

        Set<Thread> allThreads = new HashSet<Thread>();
        final TokenBucketFilter tokenBucketFilter = new TokenBucketFilter(5);

        // Sleep for 10 seconds.
        Thread.sleep(10000);

        // Generate 12 threads requesting tokens almost all at once.
        for (int i = 0; i < 12; i++) {

            Thread thread = new Thread(new Runnable() {
                public void run() {
                    try {
                        tokenBucketFilter.getToken();
                    } catch (InterruptedException ie) {
                        System.out.println("We have a problem");
                    }
                }
            });
            thread.setName("Thread_" + (i + 1));
            allThreads.add(thread);
        }

        for (Thread t : allThreads) {
            t.start();
        }

        for (Thread t : allThreads) {
            t.join();
        }
    }
    public static void runLateThenEarlyCallback() throws InterruptedException {
        final DeferredCallbackExecutor deferredCallbackExecutor = new DeferredCallbackExecutor();

        Thread service = new Thread(new Runnable() {
            public void run() {
                try {
                    deferredCallbackExecutor.start();
                } catch (InterruptedException ie) {
                }
            }
        });

        service.start();

        Thread lateThread = new Thread(new Runnable() {
            public void run() {
                DeferredCallbackExecutor.CallBack cb = new DeferredCallbackExecutor.CallBack(8, "Hello this is the callback submitted first");
                deferredCallbackExecutor.registerCallback(cb);
            }
        });
        lateThread.start();

        Thread.sleep(3000);

        Thread earlyThread = new Thread(new Runnable() {
            public void run() {
                DeferredCallbackExecutor.CallBack cb = new DeferredCallbackExecutor.CallBack(1, "Hello this is callback sumbitted second");
                deferredCallbackExecutor.registerCallback(cb);
            }
        });
        earlyThread.start();

        lateThread.join();
        earlyThread.join();
    }

    public static void runTestCountingSemaPhore() throws InterruptedException
    {
        final CountingSemaphore cs = new CountingSemaphore(1);

        Thread t1 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        try {
                            for (int i = 0; i < 5; i++) {
                                cs.acquire();
                                System.out.println("Ping " + i);
                            }
                        } catch (InterruptedException ie) {

                        }
                    }
                }
        );

        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    try {
                        cs.release();
                        System.out.println("Pong " + i);
                    } catch (InterruptedException ie) {

                    }
                }
            }
        });

        t2.start();
        t1.start();
        t1.join();
        t2.join();
    }
}


