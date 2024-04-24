package sync_object_level;

public class ThreadContador {
    public static void main(String[] args) {
        Contador contadorCompartilhado = new Contador();

        for (int i = 0; i < 10; i++) {
            new Thread(() -> contadorCompartilhado.incrementar(), 
                    "Thread-" + i).start();
        }
    }
}


