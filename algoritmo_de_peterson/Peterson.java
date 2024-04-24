// Controle manual da entrada e saída da seção crítica 

package algoritmo_de_peterson;

public class Peterson {

    static class Lock {
        volatile int turn = 0;
        volatile boolean[] interested = new boolean[2]; // Array of flags for two threads
    }
  
    private static Lock lock = new Lock();

    public static void main(String[] args) {
       
        Thread thread0 = new Thread(() -> {
            int thisThread = 0; // Identificador fixo para a thread
            while (true) {
                acquire(lock, thisThread);
                // Trabalho na seção crítica
                System.out.println(System.currentTimeMillis() + ": Thread 0 in critical section");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis() + ": Thread 0 out of critical section");
                release(lock, thisThread);
            }
        });

        Thread thread1 = new Thread(() -> {
            int thisThread = 1; // Identificador fixo para a thread
            while (true) {
                acquire(lock, thisThread);
                // Trabalho na seção crítica
                System.out.println(System.currentTimeMillis() + ": Thread 1 in critical section");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis() + ": Thread 1 out of critical section");
                release(lock, thisThread);
            }
        });

        thread0.start();
        thread1.start();
    }

    private static void acquire(Lock lock, int thisThread) {
        int otherThread = 1 - thisThread;
        lock.interested[thisThread] = true;
        lock.turn = otherThread;
        while (lock.interested[otherThread] && lock.turn == otherThread) {
            // Aguarda ativamente
        }
    }

    private static void release(Lock lock, int thisThread) {
        lock.interested[thisThread] = false;
    }
}
