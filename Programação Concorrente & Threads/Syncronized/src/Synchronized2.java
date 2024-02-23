public class Synchronized2 implements Runnable{

    private int i = 0;

    public void run(){

        int num;
        synchronized(this){
            i++;
            num = i * 2;

            double pot = Math.pow(num, i); // potencia de num elevado a i
            double raiz = Math.sqrt(pot); // raiz de pot
            String name = Thread.currentThread().getName();
            System.out.println(name+": Potencia de "+num+" elevado a "+i+" = "+pot);
            System.out.println("Raiz de "+pot+" = "+raiz);
        }
    }

    public static void main(String[] args) {

        Synchronized2 syncro = new Synchronized2();
        Thread t0 = new Thread(syncro);
        Thread t1 = new Thread(syncro);
        Thread t2 = new Thread(syncro);

        t0.start();
        t1.start();
        t2.start();
    }
}
