
import java.util.Random;
import java.util.logging.Level; 
import java.util.logging.Logger;

public class MesaDeJantar { 
    private Random gerador; 
    
    public MesaDeJantar(){
        gerador = new Random();
    }

    public boolean comer(String f){
        System.out.println("Filosofo "+f+" Comendo");
        //Tempo de comer
        try {
            int time = gerador.nextInt(3);
            time = time*1000;
            Thread.sleep(time);
        } catch (InterruptedException ex) {
            Logger.getLogger(Filosofos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
    public boolean pensar(String f){
        System.out.println("Filosofo "+f+" Pensando");
        //Tempo de pensar
        try {
            int time = gerador.nextInt(6);
            time = time*1000;
            Thread.sleep(time);
        } catch (InterruptedException ex) {
            Logger.getLogger(Filosofos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
}
