import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLock01 {

    private static Lock lock = new ReentrantLock();

    public static class Tarefa implements Runnable{

        private static int i=0;

        public void run(){
            lock.lock();
            i++;
            System.out.println(Thread.currentThread().getName()+": "+i);
            lock.unlock();
        }
    }

    public static void main(String[] args) {

        Tarefa task1 = new Tarefa();
        ExecutorService executor = Executors.newCachedThreadPool();

        for(int i=0; i<4; i++){
            executor.execute(task1);
        }
        executor.shutdown();
    }
}