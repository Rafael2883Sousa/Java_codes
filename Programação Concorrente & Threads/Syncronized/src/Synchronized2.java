public class Synchronized2 implements Runnable{

    private int i = 0;

    public void run(){

        int num;
        synchronized(this){
            i++;
            num = i * 2;
        }

        double pot = Math.pow(num, i);
        double raiz = Math.sqrt(pot);
        System.out.println("Potencia de "+num+"elevado a "+i+" = "+pot);
        System.out.println("Raiz de "+pot+" = "+raiz);;
    }
    
    public static void main(String[] args) {

        Thread t0 = new Thread();
        Thread t1 = new Thread();
        Thread t2 = new Thread();

        t0.start();
        t1.start();
        t2.start();
        
    }
}
