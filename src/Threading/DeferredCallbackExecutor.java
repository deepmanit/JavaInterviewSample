package Threading;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Represents the class which holds the callback. For simplicity instead of
 * executing a method, we print a message.
 */

public class DeferredCallbackExecutor {
    static class CallBack {

        long executeAt;
        String message;

        public CallBack(long executeAfter, String message) {
            this.executeAt = System.currentTimeMillis() + executeAfter * 1000;
            this.message = message;
        }
    }


    PriorityQueue<CallBack> q = new PriorityQueue<CallBack>(new Comparator<CallBack>() {

        public int compare(CallBack o1, CallBack o2) {
            return (int) (o1.executeAt - o2.executeAt);
        }
    });
    ReentrantLock lock = new ReentrantLock();
    Condition newCallbackArrived = lock.newCondition();

    private long findSleepDuration() {
        long currentTime = System.currentTimeMillis();
        return q.peek().executeAt - currentTime;
    }

    // Run by the Executor Thread
    public void start() throws InterruptedException {
        long sleepFor = 0;

        while (true) {
            // lock the critical section
            lock.lock();

            // if no item in the queue, wait indefinitely for one to arrive
            while (q.size() == 0) {
                newCallbackArrived.await();
            }

            // loop till all callbacks have been executed
            while (q.size() != 0) {

                // find the minimum time execution thread should
                // sleep for before the next callback becomes due
                sleepFor = findSleepDuration();

                // If the callback is due break from loop and start
                // executing the callback
                if(sleepFor <=0)
                    break;

                // sleep until the earliest due callback can be executed
                newCallbackArrived.await(sleepFor, TimeUnit.MILLISECONDS);

            }

            // Because we have a min-heap the first element of the queue
            // is necessarily the one which is due.
            CallBack cb = q.poll();
            System.out.println(
                    "Executed at " + System.currentTimeMillis() / 1000 + " required at " + cb.executeAt / 1000
                            + ": message:" + cb.message);

            // Don't forget to unlock the critical section
            lock.unlock();
        }
    }

    // Called by Consumer Threads to register callback
    public void registerCallback(CallBack callBack) {
        lock.lock();
        q.offer(callBack);
        newCallbackArrived.signalAll();
        lock.unlock();
    }
}
