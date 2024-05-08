from jsonrpclib import Server

def main():
    server = Server('http://localhost:8080')
    result = server.add(5, 6)
    print("Resultado da soma: ", result)

if __name__ == '__main__':
    main()
