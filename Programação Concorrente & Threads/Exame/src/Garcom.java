import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.concurrent.Semaphore;

public class Garcom implements Runnable{
    
    public int garconID;
    public int CozID;
    public boolean pedido = false;
    //public Random rand;
    //public ArrayList<Integer> ListaPedidos;
    public Semaphore Cozinheiro_1;
    public Semaphore Cozinheiro_2;
    public ThreadLocal key;

    public Garcom(int ID){
        this.garconID = ID;
    }

    public void run(){
        try {
            //rand.nextInt();
            for(int i=0; i<10; i++){
                System.out.println("Garçom "+i+" iniciou um pedidio");
                pedido = true;
                Cozinheiro_1.tryAcquire();
                System.out.println("Cozinheiro "+CozID+" está processando o pedido do garcom "+ garconID);
            }
                
        } catch (Exception e) {
            e.printStackTrace();
        }
            
    } 

    public void Cozinheiro(int ID){
        this.CozID = ID;
    }

    public static boolean pedido(){
        
        //boolean pedido = true;
        while(pedido){
            ListaPedidos.add(pedido);
            
        }
        
        return pedido;
    }

    public static void main(String[] args) {
        
        Cozinheiros coz1 = new Cozinheiros(1);
        Cozinheiros coz2 = new Cozinheiros(2);

        Thread cozinheiro1 = new Thread(coz1);
        Thread cozinheiro2 = new Thread(coz2);

        for(int k=0; k<10; k++){
            Garcom gar1 = new Garcom(k);
            
        }


    }
    

}
