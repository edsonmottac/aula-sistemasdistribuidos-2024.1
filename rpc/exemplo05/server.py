from jsonrpclib.SimpleJSONRPCServer import SimpleJSONRPCServer

def add(x, y):
    return x + y

# Configuração do servidor
def main():
    server = SimpleJSONRPCServer(('localhost', 8080))
    server.register_function(add, 'add')
    print("Servidor rodando em localhost:8080...")
    server.serve_forever()

if __name__ == '__main__':
    main()
