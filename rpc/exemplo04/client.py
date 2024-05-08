import xmlrpc.client
def main():
    server = xmlrpc.client.ServerProxy("http://localhost:8000")
    print("Conectado ao servidor. Digite suas mensagens abaixo ('sair' para terminar):")

    while True:
        message = input()
        if message.lower() == 'sair':
            break
        response = server.display_message(message)
        print(response)

if __name__ == "__main__":
    main()
