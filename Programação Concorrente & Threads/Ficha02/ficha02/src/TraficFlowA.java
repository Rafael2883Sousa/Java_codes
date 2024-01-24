import java.util.concurrent.semaphore;


public class TraficFlowA extentds Thread(){

    //public semaphore verde;
    //public semaphore vermelho;
    public boolean verde;
    public boolean vermelho;

    public void run(){
        try {
            if(verde){
                vermelho=false;
                System.out.println("TrafficFlowA opened");
                Thread.sleep(3000);
            }

        } catch (Exception e) {
            System.err.println(e);
        }
    }

}