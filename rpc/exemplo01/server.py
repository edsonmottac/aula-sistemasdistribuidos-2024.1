import xmlrpc.server

class MyServer:
    def add(self, a, b):
        return a + b

server = xmlrpc.server.SimpleXMLRPCServer(("localhost", 8000), allow_none=True)
server.register_instance(MyServer())
server.serve_forever()



