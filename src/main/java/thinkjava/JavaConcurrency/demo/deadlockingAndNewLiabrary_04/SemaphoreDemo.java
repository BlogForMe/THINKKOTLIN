package thinkjava.JavaConcurrency.demo.deadlockingAndNewLiabrary_04;

import thinkjava.net.mindview.util.Print;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by jon on 17-1-1.
 * 21.7.6 Semaphore  计数信号量
 */

class Pool<T> {
    private int size;
    private List<T> items = new ArrayList<>();
    private volatile boolean[] checkedOut;
    private Semaphore available;

    public Pool(Class<T> classObject, int size) {
        this.size = size;
        checkedOut = new boolean[size];
        available = new Semaphore(size, true);
        //Load pol with objects that can be checked out
        for (int i = 0; i < size; ++i)
            try {
                //Assumes a default constructor:
                items.add(classObject.newInstance());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
    }

    public T checkOut() throws InterruptedException {
        available.acquire();
        return getItem();
    }

    public void checkIn(T x) {
        if (releaseItem(x))
            available.release();
    }

    private boolean releaseItem(T x) {
        int index = items.indexOf(items);
        if (index == -1) return false; //Not in the list
        if (checkedOut[index]) {
            checkedOut[index] = false;
            return true;
        }
        return false;   //Wasn't checked out
    }

    public synchronized T getItem() {
        for (int i = 0; i < size; ++i)
            if (!checkedOut[i]) {
                checkedOut[i] = true;
                return items.get(i);
            }
        return null;  //Semaphore prevents reaching here
    }
}

class Fat {
    private volatile double d;//Prevent optimization
    private static int counter = 0;
    private final int id = counter++;

    public Fat() {
        //Expensive, interruptible operation;
        for (int i = 1; i < 100; i++) {
            d += (Math.PI + Math.E) / (double) i;
        }
    }

    public void operation() {
        System.out.println(this);
    }

    public String toString() {
        return "Fat id:" + id;
    }
}

class CheckoutTask<T> implements Runnable {
    private static int counter = 0;
    private final int id = counter++;
    private Pool<T> pool;

    public CheckoutTask(Pool<T> pool) {
        this.pool = pool;
    }

    @Override
    public void run() {
        try {
            T item = pool.checkOut();
            Print.print(this + "   Checkout out    " + item);
            TimeUnit.SECONDS.sleep(1);
            Print.print(this + "   Checking in     " + item);
            pool.checkIn(item);
        } catch (InterruptedException e) {
            //Acceptable way  to terminate
        }
    }

    @Override
    public String toString() {
        return "CheckoutTask " + id + " ";
    }
}


public class SemaphoreDemo {
    final static int SIZE = 25;

    public static void main(String[] args) throws Exception {
        final Pool<Fat> pool = new Pool<>(Fat.class, SIZE);
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < SIZE; i++)
            exec.execute(new CheckoutTask<>(pool));
        Print.print("ALL CheckoutTasks created");
        List<Fat> list = new ArrayList<>();
        for (int i = 0; i < SIZE; i++) {
            Fat f = pool.checkOut();
            Print.printnb(i + ": main() thread checked out ");
            f.operation();
            list.add(f);
        }

//        Future<?> blocked = exec.submit(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    //Semaphore prevents additional checkout,
//                    //so call is blocked:
//                    pool.checkOut();
//                } catch (InterruptedException e) {
//                    Print.print("checkOut() Interrupted");
//                }
//            }
//        });
//        TimeUnit.SECONDS.sleep(2);
//        blocked.cancel(true); //Break out of blocked call
        Print.print("Checking in objects in " + list);
        for (Fat f : list)
            pool.checkIn(f);
        for (Fat f : list)
            pool.checkIn(f); //Second checkIn ignored
        exec.shutdown();

    }
}
