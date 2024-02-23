import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SynchronizedCollections implements Runnable{

    private static List<String> list = new ArrayList<>();
    private static int i;

    public void run(){
        synchronized(list){
            list.add("Pedido "+(i+1));
            ++i;
        }
    }

    public static void main(String[] args) throws InterruptedException {
       
        //list = Collections.synchronizedList(list);
        SynchronizedCollections collection = new SynchronizedCollections();
        
        Thread t0 = new Thread(collection);
        Thread t1 = new Thread(collection);
        Thread t2 = new Thread(collection);
        t0.start();
        t1.start();
        t2.start();

        t0.join();
        t1.join();
        t2.join();

        //Thread.sleep(500); 
        System.out.println(list);
    }
}
