public class Syncronized1 implements Runnable{
    
    private int i;

    public void run(){
        i++;
        System.out.println(Thread.currentThread().getName()+" -> "+i);
    }
    
    public static void main(String[] args) {
        
        Syncronized1 sync = new Syncronized1();

        Thread t0 = new Thread(sync);
        Thread t1 = new Thread(sync);
        Thread t2 = new Thread(sync);

        t0.start();
        t1.start();
        t2.start();
    }
}