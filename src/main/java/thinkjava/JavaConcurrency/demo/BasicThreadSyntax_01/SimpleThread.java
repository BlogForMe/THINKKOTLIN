package thinkjava.JavaConcurrency.demo.BasicThreadSyntax_01;

/**
 * Created by jon on 16-4-15.
 * 21.2.9编码的变体
 */
public class SimpleThread extends Thread {
    private int countDown = 5;
    private static int threadCount = 0;

    public SimpleThread() {
        super(Integer.toString(++threadCount));
        start();
    }

    @Override
    public String toString() {
        return "#" + getName() + "{" +
                countDown +
                "}, ";
    }

    @Override
    public void run() {
        super.run();
        while (true) {
            System.out.print(this);
            if (--countDown == 0)
                return;
        }
    }

    public static void main(String[] args) {
        for (int i=0;i<5;i++)
            new SimpleThread();
    }
}
