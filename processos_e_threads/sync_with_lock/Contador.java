
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


class Contador {
    private int valor = 0;
    private Lock lock = new ReentrantLock(); // Criando a trava

    // Método para incrementar o contador de forma segura
    public void incrementar() {
        if (lock.tryLock()) {
            try {
                valor++; // Incrementando o valor do contador
                System.out.println("Incrementando. Valor atual: " + valor);
            } finally {
                lock.unlock();
            }
        } else {
            // A trava está ocupada, tente novamente mais tarde
        }
    }

    // Método para decrementar o contador de forma segura
    public void decrementar() {
        if (lock.tryLock()) {
            try {
                if (valor > 0) {
                    valor--; // Decrementando o valor do contador
                    System.out.println("Decrementando. Valor atual: " + valor);
                }
            } finally {
                lock.unlock();
            }
        } else {
            // A trava está ocupada, tente novamente mais tarde
        }
    }

    // Método para obter o valor atual do contador de forma segura
    public int getValor() {
        lock.lock();
        try {
            return valor; // Retornando o valor atual do contador
        } finally {
            lock.unlock();
        }
    }
}