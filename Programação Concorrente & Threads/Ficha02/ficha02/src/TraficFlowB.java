import java.util.concurrent.semaphore;


public class TraficFlowB extentds Thread(){

    //public semaphore verde;
    //public semaphore vermelho;
    public boolean verde;
    public boolean vermelho;

    public void run(){
        try {
            if(vermelho){
                verde=false;
                System.out.println("TrafficFlowB opened");
                Thread.sleep(3000);
            }

        } catch (Exception e) {
            System.err.println(e);
        }
    }

}
    
