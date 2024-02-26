public class MultiThread_Manually implements Runnable{

    private static final int num_atedentes = 3;

    public void run(){
        // Tarefa a ser executada pela Thread
        String name = Thread.currentThread().getName();
        System.out.println(name+" executando.");  
    }

    public static void main(String[] args) {

        MultiThread_Manually multi = new MultiThread_Manually();
        
        for (int i = 0; i<num_atedentes; i++){
            Thread t = new Thread(multi);
            t.start();
        }
    }
}