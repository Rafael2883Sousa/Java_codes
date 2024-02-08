import java.util.concurrent.Semaphore;

public class TraficFlowA extends Thread {

    public Semaphore semaforoA;
    public Semaphore semaforoB;

    public TraficFlowA(Semaphore semaforoA, Semaphore semaforoB){
        this.semaforoA = semaforoA;
        this.semaforoB = semaforoB;
    }

    public void run(){
        try {
            System.out.println("TraficFlowA em espera.");
            semaforoA.acquire();
            System.out.println("TraficFlowA atravessando.");
            Thread.sleep(2000);
            System.out.println("TraficFlowA atravessou.");

            semaforoB.release();

        } catch (Exception e) {
            System.err.println(e);
        }
    }

}