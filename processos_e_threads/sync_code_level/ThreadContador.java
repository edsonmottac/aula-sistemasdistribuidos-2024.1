package sync_code_level;

public class ThreadContador {
    public static void main(String[] args) {
        RecursoCompartilhado recursoCompartilhado = new RecursoCompartilhado();

        // Criando e iniciando múltiplos threads
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(
                    () -> recursoCompartilhado.incrementar(), "Thread-" + i);
            thread.start();
        }
    }
}


