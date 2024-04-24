package shared_count;

public class ThreadContador implements Runnable {
    public void run() {
        ContadorCompartilhado.incrementar();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new ThreadContador(), 
                    "Thread-" + i).start();
        }
    }
}




