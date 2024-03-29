
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class JantarDosFilosofos { 

    public static void main(String[] args) throws InterruptedException {
        int numeroFilosofos = 3;
        
        System.out.println("Digite o número de filósofos: ");
        Scanner teclado = new Scanner(System.in);
        
        numeroFilosofos = teclado.nextInt();
        
        ArrayList<Filosofos> lista = new ArrayList<>(); // instanciamento de objeto lista do tipo Filósofo
        
        MesaDeJantar mesa = new MesaDeJantar();
        
        //Inserção dos filosofos dinamicos
        for(int k = 0; k < numeroFilosofos; k++){
            if(k == 0){
                lista.add(new Filosofos(k+1+"", mesa, new Semaphore(1), new Semaphore(1)));
                System.out.println("Filosofo " + (k+1));
            } else if( k == numeroFilosofos -1){
                lista.add(new Filosofos(k+1+"", mesa, lista.get(k-1).getGarfoDireito(), lista.get(0).getGarfoEsquerdo()));
                System.out.println("Filosofo " + (k+1));
            } else {
                lista.add(new Filosofos(k+1+"", mesa, lista.get(k-1).getGarfoDireito(), new Semaphore(1)));
                System.out.println("Filosofo " + (k+1));
            }
        }
        System.out.println("-- Filosofos Criados --\n");
        
        System.out.println("Digite o tempo em segundos: ");
        int timer = teclado.nextInt();
        
        System.out.println("-- Jantar --");

        //Liberando os filosofos
        for(int j=0; j < numeroFilosofos; j++){
          new Thread(lista.get(j)).start();
        }
        //esperando o tempo em segundos
        Thread.sleep(timer*1000);
    
        for(int j=0; j < numeroFilosofos; j++){
          lista.get(j).setChave(); //chave = false
        }
        
        System.out.println("-- Fim do Jantar --\n");
        //Tempo para esperar as chaves
        Thread.sleep(3000);
        
        System.out.println("-- Resultados --");
        for(int j=0; j < numeroFilosofos; j++){
            System.out.println("Filosofo "+lista.get(j).getNome()+" comeu "+lista.get(j).getVezesComeu()+" vezes.");
            System.out.println("Filosofo "+lista.get(j).getNome()+" pensou "+lista.get(j).getVezesPensou()+" vezes.");
        }
        
    }
    
}
