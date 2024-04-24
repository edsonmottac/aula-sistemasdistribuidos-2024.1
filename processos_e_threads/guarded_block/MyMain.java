

public class MyMain {
    public static void main(String[] args) {
        ExGuardedBlock exemplo = new ExGuardedBlock();
        
        // Thread que verifica a condição
        Thread thread1 = new Thread(() -> {
            exemplo.guardedJoy();
        });
        
        // Thread que muda a condição após 3 segundos
        Thread thread2 = new Thread(() -> {
            try {
                Thread.sleep(3000); // Aguarda 3 segundos
                exemplo.alterarCondicaoDeControle(true); 
            } catch (InterruptedException e) {e.printStackTrace();}
        });

        // Inicia as threads
        thread1.start();
        thread2.start();
    }
}

