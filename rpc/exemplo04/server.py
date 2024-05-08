from xmlrpc.server import SimpleXMLRPCServer, SimpleXMLRPCRequestHandler
from socketserver import ThreadingMixIn

class ThreadedXMLRPCServer(ThreadingMixIn, SimpleXMLRPCServer):
    pass

class MessageServer:
    def display_message(self, message):
        print("Mensagem recebida:", message)
        return "Mensagem recebida com sucesso"

def main():
    server = ThreadedXMLRPCServer(("localhost", 8000), allow_none=True)
    server.register_instance(MessageServer())

    print("Servidor rodando em localhost:8000...")
    server.serve_forever()

if __name__ == "__main__":
    main()
