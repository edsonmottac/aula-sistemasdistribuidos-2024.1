
class ExGuardedBlock {
    private boolean condicaoDeControle;
    synchronized void guardedJoy() {
        System.out.println("Thread esperando pela condicao...");
        while (!condicaoDeControle) {
            try {
                wait();
            } catch (InterruptedException e) {e.printStackTrace();}
        }
        System.out.println("A condicao de controle foi " + 
          "satisfeita! Continuando a execucao...");
    }
    synchronized void alterarCondicaoDeControle(boolean novaCondicao) {
        System.out.println("Mudando a condicao de controle para " 
        + novaCondicao + "...");

        condicaoDeControle = novaCondicao;
        notify(); // Notifica as threads em espera que a condição mudou

        System.out.println("Condicao de controle alterada. " + 
                "Notificando as threads em espera...");
    }
}



