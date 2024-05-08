import socket

def main():
    host = 'localhost'
    port = 8001

    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as client_socket:
        client_socket.connect((host, port))
        print("Conectado ao servidor. Digite suas mensagens abaixo ('sair' para terminar):")

        while True:
            message = input("")
            if message.lower() == 'sair':
                break
            client_socket.sendall(message.encode())

if __name__ == "__main__":
    main()
