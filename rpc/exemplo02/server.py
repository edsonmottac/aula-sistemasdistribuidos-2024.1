from user import User
import xmlrpc.server

class MyServer:
    def verify_access(self, user_data):
        
        user = User(user_data['nome_usuario'], user_data['senha'])
        
        if user.senha == "1234":
            return "Acesso permitido"
        else:
            return "Acesso negado"

server = xmlrpc.server.SimpleXMLRPCServer(("localhost", 8000), allow_none=True)
server.register_instance(MyServer())
server.serve_forever()