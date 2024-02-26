import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThread_Executor implements Runnable{

    public void run(){
        String Thread_Name = Thread.currentThread().getName();
        System.out.println(Thread_Name+" em execução.");
    }
    public static void main(String[] args) {
            ExecutorService executor = Executors.newSingleThreadExecutor(); // 
        try {
            executor.execute(new SingleThread_Executor());
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            executor.shutdown();
        }
    }
}
