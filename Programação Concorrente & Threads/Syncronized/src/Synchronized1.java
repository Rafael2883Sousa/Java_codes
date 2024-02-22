public class Synchronized1 implements Runnable{
    
    private int i;
    //static Object chave = new Object();

    public void run(){
        synchronized(this/*chave*/){
            i++;
            System.out.println(Thread.currentThread().getName()+" -> "+i);
        }
    }
    
    public static void main(String[] args) {
        
        Synchronized1 sync = new Synchronized1();

        Thread t0 = new Thread(sync);
        Thread t1 = new Thread(sync);
        Thread t2 = new Thread(sync);
        Thread t3 = new Thread(sync);
        Thread t4 = new Thread(sync);


        t0.start();
        t1.start(); 
        t2.start();
        t3.start();
        t4.start();
    }
}