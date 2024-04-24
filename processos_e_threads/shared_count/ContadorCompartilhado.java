
package shared_count;

public class ContadorCompartilhado {
    private static int contador = 0;
    public synchronized static void incrementar() {
        int valorAtual = contador;
        // Simula algum processamento
        try {
            Thread.sleep(10); // Simula um atraso
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        contador = valorAtual + 1;
        System.out.println("Contador: " + contador + 
                    " por " + Thread.currentThread().getName());
    }
}




