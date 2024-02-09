// Programa que conta até um inteiro -> stop, saltando de jumper em jumper,
// jumper é de quanto em quanto vai contar e stop é até onde vai contar.
// estes números podem ser mudados no for loop do main.

public class Count1hundred implements Runnable{

    public int jumper;
    public int stop;


    public Count1hundred(int jumper, int stop){
        this.jumper = jumper;
        this.stop = stop;
    }

    public void run(){
        try {
            for(int i=0; i<=stop; i+=jumper){
                System.out.println(i+ " by "+ Thread.currentThread().getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        
        Count1hundred runn = new Count1hundred(2, 20);
        Thread t1 = new Thread(runn);
        t1.start();
    }

}