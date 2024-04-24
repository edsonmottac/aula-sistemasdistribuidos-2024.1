package sync_reentrant_lock;

class Contador {
    // Métodos synchronized que podem 
    // ser chamados reentrantemente 
    // pela mesma thread
   
    public synchronized void metodoA() {
        System.out.println("Iniciando método A");
        metodoB(); 
        System.out.println("Finalizando método A");
    }

    public synchronized void metodoB() {
        System.out.println("Iniciando método B");
        System.out.println("Finalizando método B");
    }
}

