import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class My_LinkedBlockingQueue implements Runnable{

    public static BlockingQueue<String> queue = new LinkedBlockingQueue<>(1);
    public final String pedido = "pedido";

    public void run(){
        synchronized(queue){
            queue.add(pedido);
            System.out.println(Thread.currentThread().getName()+" requeriu pedido.");
            System.out.println("Trabalhando o pedido.");
            System.out.println("Pedido Terminado.");
            queue.remove(); 
        }
    }

    public static void main(String[] args) throws InterruptedException {
        
        My_LinkedBlockingQueue link = new My_LinkedBlockingQueue();

        Thread t0 = new Thread(link);
        Thread t1 = new Thread(link);
        Thread t2 = new Thread(link);
        t0.start();
        t1.start();
        t2.start();
        t0.join();
        t1.join();
        t2.join();
        //System.out.println(queue);

    }
}
