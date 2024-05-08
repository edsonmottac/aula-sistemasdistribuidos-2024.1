import socket
import threading

def handle_client(client_socket, addr):
    print(f"Conexão recebida de {addr}")
    try:
        while True:
            message = client_socket.recv(1024).decode()
            if not message:
                break
            print(f"Mensagem de {addr}: {message}")
    finally:
        client_socket.close()

def main():
    host = 'localhost'
    port = 8001

    server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    server_socket.bind((host, port))
    server_socket.listen(5)
    print("Servidor rodando... esperando conexões.")

    try:
        while True:
            client_socket, addr = server_socket.accept()
            client_thread = threading.Thread(target=handle_client, args=(client_socket, addr))
            client_thread.start()
    finally:
        server_socket.close()

if __name__ == "__main__":
    main()
