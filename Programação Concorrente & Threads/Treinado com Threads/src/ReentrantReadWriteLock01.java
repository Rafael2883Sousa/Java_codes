import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLock01 {
    
    public static class Tarefa implements Runnable{

        private static ReadWriteLock rwlock = new ReentrantReadWriteLock();

        private static int i=0;

        public void run(){
            Lock writelock = rwlock.writeLock();
            writelock.lock();
            i++;
            System.out.println(Thread.currentThread().getName()+": writing "+i);
            writelock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Tarefa task2 = new Tarefa();
        
        ExecutorService executor = Executors.newCachedThreadPool();
        
        for(int i=0; i<3; i++){
            executor.execute(task2);
        }
        
        executor.shutdown();
    }

}
