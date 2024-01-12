    /*  
    A secretaria da UM possui um sistema que pesquisa o nome de docentes em vários ficheiros mas a pesquisa tem-se tornado num processo muito demorado visto que é feita em um ficheiro de cada vez.
    Por isso foi solicitado aos alunos do terceiro Ano do curso EISC que durante uma das aulas de Programação Concorrente que os mesmos desenvolvessem uma solução que auxiliasse o pessoal da secretaria na pesquisa do nome de um determinado Docente.
    O nome do docente deverá ser indicado e o programa deverá percorrer os ficheiros e verificar se o mesmo já foi registado, caso o encontrar o programa terminará e deverá retornar o nome do ficheiro e a linha onde foi encontrado o registro.
    Para testar o programa foi fornecido 9 ficheiros contendo nome de 1000 docentes em cada ficheiro.
    */

public class Main {
    public static void main(String[] args) {
        Fila fila = new Fila();

        // Thread para produzir elementos
        Thread produtor = new Thread(() -> {
            for (int i = 1; i <= 20; i++) {
                fila.enqueue(i);
                System.out.println("Produzido: " + i);
                try {     // Tentar eliminar
                    Thread.sleep(100); // Apenas para simular um processo mais lento
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }  
        });

        // Thread para consumir elementos
        Thread consumidor = new Thread(() -> {
            for (int i = 1; i <= 20; i++) {  // deve ser consertado - trocar o for por um while(isEmpy)
                int valor = fila.dequeue();
                System.out.println("Consumido: " + valor);
                try {  // Tentar eliminar
                    Thread.sleep(100); // Apenas para simular um processo mais lento
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        produtor.start();
        consumidor.start();
        /* 
        try {                     // join de ser revisado (desnecessário)
            produtor.join();
            consumidor.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } */
    }
}