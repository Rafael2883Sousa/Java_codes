import java.util.ArrayList;
import java.util.List;

public class SynchronizedCollections implements Runnable{

    private static List<String> list = new ArrayList<>();
    private static int i = 0;

    public void run(){
        list.add("Pedido"+i+1);
        i++;
    }

    public static void main(String[] args) throws InterruptedException {
        
        SynchronizedCollections collection = new SynchronizedCollections();

        Thread t0 = new Thread(collection);
        Thread t1 = new Thread(collection);
        Thread t2 = new Thread(collection);
        t0.start();
        t1.start();
        t2.start();
        Thread.sleep(500); 
        System.out.println(list);

    }
    
}
