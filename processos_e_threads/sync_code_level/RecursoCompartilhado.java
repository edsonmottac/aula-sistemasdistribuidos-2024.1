package sync_code_level;

public class RecursoCompartilhado {
    private int contador = 0;
    public void incrementar() {
        
        // Bloco de código sincronizado
        synchronized (this) {
            int valorAtual = contador;
            try {
                Thread.sleep(10); // Simula algum processamento
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            contador = valorAtual + 1;
            System.out.println("Contador: " + contador + " - " + 
                Thread.currentThread().getName());
        }
    }
    public int getContador() {
        return contador;
    } 
}



