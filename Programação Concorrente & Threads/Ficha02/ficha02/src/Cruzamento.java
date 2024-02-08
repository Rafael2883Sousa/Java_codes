import java.util.concurrent.Semaphore;

public class Cruzamento {
    
    public static void main(String[] args) {
        
        Semaphore semaforoA = new Semaphore(1);
        Semaphore semaforoB = new Semaphore(0);

        TraficFlowA trafegoA = new TraficFlowA(semaforoA, semaforoB);
        TraficFlowB trafegoB = new TraficFlowB(semaforoA, semaforoB);

        trafegoA.start();
        trafegoB.start();
    }
}
