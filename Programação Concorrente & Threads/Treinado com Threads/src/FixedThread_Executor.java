import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FixedThread_Executor {
    
    public static class Tarefa implements Callable<Integer>{

        @Override
        public Integer call() throws Exception {
            final int num1 = new Random().nextInt(5);
            final int num2 = new Random().nextInt(5,10);
            final int soma = num1 + num2;
            String name = Thread.currentThread().getName();
            System.out.println(name+": "+num1+" + "+num2+" = "+soma);
            return soma;
        }
    }
    public static void main(String[] args) {
        ExecutorService ex = Executors.newFixedThreadPool(2);
        //ExecutorService ex = Executors.newCachedThreadPool();
        try {
            Future<Integer> n1 = ex.submit(new Tarefa()); 
            Future<Integer> n2 = ex.submit(new Tarefa());
            n1.get(); // toma o valor retornado do callable
            n2.get();
            ex.shutdown(); 

        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            ex.shutdownNow();
        }
        
    }
}
