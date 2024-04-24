

public class Main {
    public static void main(String[] args) {
        // Criando uma instância do contador
        Contador contador = new Contador();

        // Criando uma thread para incrementar o contador
        Thread threadIncrementa = new Thread(() -> {
            // Executando 10 operações de incremento no contador
            for (int i = 0; i < 10; i++) {
                contador.incrementar();
                try {
                    Thread.sleep(500); // Atraso para visualizar os incrementos
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Criando uma thread para decrementar o contador
        Thread threadDecrementa = new Thread(() -> {
            // Executando 10 operações de decremento no contador
            for (int i = 0; i < 10; i++) {
                contador.decrementar();
                try {
                    Thread.sleep(500); // Atraso para visualizar os decrementos
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Iniciando as threads
        threadIncrementa.start();
        threadDecrementa.start();

        try {
            // Aguardando o término das threads
            threadIncrementa.join();
            threadDecrementa.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Exibindo o valor final do contador após as operações
        System.out.println("Valor final do contador: " + contador.getValor());
    }
}