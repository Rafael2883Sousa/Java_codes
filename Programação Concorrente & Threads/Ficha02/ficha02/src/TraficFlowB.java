import java.util.concurrent.Semaphore;

public class TraficFlowB extends Thread {

    public Semaphore semaforoA;
    public Semaphore semaforoB;

    public TraficFlowB(Semaphore semaforoA, Semaphore semaforoB){
        this.semaforoA = semaforoA;
        this.semaforoB = semaforoB;
    }

    public void run(){
        try {
            System.out.println("TraficFlowB em espera.");
            semaforoA.acquire();
            System.out.println("TraficFlowB atravessando.");
            Thread.sleep(2000);
            System.out.println("TraficFlowB atravessou.");

            semaforoA.release();

        } catch (Exception e) {
            System.err.println(e);
        }
    }

}
    
