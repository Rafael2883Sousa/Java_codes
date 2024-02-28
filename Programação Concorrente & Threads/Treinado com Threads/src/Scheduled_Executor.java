import java.util.Random;
//import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
//import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class Scheduled_Executor {
    
    public static class Tarefa implements Runnable{

        @Override
        public void run(){
            final int num1 = new Random().nextInt(5);
            final int num2 = new Random().nextInt(5,10);
            final int soma = num1 + num2;
            String name = Thread.currentThread().getName();
            System.out.println(name+": "+num1+" + "+num2+" = "+soma);
        }
    }
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        
        ScheduledExecutorService schexecutor = Executors.newScheduledThreadPool(2);

        //schexecutor.schedule(new Tarefa(), 2, TimeUnit.SECONDS);
        schexecutor.scheduleAtFixedRate(new Tarefa(), 2, 1, TimeUnit.SECONDS);
        System.out.println(System.currentTimeMillis());
        //schexecutor.shutdown();  // usado so com o primeiro schexecutor.schedule
    }
}
