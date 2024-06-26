package thinkjava.JavaConcurrency.demo.StopTaskAndCooperate_03;

import thinkjava.net.mindview.util.Print;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousCloseException;
import java.nio.channels.ClosedByInterruptException;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016/12/28.
 * NIO中断被阻塞的任务
 */
public class NIOInterruption {
    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
//        ServerSocket server = new ServerSocket(8080);
        InetSocketAddress isa = new InetSocketAddress("localhost", 8080);
        SocketChannel sc1 = SocketChannel.open(isa);
        SocketChannel sc2 = SocketChannel.open(isa);
        Future<?> f = exec.submit(new NIOBlocked(sc1));
        exec.execute(new NIOBlocked(sc2));
        exec.shutdown();
        TimeUnit.SECONDS.sleep(1);
        //Produce an interrupt via cancel;
        f.cancel(true);
        TimeUnit.SECONDS.sleep(1);
        //Release the block ny clsing the channel;
        sc2.close();

    }
}

class NIOBlocked implements Runnable {
    private final SocketChannel sc;

    public NIOBlocked(SocketChannel sc) {
        this.sc = sc;
    }

    @Override
    public void run() {
        try {
            Print.print("Waiting for read() in " + this);
            sc.read(ByteBuffer.allocate(1));
        } catch (ClosedByInterruptException e) {
            Print.print("ClosedByInterruptException");
        } catch (AsynchronousCloseException e) {
            Print.print("AsynchronousCloseException");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Print.print("Exiting NIOBlocked.run() " + this);
    }
}
