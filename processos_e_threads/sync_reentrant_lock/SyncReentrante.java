package sync_reentrant_lock;
public class SyncReentrante {
    public static void main(String[] args) {
        Contador contador = new Contador();

        // Criando e iniciando duas threads
        Thread thread1 = new Thread(() -> {
            contador.metodoA();
        });

        Thread thread2 = new Thread(() -> {
            contador.metodoB();
        });

        thread1.start();
        thread2.start();
    }
}

    