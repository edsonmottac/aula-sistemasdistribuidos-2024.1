package sync_object_level;

public class Contador {
    private int valor = 0;

    // Método de instância sincronizado
    public synchronized void incrementar() {
        valor++;
        System.out.println("Valor: " + valor + " - " + 
                Thread.currentThread().getName());
    }
    
    public int getValor() {
        return valor;
    }
}


