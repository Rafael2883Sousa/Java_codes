
import java.util.LinkedList;
import java.util.Queue;

class MyExecutorService {

    private final int numThreads;
    private final Queue<Runnable> queue;
    private final Thread[] threads;

    public MyExecutorService(int numThreads) {
        this.numThreads = numThreads;
        this.queue = new LinkedList<>();
        this.threads = new Thread[numThreads];

        for (int i = 0; i < numThreads; i++) {
            threads[i] = new Thread(() -> {
                while (true) {
                    Runnable task;
                    synchronized (queue) {
                        while (queue.isEmpty()) {
                            try {
                                queue.wait();
                            } catch (InterruptedException e) {
                                Thread.currentThread().interrupt();
                                return;
                            }
                        }
                        task = queue.poll();
                    }
                    task.run();
                }
            });
            threads[i].start();
        }
    }

    public void submit(Runnable task) {
        synchronized (queue) {
            queue.offer(task);
            queue.notify();
        }
    }

    public void shutdown() {
        for (Thread thread : threads) {
            thread.interrupt();
        }
    }

    public static void main(String[] args) {
        MyExecutorService myExecutorService = new MyExecutorService(3);

        for (int i = 0; i < 10; i++) {
            final int taskId = i;
            myExecutorService.submit(() -> {
                System.out.println("Tarefa " + taskId + " executada por " + Thread.currentThread().getName());
            });
        }

        myExecutorService.shutdown();
    }
}