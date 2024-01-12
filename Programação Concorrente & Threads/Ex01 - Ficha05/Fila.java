public class Fila {
    private static final int CAPACIDADE = 10;  // capacidade do buffer
    private int[] buffer = new int[CAPACIDADE];
    private int cursor = 0;

    public synchronized void enqueue(int valor) {
        while (cursor == CAPACIDADE-1) {
            try {
                // Aguarda até que haja espaço no buffer
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        buffer[cursor] = valor;
        cursor++;

        // Notifica outros threads que podem estar esperando para consumir
        notify(); 
    }

    public synchronized int dequeue() {
        while (cursor == 0) {
            try {
                // Aguarda até que haja pelo menos um elemento no buffer
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        cursor--;
        int valor = buffer[cursor];

        // Notifica outros threads que podem estar esperando para produzir
        notify();

        return valor;
    }
} 
