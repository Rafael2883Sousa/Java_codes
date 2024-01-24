import java.util.concurrent.Semaphore;

public class Filosofos implements Runnable{
    private MesaDeJantar mesa;
    private int comendo, pensando;
    private Semaphore garfoEsquerdo, garfoDireito;
    private String nome;
    private boolean chave; 
    
    public Filosofos(String nome, MesaDeJantar mesa, Semaphore esquerdo, Semaphore direito){
        this.nome = nome;
        this.mesa = mesa;
        comendo = 0;
        pensando = 0;
        garfoEsquerdo = esquerdo;
        garfoDireito = direito;
        chave = true;
    }
    
    public Semaphore getGarfoEsquerdo(){
        return garfoEsquerdo;
    }
    
    public Semaphore getGarfoDireito(){
        return garfoDireito;
    }
    
    public int getVezesComeu(){
        return comendo;
    }
    
    public int getVezesPensou(){
        return pensando;
    }
    
    public void setChave(){
        chave = false;
    }
    
    public String getNome(){
        return nome;
    }
    
    @Override
    public void run() {
       
        while(chave){
            //Tentativa de pegar o garfo direito
            if(garfoDireito.tryAcquire()){
                //Tentativa de pegar o garfo esquerdo
                if(garfoEsquerdo.tryAcquire()){
                    //Pegou 2 garfos e esta comendo
                    mesa.comer(nome);
                    comendo++;
                    garfoEsquerdo.release();
                    garfoDireito.release();
                    
                } else {
                    //Soltar garfo direito
                    garfoDireito.release();
                }
            } else {
                //Garfos ocupados
                mesa.pensar(nome);
                pensando++;
            }
        }
    }
}
